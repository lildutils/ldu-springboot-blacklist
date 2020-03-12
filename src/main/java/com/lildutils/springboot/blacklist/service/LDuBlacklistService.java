package com.lildutils.springboot.blacklist.service;

import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistDTO;
import com.lildutils.springboot.blacklist.service.dto.LDuBlacklistItemDTO;
import com.lildutils.springboot.blacklist.service.ex.LDuBlacklistItemNotFoundException;

public interface LDuBlacklistService<TID>
{
	/**
	 * Get all {@link LDuBlacklistItemDTO} wrapped by {@link LDuBlacklistDTO}
	 * 
	 * @return the found items in a collection
	 */
	LDuBlacklistDTO getAll();

	/**
	 * Get one {@link LDuBlacklistItemDTO} by the given id
	 * 
	 * @param id the id parameter
	 * @return the found item
	 * @throws LDuBlacklistItemNotFoundException
	 */
	LDuBlacklistItemDTO<TID> get( TID id );

	/**
	 * Get one {@link LDuBlacklistItemDTO} by the given token
	 * 
	 * @param token the token parameter
	 * @return the found item
	 * @throws LDuBlacklistItemNotFoundException
	 */
	LDuBlacklistItemDTO<TID> getByToken( String token );

	/**
	 * Insert one {@link LDuBlacklistItem} into database.meta_blacklist
	 * 
	 * @param token the token parameter
	 */
	void pinByToken( String token );

	/**
	 * Get the count of {@link LDuBlacklistItem} in database.meta_blacklist
	 * 
	 * @param token the token parameter
	 */
	long countByToken( String token );

}
