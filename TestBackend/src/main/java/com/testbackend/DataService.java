package com.testbackend;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(
	    name = "datas"
	    
	)
public class DataService {
	
	@Id
	private long id;
	private String data;
	
	
	public DataService() {
	   
	}
	

	public DataService(long id, String data) {
		
		this.id = id;
		this.data = data;
	}




	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}


	@Override
	public String toString() {
		return "DataService [id=" + id + ", data=" + data + "]";
	}
	
	
	

}
