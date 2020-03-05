package com.lildutils.springboot.blacklist.service.ex;

@SuppressWarnings("serial")
public class LDuBlacklistItemNotFoundException extends RuntimeException
{
	public LDuBlacklistItemNotFoundException()
	{
		super( "VM_BLACKLISTITEM_NOT_FOUND" );
	}

	public LDuBlacklistItemNotFoundException( String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace )
	{
		super( message, cause, enableSuppression, writableStackTrace );
	}

	public LDuBlacklistItemNotFoundException( String message, Throwable cause )
	{
		super( message, cause );
	}

	public LDuBlacklistItemNotFoundException( String message )
	{
		super( message );
	}

	public LDuBlacklistItemNotFoundException( Throwable cause )
	{
		super( cause );
	}

}
