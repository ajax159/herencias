package com.herenciasconlombok.herencias.Models;

import lombok.Getter;

@Getter
public class Persona extends Impuesto {

    private Double gastosSalud;

    public Persona(String nombre, Double ingresosAnuales, Double gastosSalud) {
        super(nombre, ingresosAnuales);
        this.gastosSalud = gastosSalud;
    }

    @Override
    public double calcularImpuestos() {
        double impuestoCalc;

        if (getIngresosAnuales() < 20000) {
            impuestoCalc = getIngresosAnuales() * 0.15;
        } else {
            impuestoCalc = getIngresosAnuales() * 0.25;
        }

        if (getGastosSalud() > 0)
            impuestoCalc -= getGastosSalud() * 0.5;

        return impuestoCalc;
    }
}
