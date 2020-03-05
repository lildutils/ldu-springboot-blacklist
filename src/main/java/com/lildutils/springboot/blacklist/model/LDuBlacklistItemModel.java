package com.lildutils.springboot.blacklist.model;

public interface LDuBlacklistItemModel
{
	Long getId();

	void setId( Long id );

	String getToken();

	void setToken( String token );

	long getCreatedAt();

	void setCreatedAt( long createdAt );

	String getCreatedBy();

	void setCreatedBy( String createdBy );

	long getModifiedAt();

	void setModifiedAt( long modifiedAt );

	String getModifiedBy();

	void setModifiedBy( String modifiedBy );

}
