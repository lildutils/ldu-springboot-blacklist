package com.lildutils.springboot.blacklist.mongodb.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.lildutils.springboot.blacklist.mongodb.document.LDuMongoBlacklistItem;

@Repository
public interface LDuMongoBlacklistRepository extends MongoRepository<LDuMongoBlacklistItem, Long>
{
	Collection<LDuMongoBlacklistItem> findAllByToken( String token );

	Optional<LDuMongoBlacklistItem> findByToken( String token );

	LDuMongoBlacklistItem getByToken( String token );

	long countByToken( String token );

}
