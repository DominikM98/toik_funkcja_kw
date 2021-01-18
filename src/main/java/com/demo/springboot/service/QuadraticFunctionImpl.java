package com.demo.springboot.service;

import com.demo.springboot.dto.ParamsDto;
import com.demo.springboot.dto.Vertex;
import org.springframework.stereotype.Service;

@Service
public class QuadraticFunctionImpl implements QuadraticFunction {

    public QuadraticFunctionImpl() {
    }

    @Override
    public ParamsDto Calculate(double a, double b, double c) {
        Double x1;
        Double x2;
        Double p;
        Double q;
        double delta = Math.pow(b,2) - (4*a*c);
        if (delta>0){
            x1 = (-b - Math.sqrt(delta))/(2*a);
            x2 = (-b + Math.sqrt(delta))/(2*a);
        }
        else if(delta == 0){
            x1 = -b/(2*a);
            x2 = null;
        }
        else{
            x1=null;
            x2=null;
        }

        p = -b/(2*a);
        q = -delta/(4*a);
        return new ParamsDto(x1,x2, new Vertex(p,q));
    }
}
