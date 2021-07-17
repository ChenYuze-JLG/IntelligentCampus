package com.sevengroup.campus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.sevengroup.campus.mapper")
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }
//    public static void main(String[] args) throws ParseException {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date fromDate1 = dateFormat.parse("2018-03-01");
//        Date toDate1 = dateFormat.parse("2018-03-02");
////        Calendar calendar = new GregorianCalendar();
////        calendar.setTime(fromDate1);
////        calendar.add(Calendar.DATE,1); //把日期往后增加一天,整数  往后推,负数往前移动
//        long to1 = toDate1.getTime();
////        fromDate1 = calendar.getTime();
//        long from1 = fromDate1.getTime();
//        int days = (int) ((to1 - from1) / (1000 * 60 * 60 * 24));
//        System.out.println("两个时间之间的天数差为：" + days);
//    }
}
