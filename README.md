# Java-Date-API
Java 日期常用API
# 常用API、Lambda、 常见算法

## 1 日期与时间

### 1.1  Date 

Date类代表当前所在系统的日期时间信息

public Date() 创建一个Date对象，代表的是系统当前此刻日期时间。

public long getTime() 返回从1970年1月1日    00:00:00走到此刻的总的毫秒数

请计算出当前时间往后走1小时121秒之后的时间是多少。

```java
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
```

1、日期对象如何创建，如何获取时间毫秒值？
public  Date();
public long getTime();
2、时间毫秒值怎么恢复成日期对象
public Date(long time);
public void setTime(long time);

###  2.1 SimpleDateFormat

代表简单日期格式化，可以用来把日期时间格式化成为我们想要的形式

```java
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
```

格式化方法

| 格式化方法                                  | 说明                              |
| ------------------------------------------- | --------------------------------- |
| public final String **format(Date date)**   | 将日期格式化成日期/时间字符串     |
| public final String **format(Object time)** | 将时间毫秒值式化成日期/时间字符串 |

学会 SimpleDateFormat 解析字符串时间成为日期对象

```java
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
```

1、SimpleDateFormat代表什么，有什么作用？
简单日期格式化对象
可以把日期对象及时间毫秒值格式化成我们想要的字符串形式。
可以把字符串的时间形式解析成Date日期对象。
2、SimpleDateFormat的对象如何创建？
public SimpleDateFormat(String pattern)
3、SimpleDateFormat格式化，以及解析时间的方法是怎么样的？
public final String format(Date d):格式化日期对象
public final String format(Object time):格式化时间毫秒值
public Date parse(String source)：解析字符串时间

需求
某购物网站举办秒杀活动，开始时间和结束时间如左图所示，当前活动结束后，系统记录到2位用户的付款时间分别如下：
小贾下单并付款的时间为：2020年11月11日 0:03:47
小皮下单并付款的时间为：2020年11月11日 0:10:11
规则：顾客的付款时间必须在秒杀时间之内，请判断出两位顾客是否秒杀成功。

```java
package Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    public static void main(String[] args) throws ParseException {

        String startTime = "2021-11-11 00.00.00";
        String endTime = "2021-11-11 00.10.00";

        String xiaojia ="2021-11-11 00.03.47";
        String xiaopi ="2021-11-11 00.10.11";

        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy年MM月dd日 HH:mm:ss" );
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
```

### 2.1 Calendar

Calendar代表了系统此刻日期对应的日历对象。
Calendar是一个抽象类，不能直接创建对象。

| 方法名                                | 说明                        |
| ------------------------------------- | --------------------------- |
| public int get(int field)             | 取日期中的某个字段信息。    |
| public void set(int field,int value)  | 修改日历的某个字段信息。    |
| public void add(int field,int amount) | 为某个字段增加/减少指定的值 |
| public final Date getTime()           | 拿到此刻日期对象。          |
| public long getTimeInMillis()         | 拿到此刻时间毫秒值          |

注意：calendar是可变日期对象，一旦修改后其对象本身表示的时间将产生变化

1、Calendar如何去得到日历对象的？

调用方法 抽象类不能创造对象

public static Calendar getInstance() ： 获取当前日历对象

```java
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
//2022
//10
//317
//Mon Jan 16 11:46:33 CST 2023
//1673840793979
```

## 2 JDK8新增日期类

JDK8新增日期类

#### 2.1LocalTime /LocalDate / LocalDateTime

| 方法名                          | 说明               |
| ------------------------------- | ------------------ |
| public int geYear()             | 获取年             |
| public int getMonthValue()      | 获取月份（1-12）   |
| Public int getDayOfMonth()      | 获取月中第几天乘法 |
| Public int getDayOfYear()       | 获取年中第几天     |
| Public DayOfWeek getDayOfWeek() | 获取星期           |

#### 2.2 Instant

Instant时间戳
JDK8获取时间戳特别简单，且功能更丰富。Instant类由一个静态的工厂方法now()可以返回当前时间戳。

Instant instant = Instant.*now*();
 System.*out*.println("当前时间戳是：" + instant);

 Date date = Date.*from*(instant);
 System.*out*.println("当前时间戳是：" + date);

 instant = date.toInstant();
 System.*out*.println(instant);

#### 2.3 DateTimeFormatter

在JDK8中，引入了一个全新的日期与时间格式器DateTimeFormatter

#### 2.4 Duration/Period

Period
在Java8中，我们可以使用以下类来计算日期间隔差异：java.time.Period
主要是 Period 类方法 getYears()，getMonths() 和 getDays() 来计算,只能精确到年月日。
用于 LocalDate 之间的比较。

#### 2.5 ChronoUnit

ChronoUnit类可用于在单个时间单位内测量一段时间，这个工具类是最全的了，可以用于比较所有的时间单位

