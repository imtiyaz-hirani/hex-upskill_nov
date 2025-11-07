package com.hex.trs.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UsernameAlreadyExist extends  RuntimeException{
    private String message;
}
