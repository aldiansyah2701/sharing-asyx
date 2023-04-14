package asyx.sharing.simplebackend.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import asyx.sharing.simplebackend.exception.CustomGenericException;
import asyx.sharing.simplebackend.message.FakestoreapiProduct;
import asyx.sharing.simplebackend.message.Rating;
import asyx.sharing.simplebackend.message.RequestBankAdd;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class BankService {
	
	public ResponseEntity<Object> numberGenerate(int numb) {
		String numbTemp = String.valueOf(numb);
		String[] split = numbTemp.split("");
		List<String> resp = new ArrayList<>();
		String zero = "";
		for (int i = 0; i < split.length; i++) {
			zero = zero + "0";
			String numbMerge = split[i] + zero;
			System.out.println(numbMerge);
			resp.add(numbMerge);
		}

		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	public ResponseEntity<Object> ganjil(int numb) {
		List<String> resp = new ArrayList<>();
		for (int i = 1; i < numb; i++) {
			if (i % 2 != 0) {
				System.out.println(i);
				resp.add(String.valueOf(i));
			}
				
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}

	public ResponseEntity<Object> prima(int numb) {
		List<String> resp = new ArrayList<>();
		for (int i = 2; i < numb; i++) {
			if (i % 2 != 0 || i == 2) {
				System.out.println(i);
				resp.add(String.valueOf(i));
			}
				
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
