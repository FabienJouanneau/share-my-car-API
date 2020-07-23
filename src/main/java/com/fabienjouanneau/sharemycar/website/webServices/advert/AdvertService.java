package com.fabienjouanneau.sharemycar.website.webServices.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AdvertService {
    @Autowired
    AdvertRepository advertRepository;

    // GET ALL ADVERTS
    public List<Advert> getAllAdverts(){
        return advertRepository.findAll();
    }
    // GET ADVERT BY ID
    public Advert getAdvertById(Long id){
        Optional<Advert> optionalAdvert = advertRepository.findById(id);
        if(optionalAdvert.isPresent()){
            return optionalAdvert.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    // POST ADVERT
    public Advert postAdvert(Advert advert){
        return advertRepository.save(advert);
    }
    // PUT ADVERT
    public Advert putAdvert(Advert advert, Long id){
        Advert advertUpdated = advertRepository.findById(id).get();
        advertUpdated.setName(advert.getName());

        advertUpdated.setCarBrand(advert.getCarBrand());
        advertUpdated.setCarModel(advert.getCarModel());
        advertUpdated.setCarRegistrationDate(advert.getCarRegistrationDate());
        advertUpdated.setCarKilometers(advert.getCarKilometers());
        advertUpdated.setCarPricePerDay(advert.getCarPricePerDay());
        advertUpdated.setCarEnergy(advert.getCarEnergy());
        advertUpdated.setCarMotor(advert.getCarMotor());

        advertUpdated.setCarOptions(advert.getCarOptions());
        advertUpdated.setPictures(advert.getPictures());

        return advertRepository.save(advertUpdated);
    }
    // DELETE ADVERT
    public void deleteAdvert(Long id){
        advertRepository.deleteById(id);
    }
}
