package com.lildutils.springboot.blacklist.jpa.service.impl;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lildutils.springboot.blacklist.jpa.entity.LDuJpaBlacklistItem;
import com.lildutils.springboot.blacklist.jpa.repository.LDuJpaBlacklistRepository;
import com.lildutils.springboot.blacklist.jpa.service.LDuJpaBlacklistService;
import com.lildutils.springboot.blacklist.jpa.service.dto.LDuJpaBlacklistItemDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistDTO;
import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemNotFoundException;

@Service
public class LDuJpaBlacklistServiceImpl implements LDuJpaBlacklistService
{
	@Autowired
	protected LDuJpaBlacklistRepository repository;

	protected LDuJpaBlacklistItemDTO convert( LDuJpaBlacklistItem model )
	{
		final LDuJpaBlacklistItemDTO dto = new LDuJpaBlacklistItemDTO();
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
	public LDuJpaBlacklistItemDTO get( Long id )
	{
		if( !repository.findById( id ).isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( repository.getOne( id ) );
	}

	@Override
	public LDuJpaBlacklistItemDTO getByToken( String token )
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
		final LDuJpaBlacklistItem model = new LDuJpaBlacklistItem();
		model.setToken( token );
		repository.save( model );
	}

	@Override
	public long countByToken( String token )
	{
		return repository.countByToken( token );
	}

}
