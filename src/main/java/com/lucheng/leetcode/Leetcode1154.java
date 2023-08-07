package com.lucheng.leetcode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * 给日期返回是该年的第几天
 */
public class Leetcode1154 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String date = scanner.next();
        int res = dayOfYear(date);
        System.out.println("是该年的第"+res+"天");
    }

    /**
     * 依次获取年份、月份、日数
     * 根据年份判断是否是闰年
     * @param date
     * @return
     */
    public static int dayOfYear(String date) {
        //自定义闰年和非闰年的天数数组。monthDays[i]等于前i+1个月的总天数
        Integer[] monthDays = new Integer[]{31,59,90,120,151,181,212,243,273,304,334,365};
        Integer[] monthDaysRunYear = new Integer[]{31,60,91,121,152,182,213,244,274,305,335,366};
        int res = 0;
        //获取年份
        Integer year = Integer.valueOf(date.substring(0, 4));
        Integer month = Integer.valueOf(date.substring(5, 7));
        Integer day = Integer.valueOf(date.substring(8));
        if(year % 400 == 0 || (year%4==0 && year%100!=0)){
            //是闰年
            if(month == 1){
                res = day;
            }else{
                res = monthDaysRunYear[month-2]+day;
            }
        }else{
            //不是闰年
            if(month == 1){
                res = day;
            }else{
                res = monthDays[month-2]+day;
            }
        }
        return res;
    }

    /**
     * 使用日期工具类
     * @param date
     * @return
     */
    public static int dayOfYear1(String date){
        //默认的日期格式是YYYY-MM-DD
        LocalDate localDate = LocalDate.parse(date);
        return localDate.getDayOfYear();
    }

}
