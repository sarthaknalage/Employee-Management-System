package com.sarthak.employee.management.system.employee.cntlExceHandling;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CetrallizedExceptionHandling {
	
//		Handling the IllegarArgumentException which have chances of occur in passing the id values
		@ExceptionHandler(value =IllegalArgumentException.class)
		public ResponseEntity<ExceptionModel> handleIllegalArg(IllegalArgumentException exception){
			ExceptionModel model=new ExceptionModel();
			model.setExcCode(HttpStatus.NOT_ACCEPTABLE.toString());
			model.setMsg(exception.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(model);
		}
		
//		Handling the Exception of NoSuchElementException in case we didn't get the object from db we can also customally throw it
		@ExceptionHandler(value =NoSuchElementException.class)
		public ResponseEntity<ExceptionModel> handleIllegalArg(NoSuchElementException exception){
			ExceptionModel model=new ExceptionModel();
			model.setExcCode(HttpStatus.NOT_ACCEPTABLE.toString());
			model.setMsg(exception.getMessage());
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(model);
		}


}
