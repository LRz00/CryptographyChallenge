/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lrz.criptographyChallenge.model;

import jakarta.persistence.*;
import lombok.*;

        
/**
 *
 * @author lara
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_ìnfo")
public class UserInfo {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_document")
    private String userDocument;
    @Column(name ="credit_card_token")
    private String creditCardToken;
    private Long value;
    
    
}
