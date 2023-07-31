package conversor;

import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.JTextField;

public class Conversores {
	static DecimalFormat df = new DecimalFormat("#.00");
	static double valorFinal=0;
	
	public static void ConvertirMoneda(double proporcion,
			JTextField cantidad,JTextField respuesta) {
		double valor=Double.parseDouble(cantidad.getText());
		valorFinal=valor*proporcion;
		respuesta.setText(df.format(valorFinal)+"");
		System.out.println("la conversion es "+df.format(valorFinal));
		
	}
	
	public static void ConvertirTemperatura(String unidadFinal,
		JTextField cantidad,JTextField respuesta) {
		
		double valor=Double.parseDouble(cantidad.getText());
		if(unidadFinal.equals("C")) {
			valorFinal=(valor-32)*5/9;
			respuesta.setText(df.format(valorFinal)+"");
			System.out.println("la conversion es "+df.format(valorFinal));
		}
		if(unidadFinal.equals("F")) {
			valorFinal=(valor*9/5)+32;
			respuesta.setText(df.format(valorFinal)+"");
			System.out.println("la conversion es "+df.format(valorFinal));
		}
	}
	
	/*
	public static void mostrarSubMenu() {
		System.out.println("1-Convertir de Quetzal a Dólar");
		System.out.println("2-Convertir de Quetzal a Euros");
		System.out.println("3-Convertir de Quetzal a 3");
		System.out.println("4-Convertir de Quetzal a 4");
		System.out.println("5-Convertir de Quetzal a 5");
		System.out.println("6-Salir");
	}

	public static void Convertir(String unidadOrigen,
			String unidadFinal,double proporcion,Scanner lector) {
		System.out.println("Elegiste la opcion "+unidadOrigen+" a "+unidadFinal); 
		System.out.println("Ingrese el valor ");
		double valor =lector.nextDouble();
		double valorFinal=valor*proporcion;
		System.out.println("la conversion es "+valorFinal);
		
	}*/
	
}
