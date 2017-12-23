package com.test.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "configuration_information_list")
public class Configuration_information_list implements Serializable{
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private int row_id;

	private String caller_material_classification ;
	private String caller_material_id ;
	private String called_material_id ;
	private String calling_method ;
	private int version_no ;
	


	public int getRow_id() {
		return row_id;
	}
	public void setRow_id(int row_id) {
		this.row_id = row_id;
	}
	public String getCaller_material_classification() {
		return caller_material_classification;
	}
	public void setCaller_material_classification(
			String caller_material_classification) {
		this.caller_material_classification = caller_material_classification;
	}
	public String getCaller_material_id() {
		return caller_material_id;
	}
	public void setCaller_material_id(String caller_material_id) {
		this.caller_material_id = caller_material_id;
	}
	public String getCalled_material_id() {
		return called_material_id;
	}
	public void setCalled_material_id(String called_material_id) {
		this.called_material_id = called_material_id;
	}
	public String getCalling_method() {
		return calling_method;
	}
	public void setCalling_method(String calling_method) {
		this.calling_method = calling_method;
	}
	public int getVersion_no() {
		return version_no;
	}
	public void setVersion_no(int version_no) {
		this.version_no = version_no;
	}
	 
}

