package redoc.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import redoc.enums.Gender;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int customerId; // Auto-generated unique identifier (Primary key)
	
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private LocalDate dateOfBirth;
	private Gender gender; // Enum: Male, Female, Non-binary, Other
	private boolean membershipStatus;
	private LocalDateTime registrationDate;
	private LocalDateTime lastPurchaseDate;
	private int totalPurchases;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(referencedColumnName = "customerId")
	private List<Address> address;
	// ...

	public Customer(int customerId, String firstName, String lastName, String email, String phoneNumber,
			LocalDate dateOfBirth, Gender gender, boolean membershipStatus, LocalDateTime registrationDate,
			LocalDateTime lastPurchaseDate, int totalPurchases, List<Address> address) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.membershipStatus = membershipStatus;
		this.registrationDate = registrationDate;
		this.lastPurchaseDate = lastPurchaseDate;
		this.totalPurchases = totalPurchases;
		this.address = address;
	}
	public Customer() {
		super();
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public boolean isMembershipStatus() {
		return membershipStatus;
	}
	public void setMembershipStatus(boolean membershipStatus) {
		this.membershipStatus = membershipStatus;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	public LocalDateTime getLastPurchaseDate() {
		return lastPurchaseDate;
	}
	public void setLastPurchaseDate(LocalDateTime lastPurchaseDate) {
		this.lastPurchaseDate = lastPurchaseDate;
	}
	public int getTotalPurchases() {
		return totalPurchases;
	}
	public void setTotalPurchases(int totalPurchases) {
		this.totalPurchases = totalPurchases;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}

	
	
	
	
}
