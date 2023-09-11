package com.jdc.location.model.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.location.model.LocationBusinessException;

@Service
public class ParserService {

	public List<String> parse(MultipartFile file) {
		
		var result = new ArrayList<String>();
		
		try(var br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			String line;
			
			while(null != (line = br.readLine())) {
				result.add(line);
			}
			
		} catch(IOException e) {
			throw new LocationBusinessException("File Upload Error!");
		}
		
		return result;
	}
	
}
