package util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    public static Timestamp getLastDayOfMonth() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DATE));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        date = date + " 23:59:59";
        try {
            return new Timestamp(format.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return new Timestamp(new Date().getTime());
        }
    }

    public static Timestamp getFirstDayOfNextMonth() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, 1);
        cal.set(Calendar.DAY_OF_MONTH, cal.getMinimum(Calendar.DATE));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = new SimpleDateFormat("yyyy-MM-dd ").format(cal.getTime());
        date = date + " 00:00:01";
        try {
            return new Timestamp(format.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return new Timestamp(new Date().getTime());
        }
    }

    public static Date getFirstDayOfMonth() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String tsStr = sdf.format(timestamp);

        Date d  = new Date();
        try {
            sdf = new SimpleDateFormat("yyyy-MM-dd");
            d  = sdf.parse(tsStr.substring(0, 8) + "01");
        }catch (Exception e){
            e.printStackTrace();
        }

        return d;
    }

    public static double getMonthRadio() {
        Calendar cal = Calendar.getInstance();
        int maxDate = cal.getActualMaximum(Calendar.DATE);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String tsStr = sdf.format(timestamp);
//        System.out.println(tsStr);
        int today = Integer.parseInt(tsStr.split("-")[2].split(" ")[0]);

        return (double) today / (double) maxDate;
    }
}
