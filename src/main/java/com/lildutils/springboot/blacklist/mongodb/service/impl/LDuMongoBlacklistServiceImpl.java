package com.lildutils.springboot.blacklist.mongodb.service.impl;

import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lildutils.springboot.blacklist.mongodb.document.LDuMongoBlacklistItem;
import com.lildutils.springboot.blacklist.mongodb.repository.LDuMongoBlacklistRepository;
import com.lildutils.springboot.blacklist.mongodb.service.LDuMongoBlacklistService;
import com.lildutils.springboot.blacklist.mongodb.service.dto.LDuMongoBlacklistItemDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistDTO;
import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemNotFoundException;

@Service
public class LDuMongoBlacklistServiceImpl implements LDuMongoBlacklistService
{
	@Autowired
	protected LDuMongoBlacklistRepository repository;

	protected LDuMongoBlacklistItemDTO convert( LDuMongoBlacklistItem model )
	{
		final LDuMongoBlacklistItemDTO dto = new LDuMongoBlacklistItemDTO();
		if( model != null )
		{
			dto.setId( model.getId() );
			dto.setToken( model.getToken() );
		}
		return dto;
	}

	@Override
	public LDuBlacklistDTO getAll()
	{
		return new LDuBlacklistDTO( repository.findAll().stream().map( this::convert ).collect( Collectors.toList() ) );
	}

	@Override
	public LDuMongoBlacklistItemDTO get( String id )
	{
		if( !repository.findById( id ).isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( repository.getById( id ) );
	}

	@Override
	public LDuMongoBlacklistItemDTO getByToken( String token )
	{
		if( !repository.findByToken( token ).isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( repository.getByToken( token ) );
	}

	@Override
	public void pinByToken( String token )
	{
		final LDuMongoBlacklistItem model = new LDuMongoBlacklistItem();
		model.setId( String.valueOf( (new Date()).getTime() ) + token );
		model.setToken( token );
		repository.save( model );
	}

	@Override
	public long countByToken( String token )
	{
		return repository.countByToken( token );
	}

}
