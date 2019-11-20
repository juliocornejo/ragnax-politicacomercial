package com.ragnax.politicacomercial.servicio.utilidades;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class DateMapper {
	/*************Las Capas de Negocios El Parseo de Fechas  ***************************/
	public static java.util.Date DateUtilToDateSantiago(java.util.Date datePais){

		TimeZone timeZone = TimeZone.getDefault();

		timeZone = TimeZone.getTimeZone("America/Santiago");
		
		Calendar calendar = new GregorianCalendar();
		
		calendar.setTimeZone(timeZone);
		
		datePais.setTime(calendar.getTimeInMillis());
		
		return datePais;
	}
	
	public static java.util.Date DateSqlToDateUtil(java.sql.Date dateSql){

		java.util.Date dateUtil=new Date();
		if(dateSql==null){
			return new Date();
		}
		else{
			dateUtil = new java.util.Date(dateSql.getTime());
		}

		return dateUtil;
	}


	public static java.sql.Date DateUtilToDateSql(java.util.Date dateUtil){

		java.sql.Date dateSql=new java.sql.Date(0);
		if(dateUtil==null){
			return dateSql;
		}
		else{
			dateSql = new java.sql.Date(dateUtil.getTime());
		}

		return dateSql;
	}

	public static java.util.Date TimestampToDateUtil(java.sql.Timestamp dateTimetamp){

		java.util.Date dateUtil=new Date();

		if(dateTimetamp==null){
			return new Date();
		}
		else{
			dateUtil = new Date(dateTimetamp.getTime());
		}

		return dateUtil;
	}

	public static Timestamp DateUtilToTimestamp(java.util.Date dateUtil){

		if(dateUtil==null){
			return new Timestamp(System.currentTimeMillis());
		}
		else{
			return new Timestamp(dateUtil.getTime());
		}
		
	}

	@SuppressWarnings("deprecation")
	public static java.util.Date SimplyDateFormatToDateUtil(String sdfDate){

		Date dateUtil =null;

		if(sdfDate==null || "".equals(sdfDate)){
			return null;
		}
		else{
			int diaT = Integer.parseInt(sdfDate.substring(0, 2));
			int montT = Integer.parseInt(sdfDate.substring(3, 5));
			int yearT = Integer.parseInt(sdfDate.substring(6, 10));
			dateUtil = new Date(yearT, montT, diaT);
		}
		return dateUtil;

	}
	
	
	public static Timestamp mapperSimplyDateFormatYYYY_MM_DDTHH_MM_SSZToTimeStamp(String sdfDate){

		Date dateUtil = AppDate.convertirStrFormatYYYY_MM_DDTHH_MM_SSToDate(sdfDate);
		
		return (dateUtil!=null)? DateUtilToTimestamp(dateUtil) : null;

	}
	
	public static Timestamp mapperSimplyDateFormatYYYY_MM_DD_HH_MM_SSToTimeStamp(String sdfDate){

		Date dateUtil = AppDate.convertirStrFormatYYYY_MM_DDTHH_MM_SSToDate(sdfDate);
		
		return (dateUtil!=null)? DateUtilToTimestamp(dateUtil) : null;

	}
	
	
	
	
	
	
	
}
