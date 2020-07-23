package com.fabienjouanneau.sharemycar.website.webServices.carOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/options")
@CrossOrigin
public class CarOptionController {
    @Autowired
    CarOptionService carOptionService;

    @GetMapping
    public List<CarOption> getAllCarOptions(){
        return carOptionService.getAllCarOptions();
    }
    @GetMapping("{id}")
    public CarOption getCarOptionById(@PathVariable Long id){
        return carOptionService.getCarOptionById(id);
    }
    @PostMapping
    public CarOption createCarOption(@RequestBody CarOption carOption){
        return carOptionService.postCarOption(carOption);
    }
    @PutMapping("{id}")
    public CarOption updateCarOption(@RequestBody CarOption carOption, @PathVariable Long id){
        if (carOption.getCarOptionId() == id){
            return carOptionService.putCarOption(carOption, id);
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOptionById(@PathVariable Long id){
        carOptionService.deleteCarOption(id);
    }
}
