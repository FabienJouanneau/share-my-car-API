package com.fabienjouanneau.sharemycar.website.webServices.carOption;

import com.fabienjouanneau.sharemycar.website.webServices.advert.Advert;
import com.fabienjouanneau.sharemycar.website.webServices.picture.Picture;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CarOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long carOptionId;

    private String name;

    @ManyToMany()
    @JsonIdentityInfo(
            scope = Advert.class,
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "advertId")
    @JsonIdentityReference(alwaysAsId = true)
    @JoinTable(
            name="advert_car_option",
            joinColumns = @JoinColumn(name = "carOption_id"),
            inverseJoinColumns = @JoinColumn(name = "advert_id"))
    private List<Advert> adverts  = new ArrayList<>();


    public CarOption() {
    }

    public Long getCarOptionId() {
        return carOptionId;
    }

    public void setCarOptionId(Long carOptionId) {
        this.carOptionId = carOptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Advert> getAdverts() {
        return adverts;
    }

    public void setAdverts(List<Advert> adverts) {
        this.adverts = adverts;
    }
}
