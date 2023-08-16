package com.jdc.im.converter;

import org.hibernate.boot.MetadataBuilder;
import org.hibernate.boot.spi.MetadataBuilderContributor;

public class RegisterConverter implements MetadataBuilderContributor {
	
	@Override
	public void contribute(MetadataBuilder metadataBuilder) {
		metadataBuilder.applyAttributeConverter(MonthDayDateConverter.class);
	}

}
