package com.jdc.balance.model.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jdc.balance.model.BalanceApiException;
import com.jdc.balance.model.dto.ErrorResult.ErrorType;

@Service
public class ParserService {

	public List<String> parse(MultipartFile file) {
		
		List<String> result = new ArrayList<>();
		
		try(var reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
			
			String line = null;
			
			while(null != (line = reader.readLine()))
				result.add(line);
			
		} catch (Exception e) {
			throw new BalanceApiException(ErrorType.Platform, List.of(e.getMessage()));
		}
		
		return result;
	}
	
}
