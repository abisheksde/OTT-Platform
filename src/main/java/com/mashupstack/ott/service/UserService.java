package com.mashupstack.ott.service;

import com.mashupstack.ott.dto.UserDto;
import com.mashupstack.ott.models.User;
import com.mashupstack.ott.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

/*    @Autowired
    PasswordEncoder passwordEncoder;*/

    @Autowired

    public void blockUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();

        if(!user.getIsblocked()){
            user.setIsblocked(true);
            userRepository.save(user);
        }
    }

    public  void unblockUser(Long userId){
        Optional<User> optionalUser = userRepository.findById(userId);

        User user = optionalUser.get();

        if(user.getIsblocked()){
            user.setIsblocked(false);
            userRepository.save(user);
        }
    }

    public void userRegistration(UserDto userDto){
        User user = new User(userDto.getName(), userDto.getAge(), userDto.getEmail(),userDto.getPassword() /*passwordEncoder.encode(userDto.getPassword())*/);

        user.setIsblocked(false);
        user.setRole("USER");
        //TODO: Encode the Password & Save
        userRepository.save(user);
    }

    public void userUpdation(UserDto userDto){
        //TODO: Get Current logged in User (Using Authentication)
        //TODO: Set the Updated Value to Current User Repository
        User user = userRepository.findByEmail("abishekthankaswamy@iconicdigital.in");

        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        userRepository.save(user);

    }

    public User getUser(){

        ///TODO: Get Current logged in User

        return userRepository.findByEmail("abishekthankaswamy@iconicdigital.in");
    }

    public void deleteUser() {
        ///TODO: Get Current logged in User

        User user = userRepository.findByEmail("biju@iconicdigital.in");

        userRepository.delete(user);
    }
}
