package Date;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;

public class Demo2 {
    public static void main(String[] args) {
        Date d = new Date(  );
        System.out.println( d );
        //格式化日期对象
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss EEE a" );
        //开始格式化日期对象
        String rs = sdf.format( d );
        System.out.println( rs );
        //格式化时间毫米值
        //121秒后时间
        long time1 = System.currentTimeMillis()+ 121*1000;
        String rs2 = sdf.format( time1 );
        System.out.println( rs2 );



    }
}
