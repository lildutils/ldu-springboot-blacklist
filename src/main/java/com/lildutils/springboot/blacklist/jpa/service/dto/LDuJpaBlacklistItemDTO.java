package com.lildutils.springboot.blacklist.jpa.service.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemDTO;

@JsonAutoDetect
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class LDuJpaBlacklistItemDTO implements LDuBlacklistItemDTO<Long>
{
	private Long	id;

	private String	token;

	public LDuJpaBlacklistItemDTO()
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
