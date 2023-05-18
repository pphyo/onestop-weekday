package com.jdc.st_import;

import static com.jdc.st_import.other.GeneralImport.*;
import static java.lang.System.out;

import java.util.Date;

import com.jdc.st_import.other.GeneralImport;

public class StImportApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
	
		Date d = new Date(10L);
		
		java.sql.Date sqlDate = new java.sql.Date(1000L);
		
		out.println(stValue);
		
		showStValue();
		
		GeneralImport imp = new GeneralImport();
		imp.showInstValue();

	}

}
