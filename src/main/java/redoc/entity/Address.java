package redoc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import redoc.enums.AddressType;

@Entity
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)	
	private int addressId; // Auto-generated unique identifier (Primary key)
//	private int customerId; // Foreign key to link to Customer entity
	private String streetAddress;
	private String city;
	private String stateOrProvince;
	private String postalCode;
	private String country;
	private AddressType addressType; // Enum: Home, Business, Shipping, Billing, etc.
	private boolean isDefaultAddress;
	// ...
	public Address(int addressId, String streetAddress, String city, String stateOrProvince, String postalCode,
			String country, AddressType addressType, boolean isDefaultAddress) {
		super();
		this.addressId = addressId;
		this.streetAddress = streetAddress;
		this.city = city;
		this.stateOrProvince = stateOrProvince;
		this.postalCode = postalCode;
		this.country = country;
		this.addressType = addressType;
		this.isDefaultAddress = isDefaultAddress;
	}
	public Address() {
		super();
	}
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStateOrProvince() {
		return stateOrProvince;
	}
	public void setStateOrProvince(String stateOrProvince) {
		this.stateOrProvince = stateOrProvince;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public AddressType getAddressType() {
		return addressType;
	}
	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
	public boolean isDefaultAddress() {
		return isDefaultAddress;
	}
	public void setDefaultAddress(boolean isDefaultAddress) {
		this.isDefaultAddress = isDefaultAddress;
	}
	
	
	
	
}
