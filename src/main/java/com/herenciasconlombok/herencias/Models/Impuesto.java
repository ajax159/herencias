package com.herenciasconlombok.herencias.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Impuesto {
    private String nombre;
    private Double ingresosAnuales;

    public abstract double calcularImpuestos();
}
