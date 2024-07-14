package pe.inkacola.rrhh.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import pe.inkacola.rrhh.model.Response;


@ControllerAdvice
public class ControladorExceptions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ControladorExceptions.class);

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Response> handleMethodArgumentNotValidMethod(MethodArgumentNotValidException ex) {

		LOGGER.error("EL ATRIBUTO \"" + ex.getBindingResult().getFieldError().getField().toUpperCase() + "\" " + 
				ex.getBindingResult().getFieldError().getDefaultMessage().toUpperCase());
		
		return new ResponseEntity<>(new Response(
				"EL ATRIBUTO \"" + ex.getBindingResult().getFieldError().getField().toUpperCase() + "\" " + 
				ex.getBindingResult().getFieldError().getDefaultMessage().toUpperCase()), 
				HttpStatus.BAD_REQUEST);
	}

}
