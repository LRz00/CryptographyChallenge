/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lrz.criptographyChallenge.controller;
import com.lrz.criptographyChallenge.model.UserInfo;
import com.lrz.criptographyChallenge.service.UserInfoService;
import com.lrz.criptographyChallenge.model.dto.UserInfoDTO;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
/**
 *
 * @author lara
 */
@RestController
@RequestMapping("/userInfo")
public class UserInfoController {
    @Autowired
    UserInfoService userService;
    
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserInfoDTO userInfo){        
        UserInfo newInfo = this.userService.createUserInfo(userInfo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newInfo.getId()).toUri();
        return ResponseEntity.created(uri).build();        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<UserInfo> getUserInfo(@PathVariable Long id){
        UserInfo user = this.userService.recoverInformattion(id);
        
        return ResponseEntity.ok(user);
    }
    
   
    @PutMapping("/{id}")
    public ResponseEntity<UserInfo> updateInfo(@PathVariable Long id, @RequestBody UserInfoDTO userInfo){
        UserInfo user = this.userService.updateInfo(id, userInfo);
        
        return ResponseEntity.ok(user);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInfo(@PathVariable Long id){
        this.userService.deleteInfo(id);
        return ResponseEntity.noContent().build();
    }
}
