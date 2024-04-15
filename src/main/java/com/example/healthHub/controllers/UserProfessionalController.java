package com.example.healthHub.controllers;

import com.example.healthHub.dtos.UserProfessionalDto;
import com.example.healthHub.models.UserProfessionalModel;
import com.example.healthHub.repositories.AddressRepository;
import com.example.healthHub.repositories.UserProfessionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserProfessionalController {
    @Autowired
    UserProfessionalRepository userProfessionalRepository;
    @Autowired
    AddressRepository addressRepository;

    @PostMapping("/userProfessional")
    public ResponseEntity<Object> saveUserProfessional(@RequestBody UserProfessionalDto userProfessionalDto){
        UserProfessionalModel newUserProfessional = new UserProfessionalModel();

        if(userProfessionalDto.name() != null){
            newUserProfessional.setName(userProfessionalDto.name());
        }
        if(userProfessionalDto.gender() != null){
            newUserProfessional.setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.job() != null){
            newUserProfessional.setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.crn_cref() != null){
            newUserProfessional.setCrn_cref(userProfessionalDto.crn_cref());
        }
        if(userProfessionalDto.rating() != null){
            newUserProfessional.setRating(userProfessionalDto.rating());
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(userProfessionalRepository.save(newUserProfessional));
    }

    @GetMapping("/userProfessional")
    public ResponseEntity<Object> getAllUserProfessional(){
        List<UserProfessionalModel> listUserProfessionals = userProfessionalRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(listUserProfessionals);
    }

    @GetMapping("/userProfessional/{id}")
    public ResponseEntity<Object> getOneUserProfessional(@RequestParam("id") int id){
        Optional<UserProfessionalModel> userProfessionalReturn = userProfessionalRepository.findById(id);

        if(userProfessionalReturn.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(userProfessionalReturn.get());
    }
    @PutMapping("/userProfessional")
    public ResponseEntity<Object> updateUserProfessional(@RequestParam("id") int id,
                                              @RequestBody UserProfessionalDto userProfessionalDto)
    {
        Optional<UserProfessionalModel> updatedUserProfessional = userProfessionalRepository.findById(id);


        if(updatedUserProfessional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        if(userProfessionalDto.name() != null){
            updatedUserProfessional.get().setName(userProfessionalDto.name());
        }
        if(userProfessionalDto.gender() != null){
            updatedUserProfessional.get().setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.job() != null){
            updatedUserProfessional.get().setGender(userProfessionalDto.gender());
        }
        if(userProfessionalDto.crn_cref() != null){
            updatedUserProfessional.get().setCrn_cref(userProfessionalDto.crn_cref());
        }
        if(userProfessionalDto.rating() != null){
            updatedUserProfessional.get().setRating(userProfessionalDto.rating());
        }

        return ResponseEntity.status(HttpStatus.OK).body(updatedUserProfessional);
    }

    @DeleteMapping("/userProfessional")
    public ResponseEntity<Object> deleteUserProfessional(@RequestParam("id") int id){
        Optional<UserProfessionalModel> deleteUserProfessional = userProfessionalRepository.findById(id);

        if(deleteUserProfessional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Register not found");
        }

        userProfessionalRepository.delete(deleteUserProfessional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Register deleted successfully");
    }
}
