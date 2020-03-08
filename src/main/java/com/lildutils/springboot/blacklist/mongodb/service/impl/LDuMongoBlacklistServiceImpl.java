package com.lildutils.springboot.blacklist.mongodb.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lildutils.springboot.blacklist.mongodb.document.LDuMongoBlacklistItem;
import com.lildutils.springboot.blacklist.mongodb.repository.LDuMongoBlacklistRepository;
import com.lildutils.springboot.blacklist.mongodb.service.LDuMongoBlacklistService;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemTokenDTO;
import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemNotFoundException;
import com.lildutils.springboot.blacklist.service.impl.LDuBaseBlacklistItemServiceImpl;
import com.lildutils.springboot.blacklist.validation.groups.LDuBlacklistItemPinValidationGroup;
import com.lildutils.springboot.blacklist.validation.groups.LDuBlacklistItemReadByTokenValidationGroup;
import com.lildutils.springboot.blacklist.validation.groups.LDuBlacklistItemReadValidationGroup;
import com.lildutils.springboot.blacklist.validation.validator.LDuBlacklistItemValidtor;

@Service
public class LDuMongoBlacklistServiceImpl extends LDuBaseBlacklistItemServiceImpl implements LDuMongoBlacklistService
{
	@Autowired
	private LDuMongoBlacklistRepository	repository;

	@Autowired
	private LDuBlacklistItemValidtor	validator;

	@Override
	public LDuBlacklistDTO getAll()
	{
		return new LDuBlacklistDTO( repository.findAll().stream().map( this::convert ).collect( Collectors.toList() ) );
	}

	@Override
	public LDuBlacklistItemDTO get( LDuBlacklistItemDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadValidationGroup.class );

		final Optional<LDuMongoBlacklistItem> model = repository.findById( dto.getId() );
		if( !model.isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( model.get() );
	}

	@Override
	public LDuBlacklistDTO getAllByToken( LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadByTokenValidationGroup.class );

		return new LDuBlacklistDTO( repository.findAllByToken( dto.getToken() ).stream().map( this::convert )
				.collect( Collectors.toList() ) );
	}

	@Override
	public LDuBlacklistItemDTO getByToken( LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadByTokenValidationGroup.class );

		final Optional<LDuMongoBlacklistItem> model = repository.findByToken( dto.getToken() );
		if( !model.isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( model.get() );
	}

	@Override
	public void pinByToken( LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemPinValidationGroup.class );

		final LDuMongoBlacklistItem model = new LDuMongoBlacklistItem();
		model.setToken( dto.getToken() );
		repository.save( model );
	}

	@Override
	public long countByToken( LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadByTokenValidationGroup.class );

		return repository.countByToken( dto.getToken() );
	}

}
