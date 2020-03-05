package com.lildutils.springboot.blacklist.service.impl;

import com.lildutils.springboot.blacklist.model.LDuBlacklistItemModel;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemDTO;

public class LDuBaseBlacklistItemServiceImpl
{
	protected LDuBlacklistItemDTO convert( LDuBlacklistItemModel model )
	{
		final LDuBlacklistItemDTO dto = new LDuBlacklistItemDTO();
		if( model != null )
		{
			dto.setId( model.getId() );
			dto.setToken( model.getToken() );
		}
		return dto;
	}

}
