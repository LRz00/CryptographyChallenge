/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lrz.criptographyChallenge.service;

import com.lrz.criptographyChallenge.model.UserInfo;
import com.lrz.criptographyChallenge.model.dto.SensitiveDataDTO;
import com.lrz.criptographyChallenge.model.dto.UserInfoDTO;
import com.lrz.criptographyChallenge.repository.UserInfoRepository;
import com.lrz.criptographyChallenge.exceptions.NoMatchingIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Service;

/**
 *
 * @author lara
 */
@Service
public class UserInfoService {
    @Autowired    
    private UserInfoRepository userInfoRepo;
    
    public UserInfo createUserInfo(UserInfoDTO userInfo){
        
        UserInfo newUser = new UserInfo();
        
        SensitiveDataDTO sensitiveData = this.protectData(userInfo.userDocument(), userInfo.creditCardToken());
        
        newUser.setCreditCardToken(sensitiveData.creditCardToken());
        
        newUser.setUserDocument(sensitiveData.userDocument());
        
        newUser.setValue(userInfo.value());
        
        return this.userInfoRepo.save(newUser);
    }

    public UserInfo recoverInformattion(Long id){
        return this.userInfoRepo.findById(id).orElseThrow(()->new NoMatchingIdException("No information found with matching id"));
    }
    
    public UserInfo updateInfo(Long id, UserInfoDTO newInfo){
        UserInfo updatedUser = this.recoverInformattion(id);
        
        updatedUser.setValue(newInfo.value());
        
        SensitiveDataDTO newSafeData = this.protectData(newInfo.userDocument(), newInfo.creditCardToken());
        
        updatedUser.setCreditCardToken(newSafeData.creditCardToken());
        updatedUser.setUserDocument(newSafeData.userDocument());
        
       return this.userInfoRepo.save(updatedUser);
        
    }
    
    public void deleteInfo(Long id){
        this.userInfoRepo.deleteById(id);
    }
    
    private SensitiveDataDTO protectData(String userDocument, String creditCardToken){
        
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String safeDocument = encoder.encode(userDocument);
        String safeCreditCard = encoder.encode(creditCardToken);
                
        
        SensitiveDataDTO safeData = new SensitiveDataDTO(safeCreditCard, safeDocument);
        
        return safeData;
    }
}
