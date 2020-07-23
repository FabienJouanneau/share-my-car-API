package com.fabienjouanneau.sharemycar.website.webServices.picture;

import com.fabienjouanneau.sharemycar.website.webServices.advert.Advert;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;

@Entity
public class Picture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pictureId;
    private String url;

    @ManyToOne
    @JsonBackReference(value = "advert-picture")
    @JoinColumn(name = "advert_id")
    @JsonIdentityReference(alwaysAsId = true)
    private Advert advert;

    public Picture(){}

    public Long getPictureId() {
        return pictureId;
    }

    public void setPictureId(Long pictureId) {
        this.pictureId = pictureId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Advert getAdvert() {
        return advert;
    }

    public void setAdvert(Advert advert) {
        this.advert = advert;
    }
}
