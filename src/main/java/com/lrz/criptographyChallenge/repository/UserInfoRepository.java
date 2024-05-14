/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.lrz.criptographyChallenge.repository;

import com.lrz.criptographyChallenge.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author lara
 */
@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
    
}
