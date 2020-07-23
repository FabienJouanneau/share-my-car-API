package com.fabienjouanneau.sharemycar.website.webServices.carOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CarOptionService {
    @Autowired
    CarOptionRepository carOptionRepository;

    // GET ALL CAROPTIONS
    public List<CarOption> getAllCarOptions(){
        return carOptionRepository.findAll();
    }
    // GET CAROPTION BY ID
    public CarOption getCarOptionById(Long id){
        Optional<CarOption> optionalCarOption = carOptionRepository.findById(id);
        if(optionalCarOption.isPresent()){
            return optionalCarOption.get();
        }
        throw  new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    // POST CAROPTION
    public CarOption postCarOption(CarOption carOption){
        return carOptionRepository.save(carOption);
    }
    // PUT CAROPTION
    public CarOption putCarOption(CarOption carOption, Long id){
        CarOption carOptionUpdated = carOptionRepository.findById(id).get();
        carOptionUpdated.setName(carOption.getName());
        return carOptionRepository.save(carOptionUpdated);
    }
    // DELETE CAROPTION
    public void deleteCarOption(Long id){
        carOptionRepository.deleteById(id);
    }
}
