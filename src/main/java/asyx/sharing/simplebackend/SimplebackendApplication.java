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
//		int[] vowels = { 1, 1, 2, 3, 4 };
//		System.out.print(demo(vowels));
//		LocalDateTime parse = LocalDateTime.parse(LocalDateTime.now().toString(), DateTimeFormatter.ISO_INSTANT);
//		DateTimeFormatter F = DateTimeFormatter.ISO_INSTANT;
//		System.out.print(F.parse(LocalDate.now().toString()));
//		Instant i = Instant.now();
//		System.out.print(i);



//		payment();

//		numberGenerate();
//		ganjil();
		prima();
	}
	
	
//	@Bean(name = "transactionPoolExecutor")
//	public Executor getAsyncExecutor() {
//		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
////		executor.setCorePoolSize(7);
//		executor.setMaxPoolSize(42);
//		executor.setQueueCapacity(11);
//		executor.setThreadNamePrefix("transactionPoolExecutor-");
//		executor.initialize();
//		return executor;
//	}

	private static int demo(int[] A) {
//		for (int i = 0; i < A.length; i++) {
//
//			for (int j = i + 1; j < A.length; j++) {
//
//
//				int temp = 0;
//				if (A[j] < A[i]) {
//
//					temp = A[i];
//					A[i] = A[j];
//					A[j] = temp;
//				}
//			}
//
//		}
//
//		Integer[] boxedArray = new Integer[A.length];
//
//		for (int i = 0; i < A.length; i++) {
//            boxedArray[i] = Integer.valueOf(A[i]);
//        }
//		
//		List<Integer> targetList = new ArrayList<Integer>(Arrays.asList(boxedArray));
//		for (int i = 1; i < 100000; i++) {
//				if(!targetList.contains(i)) {
//					return i;
//				}
//		}
		return 0;

	}

	class response {
		LocalDateTime currentTime;
		String status;

		public LocalDateTime getCurrentTime() {
			return currentTime;
		}

		public void setCurrentTime(LocalDateTime currentTime) {
			this.currentTime = currentTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

	}

//	static Scanner input = new Scanner(System.in);
	static int balance = 0, product, money, total = 0, change = 0, options, stokBiskuit = 10, stokChips = 5,
			stokOreo = 3, stokTango = 0, stokCokelat = 4;

//	public static void payment() {
//		System.out.println("HELLO Customer!");
//		System.out.println("0. Get money back");
//		System.out.println("1. Biskuit - 6000 stok : " + stokBiskuit);
//		System.out.println("2. Chips - 8000 stok : " + stokChips);
//		System.out.println("3. Oreo - 10000 stok : " + stokOreo);
//		System.out.println("4. Tango - 12000 stok : " + stokTango);
//		System.out.println("5. Cokelat - 15000 stok : " + stokCokelat);
//		System.out.println("\nPlease select the payment method.");
//		do {
//			// enter money options
//			System.out.println("0. Stop Enter Money");
//			System.out.println("1. Enter Money");
//			options = input.nextInt();
//			if (options == 0) {
//				break;
//			}
//			// The vending machine accepts coins,
//			else if (options == 1) { // 1 for coins
//				System.out.println("Enter Money");
//				do {
//					money = input.nextInt();
//					// enter coins
//					switch (money) {
//					case 0:
//						break;
//					case 2000:
//						total += 2000;
//						break;
//					case 5000:
//						total += 5000;
//						break;
//					case 10000:
//						total += 10000;
//						break;
//					case 20000:
//						total += 20000;
//						break;
//					case 50000:
//						total += 50000;
//						break;
//					default:
//						System.out.println("Invalid Money, Please enter the new money");
//					}
//				} while (money != 0);
//			} else {
//				System.out.println("Invalid Options");
//			}
//		} while (options != 0);
//		
//		purchase();
//	}
//
//	public static void purchase() {
//		System.out.println("Please select your product.");
//		// select the product
//		product = input.nextInt();
//
//		switch (product) {
//		case 0:
//			balance += 0;
//			break;
//		case 1:
//			if (stokBiskuit > 0) {
//				balance += 6000;
//				if(chek()) stokBiskuit -= 1;
//			}
//			else
//				balance += 0;
//			break;
//		case 2:
//			if (stokChips > 0) {
//				balance += 8000;
//				if(chek()) stokChips -= 1;
//			}
//			else
//				balance += 0;
//			break;
//		case 3:
//			if (stokOreo > 0) {
//				balance += 10000;
//				if(chek()) stokOreo -= 1;
//			}
//			else
//				balance += 0;
//			break;
//		case 4:
//			if (stokTango > 0) {
//				balance += 12000;
//				if(chek()) stokTango -= 1;
//			}
//			else
//				balance += 0;
//			break;
//		case 5:
//			if (stokCokelat > 0) {
//				balance += 15000;
//				if(chek()) stokCokelat -= 1;
//			}
//			else
//				balance += 0;
//			break;
//		default:
//			System.out.println("Invalid Products");
//		}
//		
//		change();
//	}
//
//	public static void change() {
//		String changeDisplay = "";
//		if (total > balance) {
//			change = total - balance;
//			// calculate for coins
//			changeDisplay = String.valueOf(change);
//		} else {
//			changeDisplay = "Enter more money";
//		}
//
//		System.out.println("BALANCE : " + balance);
//		System.out.println("TOTAL MONEY : " + total);
//		System.out.println("CHANGE : " + changeDisplay);
//		if(chek()) {
//			balance = 0; 
//			total = 0; 
//			change = 0;
//		}
//		payment();
//	}
//	
//	public static boolean chek() {
//		return (total > balance);
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static Scanner inputNumb = new Scanner(System.in);
	public static void numberGenerate () {
		int numb = inputNumb.nextInt();
		String numbTemp = String.valueOf(numb);
		String[] split = numbTemp.split("");
		
		int iterasiZero = 1;
		String zero = "";
		for(int i=0; i<split.length; i++) {
			zero = zero + "0";		
			System.out.println(split[i]+zero);
		}
	}
	
	
	public static void ganjil() {
		int numb = inputNumb.nextInt();
		for (int i = 0; i < numb; i++) {
			if (i % 2 != 0)
				System.out.println(i);
		}
	}
	
	public static void prima() {
		int numb = inputNumb.nextInt();
		for (int i = 2; i < numb; i++) {
			if (i % 2 != 0 || i == 2)
				System.out.println(i);
		}
	}
	
	
	
	
	
	
	
	
	
	
	

}
