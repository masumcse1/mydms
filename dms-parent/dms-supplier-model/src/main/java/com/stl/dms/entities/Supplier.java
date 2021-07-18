package com.stl.dms.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.ozguryazilim.telve.entities.AuditBase;

@Entity	
@Table( name = "tco_supplier" )
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Supplier  extends AuditBase{
	
	    private static final long serialVersionUID = 1L;
	
	    // @Id @GeneratedValue( strategy = GenerationType.AUTO, generator="genericSeq")
	    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="ID")
	    private Long id;

	    @Column(name = "name", unique = true)
	    @NotNull
	    private String name;
	    
	    
	    @Column(name = "address", unique = true)
	    @NotNull
	    private String address;


	    
	    @Override
	    public Long getId() {
	        return id;
	    }

	 

		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getAddress() {
			return address;
		}


		public void setAddress(String address) {
			this.address = address;
		}


		public void setId(Long id) {
			this.id = id;
		}
		
		
	    
	    


}

/*
CREATE TABLE `bank`.`tco_supplier` (
		  `id` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
		  `name` VARCHAR(45) NOT NULL,
		  `address` VARCHAR(45) NOT NULL,
		  PRIMARY KEY (`id`)
		)
		ENGINE = InnoDB;

*/
