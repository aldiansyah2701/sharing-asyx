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

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> bankAdd(@RequestBody RequestBankAdd request)
			throws IOException, InterruptedException {

		log.info("dummyCredential" + dummyCredential);
		return bankService.bankAdd(request);
	}

	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> bankUpdate(@RequestBody RequestBankAdd request)
			throws InterruptedException, IOException {
		bankService.updateBankInfo(request.getBankCode());
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/info/{bankCode}")
	public ResponseEntity<Object> bankInfo(@PathVariable("bankCode") String bankCode)
			throws InterruptedException, IOException {

		log.info("----Get data before call service");
		ResponseEntity<Object> dataBankInfo = bankService.getBankInfo(bankCode);
		log.info("----Get data after call proses");
		return dataBankInfo;
	}

	@DeleteMapping(value = "/delete/{bankCode}")
	public ResponseEntity<Object> bankDelete(@PathVariable("bankCode") String bankCode) {

		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping(value = "/info/external/province")
	public ResponseEntity<Object> external() throws InterruptedException, IOException {
		return bankService.getDataExternal();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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
