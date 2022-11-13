package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws ParseException {

        String startTime = "2021-11-11 00:00:00";
        String endTime = "2021-11-11 00:10:00";

        String xiaojia ="2021-11-11 00:03:47";
        String xiaopi ="2021-11-11 00:10:11";

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Date d1 = sdf.parse( startTime );
        Date d2 = sdf.parse( endTime );
        Date d3 = sdf.parse( xiaojia );
        Date d4 = sdf.parse( xiaopi );

        if(d3.after(d1) && d3.before( d2 )){
            System.out.println("小贾成功");
        }else{
            System.out.println("小贾失败");
        }
        if(d4.after(d1) && d4.before( d2 )){
            System.out.println("小皮成功");
        }else{
            System.out.println("小皮失败");
        }

    }
}
