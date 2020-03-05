package com.lildutils.springboot.blacklist.service.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonAutoDetect
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class LDuBlacklistItemDTO
{
	@NotNull
	private Long	id;

	private String	token;

	public LDuBlacklistItemDTO()
	{
		super();
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
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
