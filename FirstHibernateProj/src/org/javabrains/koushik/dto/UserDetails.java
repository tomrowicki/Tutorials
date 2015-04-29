package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity (name="UD") // denotes the class as a hibernate entity class (mapping between java object and db table row)
@Table (name="Details_of_Users")
public class UserDetails {
	@Id @GeneratedValue (strategy=GenerationType.AUTO) // marks the below field as primary key, GeneratedValues forces Hibernate to generate it automatically, auto generation type is default
	@Column (name="USER_ID")
	private int userId;
	@Column (name="USER_NAME")
	@Basic // Basic says "treat it as a persistent field", this is optional, cuz Hibernate uses this on default
	private String userName;
	@Temporal (TemporalType.DATE)// Used to work with date types
	private Date joinedDate;
//	@OneToOne
//	@JoinColumn(name="VEHICLE_ID")
//	private Vehicle vehicle;
//	public Vehicle getVehicle() {
//		return vehicle;
//	}
//	public void setVehicle(Vehicle vehicle) {
//		this.vehicle = vehicle;
//	}
//	@OneToMany
//	@JoinTable(name="USER_VEHICLE", joinColumns=@JoinColumn(name="USER_ID"),
//				inverseJoinColumns=@JoinColumn(name="VEHICLE_ID"))
//	@OneToMany(mappedBy="user") // user is the dominating class that owns the vehicle class
	@ManyToMany(cascade=CascadeType.PERSIST) // saving the user also saves the corresponding vehicle instance(s)
	private Collection<Vehicle> vehicle = new ArrayList<Vehicle>(); // we can use set instead of collection ofc
		
	
	@Embedded // marks an embedded object class
	@AttributeOverrides ({
	@AttributeOverride (name="street", // since there are two addresses now, we need to override at least one column name
						column=@Column(name="HOME_STREET_NAME")),
	@AttributeOverride (name="city",
						column=@Column(name="HOME_CITY_NAME")),
	@AttributeOverride (name="state",
						column=@Column(name="HOME_STATE_NAME")),
	@AttributeOverride (name="pincode",
						column=@Column(name="HOME_PINCODE_NAME"))
	
	})
	private Address homeAddress;
	@Embedded
	private Address officeAddress;
//	@ElementCollection(fetch=FetchType.EAGER) // Hibernate requires this annotation before collections (sets), eager fetching allows for getting the data from the proxy object without the need to connect to the db
//	@JoinTable (name="USER_ADDRESS", // configuring the new table that gets created out of the below set
//				joinColumns=@JoinColumn(name="USER_ID")
//	)
////	@GenericGenerator (name = "hilo-gen", strategy="hilo") // used below
////	@CollectionId (columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long")) // configuration required to generate primary keys for ArrayList
//	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	
//	public Collection<Address> getListOfAddresses() {
//		return listOfAddresses;
//	}
//	public void setListOfAddresses(Collection<Address> listOfAddresses) {
//		this.listOfAddresses = listOfAddresses;
//	}
	@Lob // Stands for "Large object" - if the below field is of type "String" it changes into long string (bugged?), if it's "Int", then it becomes a long number type
	private String description;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName + " from getter";
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getJoinedDate() {
		return joinedDate;
	}
	public void setJoinedDate(Date joinedDate) {
		this.joinedDate = joinedDate;
	}

	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String toString()
    {
        return "[User Name: "+userName+" User Id: "+userId+" Joined Date: "+joinedDate+"]";
    }
	// @transient tells Hibernate to ignore the given field when saving to a table
	// difference between entity and data object: entity is self-contained, it can act on its own, data object is a part of a greater whole
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
}
