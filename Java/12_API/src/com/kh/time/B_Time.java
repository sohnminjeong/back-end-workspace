package com.kh.time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/*
 * java.util 패키지
 * - Date돠 Calendar의 단점을 개선한 새로운 클래스들을 제공 (JDK 1.8)
 * - LocalDate, LocalTime, LocaldateTime, ZondexDateTimr 클래스 포함 
 * - 날짜와 시간에 대한 다양한 메서드를 제공
 * */
public class B_Time {

	public static void main(String[] args) {
		
		B_Time b = new B_Time();
		//b.method1();
		//b.method2();
		b.method3();
	}
	
	public void method1() {
		/*
		 * LocalDateTime
		 * - 날짜와 시간 정보를 모두 저장
		 * */
		LocalDateTime now = LocalDateTime.now();
		System.out.println("today : " + now);
		
		// 날짜 지정
		LocalDateTime when = LocalDateTime.of(2024, 05, 16, 17, 50, 00);
		System.out.println("when : " + when);
		
		// ZonedDateTime : LocalDateTime + 시간대
		System.out.println("ZondedDateTime : " + ZonedDateTime.now());
		
		// 년, 월, 일,요일, 시, 분, 초
		System.out.println(now.getYear() + "년");
		System.out.println(now.getMonth() + "월"); // January
		System.out.println(now.getMonthValue() + "월"); 
		System.out.println(now.getDayOfMonth() + "일");
		System.out.println(now.getDayOfWeek());    // monthay
		System.out.println(now.getHour() + "시");
		System.out.println(now.getMinute() + "분");
		System.out.println(now.getSecond() + "초");
		
		System.out.println();
		
		// 날짜 조작 : plus(현재에서 +), minus(현재에서 -), with(지정날짜)
		LocalDateTime plusDays = now.plusDays(1).plusMonths(1).plusYears(1);
		System.out.println("plusDays : " + plusDays);   // plusDays : 2025-02-28T11:02:05.330379
		
		LocalDateTime minusDays = now.minusYears(1).minusMonths(1).minusDays(1);
		System.out.println("minusDays : " + minusDays);   // minusDays : 2022-12-28T11:04:23.809530700
		
		LocalDateTime withDays = now.withYear(2025).withMonth(3).withDayOfMonth(10);
		System.out.println("withDays : " + withDays);  // withDays : 2025-03-10T11:05:22.463329700
		
		System.out.println("isAfter : " + now.isAfter(withDays));  // 오늘이 해당 날짜보다 이후인가?  false
		System.out.println("isBefore : " + now.isBefore(withDays));  // 오늘이 해당 날짜보다 이전인가?  true
		
		// LocalDate : 날짜 정보를 저장
		LocalDate localDate = LocalDate.now();
		System.out.println("localDate : " + localDate);    // localDate : 2024-01-29
		localDate = LocalDate.of(2024, 12, 25);
		System.out.println("localDate2 : " + localDate);   // localDate2 : 2024-12-25
		
		// LocalTime : 시간 정보만을 저장
		LocalTime localTime = LocalTime.now();
		System.out.println("localTime : " + localTime);    // localTime : 11:12:30.641736100
		localTime = LocalTime.of(17, 49, 59);
		System.out.println("localTime2 : " + localTime);   // localTime2 : 17:49:59
		
	}

	
	/*
	 * Period와 Duration
	 * - 날짜와 시간 간격을 표현하기 위한 클래스 
	 * - Period : 두 날짜 간의 차이
	 * - Duration : 시간의 차이 
	 * */
	public void method2() {
		
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		// between : 두 날짜의 차이 (until - 별반 차이 X) 보이는 메서드 
		Period pe = Period.between(date1, date2);
		System.out.println("pe : " + pe);   // pe : P1Y11M30D(년월일)
		
		System.out.println("years : " + pe.getYears());    // years : 1
		System.out.println("years : " + pe.get(ChronoUnit.YEARS));   // years : 1
		
		System.out.println("months : " + pe.getMonths());    // months : 11
		System.out.println("months : " + pe.get(ChronoUnit.MONTHS));   // months : 11
		
		System.out.println("days : " + pe.getDays());   // days : 30
		System.out.println("days : " + pe.get(ChronoUnit.DAYS));    // days : 30
		
		LocalTime time1 = LocalTime.of(0, 0, 0);
		LocalTime time2 = LocalTime.of(11, 23, 55);
		
		Duration du = Duration.between(time1, time2);
		System.out.println("du : " + du);    // du : PT11H23M55S
		
		System.out.println("hour : " + du.toHours());   // hour : 11
		System.out.println("minutes : " + du.toMinutes());   // minutes : 683(시, 분을 전부 분으로 표시)
		System.out.println("seconds : " + du.toSeconds());   // seconds : 41035(시,분,초를 전부 초로 표시)
		
		// 문자열을 LocalDate 객체로 파싱(원하는 객체로 바꿈 ex.문자열을 날짜로)
		LocalDate date = LocalDate.parse("2024-02-08");
		System.out.println("date : " + date);   // date : 2024-02-08
		
		// DateTimeFormatter
		// 날짜와 시간을 포맷팅(Formatting)된 문자열로 변환하는 메서드를 제공하는 클래스 
		LocalDateTime today = LocalDateTime.now();
		DateTimeFormatter ofPattern = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		String formatDate = today.format(ofPattern);
		System.out.println(formatDate);   // 2024-01-29 11:34:53
		
	}
	// D-Day 계산기 : 년월일을 입력하여 디데이 계산
	// ChronoUnit.Days.between 또는 날짜.until(날짜, ChronoUnit.DAYS)
	public void method3() {
		Scanner sc = new Scanner(System.in);
		// 오늘 날짜
		LocalDate today = LocalDate.now();
		
		System.out.println("년 : ");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("월 : ");
		int month = Integer.parseInt(sc.nextLine());
		System.out.println("일 : ");
		int day = Integer.parseInt(sc.nextLine());
		
		// 입력할 날짜 
		LocalDate inputDate = LocalDate.of(year, month, day);
		
		// 반환타입 확인(ChronoUnit.Days.between()반환타입은 long)
		long dDay = ChronoUnit.DAYS.between(today, inputDate);
		// 둘 다 가능! 
		dDay = today.until(inputDate, ChronoUnit.DAYS);
		
		if(dDay == 0) {
			System.out.println("D-Day");
		} else if(dDay < 0) {
			System.out.println("D+" + -dDay);
		} else {
			System.out.println("D-" + dDay);
		}
			
	}
	
}
