package com.jikim.data_time.api;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Main {
	public static void main(String[] args) {
		// 기계적인 시간
		Instant instant = Instant.now();
		System.out.println(instant); // 기준시 UTC, GMT
		System.out.println(instant.atZone(ZoneId.of("UTC")));

		ZoneId zoneId = ZoneId.systemDefault();
		System.out.println(zoneId);
		ZonedDateTime zonedDateTime = instant.atZone(zoneId);
		System.out.println(zonedDateTime);

		// 사람을 위한 시간
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		LocalDateTime birth = LocalDateTime.of(1996, Month.NOVEMBER, 2, 0, 0, 0);
		ZonedDateTime nowInKorea = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
		System.out.println(nowInKorea);

		Instant nowInstant = Instant.now();
		ZonedDateTime zonedDateTime1 = nowInstant.atZone(ZoneId.of("Asia/Seoul"));
		System.out.println(zonedDateTime1);

		// 기간을 표현하는 방법
		LocalDate today = LocalDate.now();
		LocalDate myBirth = LocalDate.of(2022, Month.APRIL, 20);

		Period period = Period.between(today, myBirth);
		System.out.println(period.getDays());

		Period until = today.until(myBirth);
		System.out.println(until.get(ChronoUnit.DAYS));

		Instant instantNow = Instant.now();
		Instant plus = instantNow.plus(10, ChronoUnit.SECONDS);
		Duration between = Duration.between(instantNow, plus);

		System.out.println(between.getSeconds());

		LocalDateTime now2 = LocalDateTime.now();
		DateTimeFormatter pattern = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		System.out.println(now2.format(pattern));

		LocalDate parse = LocalDate.parse("07/15/1982", pattern);
		System.out.println(parse);


		Date date = new Date();
		Instant instant1 = date.toInstant();
		Date newDate = Date.from(instant);

		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		LocalDateTime dateTime = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
		ZonedDateTime zonedDateTime2 = gregorianCalendar.toInstant().atZone(ZoneId.systemDefault());
		GregorianCalendar toGregorianCalendar = gregorianCalendar.from(zonedDateTime2);

		ZoneId zoneId1 = TimeZone.getTimeZone("PST").toZoneId();
		TimeZone timeZone = TimeZone.getTimeZone(zoneId1);

		LocalDateTime noww = LocalDateTime.now();
		LocalDateTime plus1 = noww.plus(10, ChronoUnit.DAYS);
	}
}
