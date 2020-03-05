package com.lildutils.springboot.blacklist.service.dto;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonAutoDetect
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class LDuBlacklistItemTokenDTO
{
	@NotNull
	private String token;

	public LDuBlacklistItemTokenDTO()
	{
		super();
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
