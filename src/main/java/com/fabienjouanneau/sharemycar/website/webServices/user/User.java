package com.fabienjouanneau.sharemycar.website.webServices.user;
import com.fabienjouanneau.sharemycar.website.webServices.advert.Advert;
import com.fabienjouanneau.sharemycar.website.webServices.booking.Booking;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-advert")
    private List<Advert> adverts;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-booking")
    private List<Booking> bookings;

    private String firstName;
    private String lastName;
    private Date birthdate;
    private String email;
    private String password;
    private String phoneNumber;
    private String role;

    private String addressStreet;
    private String addressZipCode;
    private String addressCityName;
    private String addressCountryName;

    private String ribOwnerFullName;
    private String ribBankName;
    private String ribIbanNumber;
    private String ribBicCode;

    private String drivingLicenceOwner;
    private String drivingLicenceNumber;
    private Date drivingLicenceDate;

    public User(){}

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firsName) {
        this.firstName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressZipCode() {
        return addressZipCode;
    }

    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    public String getAddressCityName() {
        return addressCityName;
    }

    public void setAddressCityName(String addressCityName) {
        this.addressCityName = addressCityName;
    }

    public String getAddressCountryName() {
        return addressCountryName;
    }

    public void setAddressCountryName(String addressCountryName) {
        this.addressCountryName = addressCountryName;
    }

    public String getRibOwnerFullName() {
        return ribOwnerFullName;
    }

    public void setRibOwnerFullName(String ribOwnerFullName) {
        this.ribOwnerFullName = ribOwnerFullName;
    }

    public String getRibBankName() {
        return ribBankName;
    }

    public void setRibBankName(String ribBankName) {
        this.ribBankName = ribBankName;
    }

    public String getRibIbanNumber() {
        return ribIbanNumber;
    }

    public void setRibIbanNumber(String ribIbanNumber) {
        this.ribIbanNumber = ribIbanNumber;
    }

    public String getRibBicCode() {
        return ribBicCode;
    }

    public void setRibBicCode(String ribBicCode) {
        this.ribBicCode = ribBicCode;
    }

    public String getDrivingLicenceOwner() {
        return drivingLicenceOwner;
    }

    public void setDrivingLicenceOwner(String drivingLicenceOwner) {
        this.drivingLicenceOwner = drivingLicenceOwner;
    }

    public String getDrivingLicenceNumber() {
        return drivingLicenceNumber;
    }

    public void setDrivingLicenceNumber(String drivingLicenceNumber) {
        this.drivingLicenceNumber = drivingLicenceNumber;
    }

    public Date getDrivingLicenceDate() {
        return drivingLicenceDate;
    }

    public void setDrivingLicenceDate(Date drivingLicenceDate) {
        this.drivingLicenceDate = drivingLicenceDate;
    }
}
