package br.com.gianweigert.dealership.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
	
	@Column(name = "updated_at", nullable = false)
	protected Date updatedAt;
	
	@Column(name = "created_at", nullable = false)
	protected Date createdAt;
	
	@Column(name = "enabled", nullable = false)
	protected boolean enabled = false;
	
	public AbstractEntity() {
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}
	
	public Date getCreatedAt() {
		return this.createdAt;
	}
	
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedAt() {
		return this.updatedAt;
	}
	
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	public boolean isEnabled() {
		return this.enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
