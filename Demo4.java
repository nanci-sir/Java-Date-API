package Date;

import java.util.Calendar;
import java.util.Date;

public class Demo4 {
    public static void main(String[] args) {
        //1. 取日期中的某个字段信息。
        Calendar cal = Calendar.getInstance();
        System.out.println( cal );

        //2. 修改日历的某个字段信息。
        int year = cal.get(Calendar.YEAR);
        System.out.println( year );
        int month= cal.get(Calendar.MONTH);
        System.out.println( month );
        int days = cal.get(Calendar.DAY_OF_YEAR);
        System.out.println( days );
        // 3. 为某个字段增加/减少指定的值 一般不修改
      //  cal.set( Calendar.HOUR,16 );
     //   System.out.println( cal );
        //64天后时间
        cal.add(Calendar.DAY_OF_YEAR,64);

        //4.  拿到此刻日期对象。
       Date d =  cal.getTime();
        System.out.println( d );
        //5. 拿到此刻时间毫秒值
        long time = cal.getTimeInMillis();
        System.out.println( time );
    }
}
