package app.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;

import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
@Entity
public class Alumno {
	@Column
    private String name;
	@Column
    private String saltname;
	@Column
    private String gender;
	@Column
    private String addressCity;
	@Column
    private String addressStreet;
	@Column
    private Integer addressNumber;
	@Column
    private LocalDate birthdate;
    @Id 
    //@GeneratedValue (strategy = GenerationType.AUTO)
    private String DNI;
	@Column
    private Boolean state;
	@Column
    private String email;
	@Column
    private String numerPhono;
	@Column
    private String carrera;
	@Column
    private String profilePicture;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSaltname() {
	return saltname;
}
public void setSaltname(String saltname) {
	this.saltname = saltname;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getAddressCity() {
	return addressCity;
}
public void setAddressCity(String addressCity) {
	this.addressCity = addressCity;
}
public String getAddressStreet() {
	return addressStreet;
}
public void setAddressStreet(String addressStreet) {
	this.addressStreet = addressStreet;
}
public Integer getAddressNumber() {
	return addressNumber;
}
public void setAddressNumber(Integer addressNumber) {
	this.addressNumber = addressNumber;
}
public  LocalDate getBirthdate() {
	return birthdate;
}
public void setBirthdate(LocalDate birthdate) {
	this.birthdate = birthdate;
}
public String getDNI() {
    return DNI;
}

public void setDNI(String DNI) {
    this.DNI = DNI;
}
public Boolean getState(boolean b) {
	return state;
}
public void setState(Boolean state) {
	this.state = state;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getNumerPhono() {
	return numerPhono;
}
public void setNumerPhono(String numerPhono) {
	this.numerPhono = numerPhono;
}
public String getCarrera() {
	return carrera;
}
public void setCarrera(String carrera) {
	this.carrera = carrera;
}
public String getProfilePicture() {
	return profilePicture;
}
public void setProfilePicture(String profilePicture) {
	this.profilePicture = profilePicture;
}  

 
}
