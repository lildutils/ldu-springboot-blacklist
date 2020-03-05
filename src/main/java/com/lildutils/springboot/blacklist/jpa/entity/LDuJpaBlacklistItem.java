package com.lildutils.springboot.blacklist.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.lildutils.springboot.blacklist.model.LDuBlacklistItemModel;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "meta_blacklist")
public class LDuJpaBlacklistItem implements LDuBlacklistItemModel
{
	@Id
	@GeneratedValue
	private Long	id;

	@Column(name = "tkn", nullable = false)
	private String	token;

	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private long	createdAt;

	@Column(name = "created_by", nullable = false, updatable = false)
	@CreatedBy
	private String	createdBy;

	@Column(name = "modified_at")
	@LastModifiedDate
	private long	modifiedAt;

	@Column(name = "modified_by")
	@LastModifiedBy
	private String	modifiedBy;

	public LDuJpaBlacklistItem()
	{
		super();
	}

	public Long getId()
	{
		return id;
	}

	public void setId( Long id )
	{
		this.id = id;
	}

	public String getToken()
	{
		return token;
	}

	public void setToken( String token )
	{
		this.token = token;
	}

	public long getCreatedAt()
	{
		return createdAt;
	}

	public void setCreatedAt( long createdAt )
	{
		this.createdAt = createdAt;
	}

	public String getCreatedBy()
	{
		return createdBy;
	}

	public void setCreatedBy( String createdBy )
	{
		this.createdBy = createdBy;
	}

	public long getModifiedAt()
	{
		return modifiedAt;
	}

	public void setModifiedAt( long modifiedAt )
	{
		this.modifiedAt = modifiedAt;
	}

	public String getModifiedBy()
	{
		return modifiedBy;
	}

	public void setModifiedBy( String modifiedBy )
	{
		this.modifiedBy = modifiedBy;
	}

}
