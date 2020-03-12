package com.lildutils.springboot.blacklist.mongodb.service.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemDTO;

@JsonAutoDetect
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class LDuMongoBlacklistItemDTO implements LDuBlacklistItemDTO<String>
{
	private String	id;

	private String	token;

	public LDuMongoBlacklistItemDTO()
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
