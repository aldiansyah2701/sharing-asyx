package asyx.sharing.simplebackend.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import asyx.sharing.simplebackend.message.RequestBankAdd;
import asyx.sharing.simplebackend.service.BankService;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/bank")
@Slf4j
public class BankController {

	@Autowired
	BankService bankService;

	@Value("${data.credential.dummy}")
	private String dummyCredential;
	
	@GetMapping(value = "/generate/numb/{numb}")
	public ResponseEntity<Object> generate(@PathVariable("numb") int numb) {
		if(numb == 0) return new ResponseEntity<>("please input valid number", HttpStatus.OK);
		ResponseEntity<Object> response = bankService.numberGenerate(numb);
		return response;
	}
	
	@GetMapping(value = "/generate/ganjil/{numb}")
	public ResponseEntity<Object> ganjil(@PathVariable("numb") int numb) {
		if(numb == 0) return new ResponseEntity<>("please input valid number", HttpStatus.OK);
		ResponseEntity<Object> response = bankService.ganjil(numb);
		return response;
	}
	
	@GetMapping(value = "/generate/prima/{numb}")
	public ResponseEntity<Object> prima(@PathVariable("numb") int numb) {
		if(numb == 0) return new ResponseEntity<>("please input valid number", HttpStatus.OK);
		ResponseEntity<Object> response = bankService.prima(numb);
		return response;
	}
	

}
