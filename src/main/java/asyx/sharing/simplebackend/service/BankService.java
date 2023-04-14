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

	public static ObjectWriter objectWriter = new ObjectMapper().writerWithDefaultPrettyPrinter();

	public ResponseEntity<Object> bankAdd(RequestBankAdd request) throws IOException, InterruptedException {
//		String writeValueAsString = objectWriter.writeValueAsString(request);
//		log.info("data : " + writeValueAsString);
//		log.info("bankCode, " + request.getBankCode());

		if (request.getBankCode().equals("000"))
			throw new CustomGenericException("cannot use bank code 000");

		return new ResponseEntity<>(HttpStatus.OK);
	}

	public ResponseEntity<Object> getDataExternal() throws InterruptedException, IOException {
		HttpRequest request = 
				HttpRequest.newBuilder()
				.uri(URI.create("https://api.rajaongkir.com/starter/province"))
				.headers("key", "766038aafa282632fb8bd394dd49102b").GET().build();


		HttpResponse<String> responseHttp = 
				HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build()
				.send(request, BodyHandlers.ofString());

		return new ResponseEntity<>(responseHttp.body(), HttpStatus.OK);
	}

	@Cacheable("bank")
	public ResponseEntity<Object> getBankInfo(String bankCode) throws InterruptedException, IOException {
		log.info("----Sleep for 4 Secs.. backend call.-----");
		Thread.sleep(1000 * 4);
		return new ResponseEntity<>(bankCode, HttpStatus.OK);
	}

	@CacheEvict(value = "bank", allEntries = true)
	public ResponseEntity<Object> updateBankInfo(String bankCode) throws InterruptedException, IOException {
		return new ResponseEntity<>(bankCode, HttpStatus.OK);
	}
	
	
	public static void fakestoreapi() throws IOException, InterruptedException {
		HttpRequest request = 
				HttpRequest.newBuilder()
				.uri(URI.create("https://fakestoreapi.com/products")).GET().build();

		HttpResponse<String> responseHttp = 
				HttpClient.newBuilder().followRedirects(HttpClient.Redirect.ALWAYS).build()
				.send(request, BodyHandlers.ofString());
		log.info("product : {} ", responseHttp.body());
		ObjectMapper objectMapper = new ObjectMapper();
		FakestoreapiProduct nemo = new FakestoreapiProduct();
		JsonFactory jfactory = new JsonFactory();
//		objectMapper.readValue(new File("c:\\user.json"), Rating.class);

		
	}
	
	
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
