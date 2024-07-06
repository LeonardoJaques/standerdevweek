package jaquesprojetos.standerdevweek.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {
		private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
		
		@ExceptionHandler(IllegalArgumentException.class)
		public ResponseEntity<String> handleBusinessException(IllegalArgumentException bussinessException) {
				return new ResponseEntity<>(bussinessException.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		@ExceptionHandler(NoSuchFieldException.class)
		public ResponseEntity<String> handleNoSuchFieldException(NoSuchFieldException notFoundException) {
				return new ResponseEntity<>("Resource id not found ", HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler(Throwable.class)
		public ResponseEntity<String> handleUnknownExpectedException(Throwable unknownExpectedException) {
				
				var errorMessage = "An unexpected error occurred";
				logger.error(errorMessage, unknownExpectedException);
				return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
