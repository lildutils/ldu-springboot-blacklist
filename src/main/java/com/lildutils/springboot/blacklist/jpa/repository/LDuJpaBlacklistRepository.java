package com.lildutils.springboot.blacklist.jpa.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lildutils.springboot.blacklist.jpa.entity.LDuJpaBlacklistItem;

@Repository
public interface LDuJpaBlacklistRepository extends JpaRepository<LDuJpaBlacklistItem, Long>
{
	Collection<LDuJpaBlacklistItem> findAllByToken( String token );

	Optional<LDuJpaBlacklistItem> findByToken( String token );

	LDuJpaBlacklistItem getByToken( String token );

	long countByToken( String token );

}
