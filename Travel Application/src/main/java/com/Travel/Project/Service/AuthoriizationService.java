package com.Travel.Project.Service;

import com.Travel.Project.Model.UserData;
import com.Travel.Project.Repository.AuthorizationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoriizationService {

    @Autowired
    AuthorizationDao authorizationDao;

    public ResponseEntity<String> registerUser(String username, String password, String email, String number) {
        try{
            List<UserData> curr = authorizationDao.verify(username);
            if (curr.isEmpty()) {
                UserData user = new UserData(username, password, email, number);
                authorizationDao.save(user);
                return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("Username already inuse", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<String> login(String username, String password) {
        try{
            List<UserData> curr = authorizationDao.login(username,password);
            if (!curr.isEmpty()) {
                return new ResponseEntity<>("User is valid", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("User is not valid", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> updatePassword(String username, String password, String newPassword) {
        try{
            List<UserData> curr = authorizationDao.login(username,password);
            if (!curr.isEmpty()) {
                authorizationDao.updatePassword(username,password,newPassword);
                return new ResponseEntity<>("Password updated successfully", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("User is not valid", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> forgotPassword(String username) {
        try {
            List<UserData> curr = authorizationDao.verify(username);
            if (curr.isEmpty()) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }else {
                return new ResponseEntity<>(curr.get(0).getPassword(), HttpStatus.OK);
            }
        }catch (Exception e){
            return new ResponseEntity<>("Try Again", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

