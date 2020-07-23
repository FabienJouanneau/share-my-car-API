package com.fabienjouanneau.sharemycar.website.webServices.picture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pictures")
@CrossOrigin
public class PictureController {
    @Autowired
    PictureService pictureService;

    @GetMapping
    public List<Picture> getAllPictures(){
        return pictureService.getAllPictures();
    }
    @GetMapping("{id}")
    public Picture getPictureById(@PathVariable Long id){
        return pictureService.getPictureById(id);
    }
    @PostMapping
    public Picture createPicture(@RequestBody Picture picture){
        return pictureService.postPicture(picture);
    }
    @PutMapping("{id}")
    public Picture updatePicture(@RequestBody Picture picture, @PathVariable Long id){
        if(picture.getPictureId() == id){
            return pictureService.putPicture(picture, id);
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePictureById(@PathVariable Long id){
        pictureService.deletePicture(id);
    }
}
