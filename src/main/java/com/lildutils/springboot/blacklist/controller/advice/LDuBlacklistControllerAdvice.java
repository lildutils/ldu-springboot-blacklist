package com.lildutils.springboot.blacklist.controller.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemNotFoundException;
import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemValidationException;

@ControllerAdvice
public class LDuBlacklistControllerAdvice extends ResponseEntityExceptionHandler
{
	@ExceptionHandler(LDuBlacklistItemValidationException.class)
	@ResponseBody
	ResponseEntity<?> handleLDuBlacklistItemValidationException( LDuBlacklistItemValidationException e )
	{
		final Map<String, String> validationErrors = new HashMap<>();
		for( Entry<String, String> entry : e.getErrors().entrySet() )
		{
			validationErrors.put( entry.getKey(), entry.getValue() );
		}
		return super.handleExceptionInternal( e, validationErrors, null, HttpStatus.BAD_REQUEST, null );
	}

	@ExceptionHandler(LDuBlacklistItemNotFoundException.class)
	@ResponseBody
	ResponseEntity<?> handleLDuBlacklistItemNotFoundException( LDuBlacklistItemNotFoundException e )
	{
		return super.handleExceptionInternal( e, e.getMessage(), null, HttpStatus.BAD_REQUEST, null );
	}

}
