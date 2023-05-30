package com.jdc.app.convert;

import java.awt.Color;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ColorConverter implements AttributeConverter<Color, String> {

	@Override
	public String convertToDatabaseColumn(Color attr) {
		if(null != attr)
			return "%s,%s,%s".formatted(attr.getRed(), attr.getGreen(), attr.getBlue());
		return null;
	}

	@Override
	public Color convertToEntityAttribute(String data) {
		if(null != data) {
			var arr = data.split(",");
			
			return new Color(color(arr[0]), color(arr[1]), color(arr[2]));
		}
		
		return null;
	}

	private float color(String str) {
		var val = new BigDecimal(255);
		var rgb = new BigDecimal(str);
		
		return rgb.divide(val, 12, RoundingMode.HALF_UP).floatValue();
	}

}
