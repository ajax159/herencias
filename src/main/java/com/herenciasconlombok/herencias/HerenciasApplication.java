package com.herenciasconlombok.herencias;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.herenciasconlombok.herencias.Models.Empresa;
import com.herenciasconlombok.herencias.Models.Impuesto;
import com.herenciasconlombok.herencias.Models.Persona;

import lombok.Cleanup;

@SpringBootApplication
public class HerenciasApplication {

	public static void main(String[] args) {
		List<Impuesto> imp = new ArrayList<>();
		@Cleanup
		Scanner sc = new Scanner(System.in);
		System.out.println("Numero de contribuyentes: ");
		int ncontribuyentes = sc.nextInt();

		for (int i = 1; i <= ncontribuyentes; i++) {
			System.out.println("Contribuyente #" + i);
			System.out.println("Tipo de contribuyente (Persona, Empresa) p o e?: ");
			char tipo = sc.next().charAt(0);
			System.out.println("Nombre: ");
			String nombre = sc.next();
			System.out.println("Ingresos anuales: ");
			Double ingresosAnuales = sc.nextDouble();

			if (tipo == 'p') {
				System.out.println("Gastos de salud: ");
				Double gastosSalud = sc.nextDouble();
				Persona per = new Persona(nombre, ingresosAnuales, gastosSalud);
				imp.add(per);
			} else {
				System.out.println("Numero de empleados: ");
				Integer empleados = sc.nextInt();
				Empresa emp = new Empresa(nombre, ingresosAnuales, empleados);
				imp.add(emp);
			}

			System.out.println("Impuestos calculados: ");
			double sum = 0;
			for (Impuesto it : imp) {
				System.out.println(it.getNombre() + ": $" + it.calcularImpuestos());
				sum += it.calcularImpuestos();
			}

			System.out.println("Total de impuestos: $" + sum);
		}

	}

}
