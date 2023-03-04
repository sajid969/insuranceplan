/**
 * 
 */
package com.insurance.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Sajid Ahamad Shaik
 *
 */
@Entity
@Table(name = "PLAN")
@Data
@Getter
@Setter
public class Plan {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	@Column(name = "planName")
	private String planName;
	@Column(name = "activeSw")
	private String activeSw;
	
	@Column(name = "createdDate", updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name = "updatedDate", insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;
	@Column(name = "updatedBy")
	private String updatedBy;
	@Column(name = "createdBy")
	private String createdBy;

	private Integer planCategoryId;

}
