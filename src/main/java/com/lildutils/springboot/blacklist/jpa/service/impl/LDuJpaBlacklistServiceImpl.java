package com.lildutils.springboot.blacklist.jpa.service.impl;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lildutils.springboot.blacklist.jpa.entity.LDuJpaBlacklistItem;
import com.lildutils.springboot.blacklist.jpa.repository.LDuJpaBlacklistRepository;
import com.lildutils.springboot.blacklist.jpa.service.LDuJpaBlacklistService;
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
@Transactional(readOnly = true)
public class LDuJpaBlacklistServiceImpl extends LDuBaseBlacklistItemServiceImpl implements LDuJpaBlacklistService
{
	@Autowired
	private LDuJpaBlacklistRepository	repository;

	@Autowired
	private LDuBlacklistItemValidtor	validator;

	@Override
	public LDuBlacklistDTO getAll()
	{
		return new LDuBlacklistDTO(
				repository.findAll().stream().map( this::convert ).collect( Collectors.toList() ) );
	}

	@Override
	public LDuBlacklistItemDTO get( @Valid LDuBlacklistItemDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadValidationGroup.class );

		final Optional<LDuJpaBlacklistItem> model = repository.findById( dto.getId() );
		if( !model.isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( model.get() );
	}

	@Override
	public LDuBlacklistDTO getAllByToken( @Valid LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadByTokenValidationGroup.class );

		return new LDuBlacklistDTO( repository.findAllByToken( dto.getToken() ).stream().map( this::convert )
				.collect( Collectors.toList() ) );
	}

	@Override
	public LDuBlacklistItemDTO getByToken( @Valid LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadByTokenValidationGroup.class );

		final Optional<LDuJpaBlacklistItem> model = repository.findByToken( dto.getToken() );
		if( !model.isPresent() )
		{
			throw new LDuBlacklistItemNotFoundException();
		}
		return convert( model.get() );
	}

	@Override
	@Transactional
	public void pinByToken( @Valid LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemPinValidationGroup.class );

		final LDuJpaBlacklistItem model = new LDuJpaBlacklistItem();
		model.setToken( dto.getToken() );
		repository.save( model );
	}

	@Override
	public long countByToken( @Valid LDuBlacklistItemTokenDTO dto )
	{
		validator.validate( dto, LDuBlacklistItemReadByTokenValidationGroup.class );

		return repository.countByToken( dto.getToken() );
	}

}
