package com.lildutils.springboot.blacklist.service;

import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemTokenDTO;
import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemNotFoundException;

public interface LDuBlacklistService
{
	/**
	 * Get all {@link LDuBlacklistItemDTO} wrapped by {@link LDuBlacklistDTO}
	 * 
	 * @return the found item collection
	 */
	LDuBlacklistDTO getAll();

	/**
	 * Get one {@link LDuBlacklistItemDTO} by the given id
	 * 
	 * @param dto holds the id parameter
	 * @return the found item
	 * @throws LDuBlacklistItemNotFoundException
	 */
	LDuBlacklistItemDTO get( LDuBlacklistItemDTO dto );

	/**
	 * Get all {@link LDuBlacklistItemDTO} in wrapped {@link LDuBlacklistDTO} by given token
	 * 
	 * @param dto holds the token parameter
	 * @return the found items
	 */
	LDuBlacklistDTO getAllByToken( LDuBlacklistItemTokenDTO dto );

	/**
	 * Get one {@link LDuBlacklistItemDTO} by the given token
	 * 
	 * @param dto holds the token parameter
	 * @return the found item
	 * @throws LDuBlacklistItemNotFoundException
	 */
	LDuBlacklistItemDTO getByToken( LDuBlacklistItemTokenDTO dto );

	/**
	 * Pin one {@link LDuBlacklistItem} into database.meta_blacklist
	 * 
	 * @param dto the item to pin
	 */
	void pinByToken( LDuBlacklistItemTokenDTO dto );

	/**
	 * Get the count of {@link LDuBlacklistItem} in database.meta_blacklist
	 * 
	 * @param dto holds the token parameter
	 */
	long countByToken( LDuBlacklistItemTokenDTO dto );

}
