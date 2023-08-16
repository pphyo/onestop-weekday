package com.jdc.im.converter;

import java.sql.Date;
import java.time.MonthDay;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class MonthDayDateConverter 
		implements AttributeConverter<MonthDay, Date> {

	@Override
	public Date convertToDatabaseColumn(MonthDay attribute) {
		if(attribute != null) {
			var result = Date.valueOf(attribute.atYear(1));
			return result;
		}
		return null;
	}

	@Override
	public MonthDay convertToEntityAttribute(Date dbData) {
		if(null != dbData) {
			var ld = dbData.toLocalDate();
			var result = MonthDay.of(ld.getMonthValue(), ld.getDayOfMonth());
			return result;
		}
		return null;
	}

}
