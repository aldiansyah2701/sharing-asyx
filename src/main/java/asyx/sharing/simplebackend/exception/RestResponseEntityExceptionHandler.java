package asyx.sharing.simplebackend.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = CustomGenericException.class)
	public ResponseEntity<Object> handleCustomException(CustomGenericException ex) {

		Map<String, Object> resEx = new HashMap<String, Object>();
		resEx.put("code", "asyx");
		resEx.put("message", ex.getMessage());
		return new ResponseEntity<>(resEx, HttpStatus.BAD_REQUEST);

	}

}
