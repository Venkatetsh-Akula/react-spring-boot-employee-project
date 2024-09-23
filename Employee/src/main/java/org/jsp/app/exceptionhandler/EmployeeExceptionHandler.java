package org.jsp.app.exceptionhandler;

import org.jsp.app.excption.InvalidEmployeeData;
import org.jsp.app.excption.UserNotFoundException;
import org.jsp.app.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandler {
		@ExceptionHandler(UserNotFoundException.class)
		public ResponseEntity<?> noUserFoundException(UserNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
					.message("User Not Found Exception").body(e.getMessage()).build());
		}
		@ExceptionHandler(InvalidEmployeeData.class)
		public ResponseEntity<?> invalidEmployeeData(InvalidEmployeeData e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(ResponseStructure.builder().httpcode(HttpStatus.NOT_FOUND.value())
					.message("Invalid Employee Data").body(e.getMessage()).build());
		}
}
