package com.fabienjouanneau.sharemycar.website.webServices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    // GET ALL USERS
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    // GET USER BY ID
    public User getUserById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
    }
    // POST USER
    public User postUser(User user){
        return userRepository.save(user);
    }
    // PUT USER
    public User putUser(User user, Long id){
        User userUpdated = userRepository.findById(id).get();
        userUpdated.setLastName(user.getLastName());
        userUpdated.setFirstName(user.getFirstName());
        userUpdated.setEmail(user.getEmail());
        userUpdated.setBirthdate(user.getBirthdate());
        userUpdated.setPhoneNumber(user.getPhoneNumber());

        userUpdated.setAddressStreet(user.getAddressStreet());
        userUpdated.setAddressZipCode(user.getAddressZipCode());
        userUpdated.setAddressCityName(user.getAddressCityName());
        userUpdated.setAddressCountryName(user.getAddressCountryName());

        userUpdated.setRibOwnerFullName(user.getRibOwnerFullName());
        userUpdated.setRibBankName(user.getRibBankName());
        userUpdated.setRibIbanNumber(user.getRibIbanNumber());
        userUpdated.setRibBicCode(user.getRibBicCode());

        userUpdated.setDrivingLicenceOwner(user.getDrivingLicenceOwner());
        userUpdated.setDrivingLicenceNumber(user.getDrivingLicenceNumber());
        userUpdated.setDrivingLicenceDate(user.getDrivingLicenceDate());

        return userRepository.save(userUpdated);
    }
    // DELETE USER
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
