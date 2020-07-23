package com.fabienjouanneau.sharemycar.website.webServices.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PictureService {
    @Autowired
    PictureRepository pictureRepository;

    // GET ALL PICTURES
    public List<Picture> getAllPictures(){
        return pictureRepository.findAll();
    }
    // GET PICTURE BY ID
    public Picture getPictureById(Long id){
        Optional<Picture> optionalPicture = pictureRepository.findById(id);
        if(optionalPicture.isPresent()){
            return optionalPicture.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    // POST PICTURE
    public Picture postPicture(Picture picture){
        return pictureRepository.save(picture);
    }
    // PUT PICTURE
    public Picture putPicture(Picture picture, Long id){
        Picture pictureUpdated = pictureRepository.findById(id).get();
        pictureUpdated.setUrl(picture.getUrl());
        return pictureRepository.save(pictureUpdated);
    }
    // DELETE PICTURE
    public void deletePicture(Long id){
        pictureRepository.deleteById(id);
    }
}
