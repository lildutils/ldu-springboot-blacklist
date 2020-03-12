package com.lildutils.springboot.blacklist.service.dto;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonAutoDetect
@JsonInclude(value = Include.NON_NULL)
@XmlRootElement
public class LDuBlacklistDTO
{
	private Collection<LDuBlacklistItemDTO<?>> collection;

	public LDuBlacklistDTO()
	{
		super();
	}

	public LDuBlacklistDTO( Collection<LDuBlacklistItemDTO<?>> collection )
	{
		super();
		this.collection = collection;
	}

	public Collection<LDuBlacklistItemDTO<?>> getCollection()
	{
		return collection;
	}

}
