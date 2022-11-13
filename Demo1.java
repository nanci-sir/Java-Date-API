package Date;

import java.util.Date;

//使用date处理时间
public class Demo1 {
    public static void main(String[] args) {
        Date d = new Date(  );
        System.out.println( d );

        long time = d.getTime();
        System.out.println( time);
        // Sun Nov 13 10:45:08 CST 2022
        //  1668307508663
        //请计算出当前时间往后走1小时121秒之后的时间是多少
        System.out.println("*****************");
        Date d1 = new Date(  );
        System.out.println( d1);

        long time1 = System.currentTimeMillis();
        time1 +=(60*60+121)*1000;
//1
        Date d2 = new Date( time1 );
        System.out.println( d2);
//2
        d.setTime( time1 );
        System.out.println(d);
    }
}
