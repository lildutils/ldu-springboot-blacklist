package com.lildutils.springboot.blacklist.mongodb.document;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.data.mongodb.core.mapping.Field;

import com.lildutils.springboot.blacklist.model.LDuBlacklistItemModel;

@Entity
@Table(name = "meta_blacklist")
public class LDuMongoBlacklistItem implements LDuBlacklistItemModel<String>
{
	@Field("id")
	@NotNull
	private String	id;

	@Field("tkn")
	@NotNull
	private String	token;

	public LDuMongoBlacklistItem()
	{
		super();
	}

	public String getId()
	{
		return id;
	}

	public void setId( String id )
	{
		this.id = id;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken( String token )
	{
		this.token = token;
	}

}
