package com.stl.dms.commodity;

import java.io.Serializable;

import com.ozguryazilim.telve.entities.ViewModel;

/**
 * View Model Class
 *
 * @author
 */
public class SupplierViewModel implements ViewModel, Serializable {

	private Long id;
	private Long ids;
	
	private String name;
	private String address;
	
	
	public SupplierViewModel(Long id, Long ids, String name, String address){
		this.id = id;
		this.ids=ids;
		this.name = name;
		this.address = address;
		
		
	}
	
	

	public Long getIds() {
		return ids;
	}



	public void setIds(Long ids) {
		this.ids = ids;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof SupplierViewModel)) {
			return false;
		}
		SupplierViewModel other = (SupplierViewModel) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}




}
