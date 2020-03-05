package com.lildutils.springboot.blacklist.service.ex;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class LDuBlacklistItemValidationException extends RuntimeException
{
	private Map<String, String> errors = new HashMap<>();

	public LDuBlacklistItemValidationException( Map<String, String> errors )
	{
		super( "VM_BLACKLISTITEM_INVALID" );
		this.errors = errors;
	}

	public LDuBlacklistItemValidationException( String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace )
	{
		super( message, cause, enableSuppression, writableStackTrace );
	}

	public LDuBlacklistItemValidationException( String message, Throwable cause )
	{
		super( message, cause );
	}

	public LDuBlacklistItemValidationException( String message )
	{
		super( message );
	}

	public LDuBlacklistItemValidationException( Throwable cause )
	{
		super( cause );
	}

	public Map<String, String> getErrors()
	{
		return errors;
	}

}
