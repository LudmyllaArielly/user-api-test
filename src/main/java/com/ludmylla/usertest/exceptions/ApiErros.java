package com.ludmylla.usertest.exceptions;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public class ApiErros {

    List<String> errors;

    public ApiErros(BindingResult bindingResult){
        this.errors = new ArrayList<>();
        bindingResult.getAllErrors().forEach(
                error -> this.errors.add(error.getDefaultMessage()));
    }

    public ApiErros(List<String> errors) {
        this.errors = errors;
    }
}
