/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lrz.criptographyChallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author lara
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoMatchingIdException extends RuntimeException{

    public NoMatchingIdException(String message) {
        super(message);
    }
    
}
