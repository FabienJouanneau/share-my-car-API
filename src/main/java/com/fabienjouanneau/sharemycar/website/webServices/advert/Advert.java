package com.fabienjouanneau.sharemycar.website.webServices.advert;

import com.fabienjouanneau.sharemycar.website.webServices.booking.Booking;
import com.fabienjouanneau.sharemycar.website.webServices.carOption.CarOption;
import com.fabienjouanneau.sharemycar.website.webServices.picture.Picture;
import com.fabienjouanneau.sharemycar.website.webServices.user.User;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Advert {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long advertId;

    private String name;
    private String carBrand;
    private String carModel;
    private String carRegistrationDate;
    private Long carKilometers;
    private Integer carPricePerDay;
    private String carEnergy;
    private String carMotor;

    @ManyToOne()
    @JsonBackReference(value = "user-advert")
    private User user;

    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            scope = Booking.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "bookingId")
    private List<Booking> bookings;


    @OneToMany(mappedBy = "advert", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "advert-picture")
    private List<Picture> pictures;

    @ManyToMany(mappedBy = "adverts", fetch = FetchType.LAZY)
    @JsonIdentityInfo(
            scope = CarOption.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "carOptionId")
    @JsonIdentityReference(alwaysAsId = true)
    private List<CarOption> carOptions  = new ArrayList<>();



    public Advert(){}

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarRegistrationDate() {
        return carRegistrationDate;
    }

    public void setCarRegistrationDate(String carRegistrationDate) {
        this.carRegistrationDate = carRegistrationDate;
    }

    public Long getCarKilometers() {
        return carKilometers;
    }

    public void setCarKilometers(Long carKilometers) {
        this.carKilometers = carKilometers;
    }

    public Integer getCarPricePerDay() {
        return carPricePerDay;
    }

    public void setCarPricePerDay(Integer carPricePerDay) {
        this.carPricePerDay = carPricePerDay;
    }

    public String getCarEnergy() {
        return carEnergy;
    }

    public void setCarEnergy(String carEnergy) {
        this.carEnergy = carEnergy;
    }

    public String getCarMotor() {
        return carMotor;
    }

    public void setCarMotor(String carMotor) {
        this.carMotor = carMotor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    public List<CarOption> getCarOptions() {
        return carOptions;
    }

    public void setCarOptions(List<CarOption> carOptions) {
        this.carOptions = carOptions;
    }
}
