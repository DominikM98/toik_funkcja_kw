package com.demo.springboot.rest;

import com.demo.springboot.dto.AlertDto;
import com.demo.springboot.dto.ParamsDto;
import com.demo.springboot.service.QuadraticFunction;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/math/")
public class DocumentApiController {

    private final QuadraticFunction quadraticFunction;

    @Autowired
    public DocumentApiController(QuadraticFunction quadraticFunction) {
        this.quadraticFunction = quadraticFunction;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<AlertDto> handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        System.out.println(name + " parameter is missing");
        return new ResponseEntity<>(new AlertDto("Podaj wszystkie parametry"), HttpStatus.BAD_REQUEST);
    }

    @PostMapping("quadratic-function")
    public ResponseEntity<Object> params(@RequestParam() double a, @RequestParam() double b, @RequestParam double c){
        return new ResponseEntity<>(quadraticFunction.Calculate(a,b,c), HttpStatus.OK);
    }
}
