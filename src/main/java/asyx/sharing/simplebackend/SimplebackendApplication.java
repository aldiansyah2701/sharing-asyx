package asyx.sharing.simplebackend;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import com.fasterxml.jackson.databind.ObjectMapper;

import asyx.sharing.simplebackend.message.FakestoreapiProduct;
import asyx.sharing.simplebackend.service.BankService;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableCaching
@EnableAsync
//@EnableScheduling
@Slf4j
public class SimplebackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplebackendApplication.class, args);

	}
		
	
	
	
	
	
	
	
	
	
	

}
