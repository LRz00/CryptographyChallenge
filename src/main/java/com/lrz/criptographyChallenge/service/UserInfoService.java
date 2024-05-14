/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lrz.criptographyChallenge.service;

import com.lrz.criptographyChallenge.model.UserInfo;
import com.lrz.criptographyChallenge.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author lara
 */
@Service
public class UserInfoService {
    @Autowired    
    private UserInfoRepository userInfoRepo;
    
    public UserInfo createUserInfo(UserInfo userInfo){
        return this.userInfoRepo.save(userInfo);
    }

    public UserInfo recoverInformattion(Long id){
        return this.userInfoRepo.findById(id).orElseThrow(()->new RuntimeException("No information found with matching id"));
    }
    
    public void updateInfo(){
        //to-do
    }
    
    public void deleteInfo(Long id){
        this.userInfoRepo.deleteById(id);
    }
}
