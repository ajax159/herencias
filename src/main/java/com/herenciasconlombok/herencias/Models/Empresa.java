package com.herenciasconlombok.herencias.Models;

import lombok.Getter;

@Getter
public class Empresa extends Impuesto {

    private Integer empleados;

    public Empresa(String nombre, Double ingresosAnuales, Integer empleados) {
        super(nombre, ingresosAnuales);
        this.empleados = empleados;
    }

    @Override
    public double calcularImpuestos() {
        double impuestoCalc;

        if (getEmpleados() > 10) {
            impuestoCalc = getIngresosAnuales() * 0.14;
        } else {
            impuestoCalc = getIngresosAnuales() * 0.16;
        }

        return impuestoCalc;
    }
}
