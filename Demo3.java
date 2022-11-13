package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo3 {
    public static void main(String[] args) throws ParseException {
        //学会 SimpleDateFormat 解析字符串时间成为日期对象
        //计算2021.8.26.11.11.11 后2.14.49.6时间
        String dateStr = "2021年08月06日 11:11:11";

        //把字符串解析成日期对象
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss" );
        Date d = sdf.parse( dateStr );
        long time = d.getTime() + (2L*24*60*60 +14*60*60+49*60+6)*1000;
        //加L不会越界
        System.out.println( sdf.format( time ) );


    }
}
