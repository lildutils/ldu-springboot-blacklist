package com.lildutils.springboot.blacklist.model;

public interface LDuBlacklistItemModel<TID>
{
	TID getId();

	void setId( TID id );

	String getToken();

	void setToken( String token );

}
