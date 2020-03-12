package com.lildutils.springboot.blacklist.service.dto;

public interface LDuBlacklistItemDTO<TID>
{
	TID getId();

	void setId( TID id );

	String getToken();

	void setToken( String token );

}
