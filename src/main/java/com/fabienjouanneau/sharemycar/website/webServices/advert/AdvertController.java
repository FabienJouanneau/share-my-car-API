package com.fabienjouanneau.sharemycar.website.webServices.advert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/adverts")
@CrossOrigin
public class AdvertController {
    @Autowired
    AdvertService advertService;

    @GetMapping
    public List<Advert> getAllAdverts(){
        return advertService.getAllAdverts();
    }
    @GetMapping("{id}")
    public Advert getAdvertById(@PathVariable Long id){
        return advertService.getAdvertById(id);
    }
    @PostMapping
    public Advert createAdvert(@RequestBody Advert advert){
        return advertService.postAdvert(advert);
    }
    @PutMapping("{id}")
    public Advert updateAdvert(@RequestBody Advert advert, @PathVariable Long id){
        if(advert.getAdvertId() == id){
            return advertService.putAdvert(advert, id);
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAdvertById(@PathVariable Long id){
        advertService.deleteAdvert(id);
    }
}
