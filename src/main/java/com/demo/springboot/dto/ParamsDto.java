package com.demo.springboot.dto;

public class ParamsDto {

    Double x1;
    Double x2;
    Vertex W;

    public ParamsDto(Double x1, Double x2, Vertex W) {
        this.x1 = x1;
        this.x2 = x2;
        this.W = W;
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    public Vertex getW() {
        return W;
    }
}
