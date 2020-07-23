package com.fabienjouanneau.sharemycar.website.webServices.booking;

import com.fabienjouanneau.sharemycar.website.webServices.advert.Advert;
import com.fabienjouanneau.sharemycar.website.webServices.user.User;
import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @ManyToOne()
    @JsonBackReference(value = "user-booking")
    @JoinColumn(name = "user_id")
    @JsonIdentityReference(alwaysAsId = true)
    private User user;

    @ManyToOne()
    @JsonBackReference(value = "advert-booking")
    @JoinColumn(name = "advert_id")
    private Advert advert;

    private Date startingDate;
    private Date endingDate;
    private Long amount;

    public Booking(){}

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }

    public Date getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
