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

    public static int[] getYearAndMonth() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String tsStr = sdf.format(timestamp);
        System.out.println(tsStr);
        int[] result={Integer.parseInt(tsStr.split("-")[0]), Integer.parseInt(tsStr.split("-")[1])};
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getFirstDayOfNextMonth());
        System.out.println(getLastDayOfMonth());

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;

        System.out.println(getYearAndMonth()[0] + "！！！" + getYearAndMonth()[1]);
    }
}
