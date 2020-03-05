package com.lildutils.springboot.blacklist.mongodb.document;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Field;

import com.lildutils.springboot.blacklist.model.LDuBlacklistItemModel;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "meta_blacklist")
public class LDuMongoBlacklistItem implements LDuBlacklistItemModel
{
	@Id
	private Long	id;

	@Field("created_at")
	@CreatedDate
	private long	createdAt;

	@Field("created_by")
	@CreatedBy
	private String	createdBy;

	@Field("modified_at")
	@LastModifiedDate
	private long	modifiedAt;

	@Field("modified_by")
	@LastModifiedBy
	private String	modifiedBy;

	@Field("tkn")
	private String	token;

	public LDuMongoBlacklistItem()
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

	public String getToken()
	{
		return token;
	}

	public void setToken( String token )
	{
		this.token = token;
	}

}
