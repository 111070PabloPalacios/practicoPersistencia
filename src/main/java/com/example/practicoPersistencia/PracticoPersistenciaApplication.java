package com.example.practicoPersistencia;

import insertardatos.DatosAuto;
import insertardatos.DatosMoto;
import insertardatos.DatosVehiculo;
import leerdatos.LeerDatosAutos;
import leerdatos.LeerDatosMotos;
import leerdatos.LeerDatosVehiculo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PracticoPersistenciaApplication {

	static DatosVehiculo datosVehiculo = new DatosVehiculo();
	static DatosMoto datosMoto = new DatosMoto();
	static DatosAuto datosAuto = new DatosAuto();
	static LeerDatosVehiculo leerDatosVehiculo = new LeerDatosVehiculo();
	static LeerDatosMotos leerDatosMotos = new LeerDatosMotos();
	static LeerDatosAutos leerDatosAutos = new LeerDatosAutos();

	public static void main(String[] args)
	{
		//SpringApplication.run(PracticoPersistenciaApplication.class, args);

		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		String patente;
		//String vehiculo;
		//Auto auto = new Auto();
		//Moto moto = new Moto();

		System.out.println("¿Cuantos vehiculos desea ingresar?: ");
		int cantidadVehiculos = sc.nextInt();

		System.out.println();

		for(int i = 0; i < cantidadVehiculos; i++)
		{
			System.out.println("Ingrese el tipo de Vehiculo (Auto - Moto):");
			String vehiculo = sc.next();

			if(vehiculo.equalsIgnoreCase("Auto"))
			{
				System.out.println("Ingrese el modelo: ");
				String modelo = sc.next();
				System.out.println("Ingrese el kilometraje: ");
				int kilometraje = sc.nextInt();
				System.out.println("Ingrese el tipo de vehiculo (Deportivo o Familiar):");
				String tipo = sc.next();
				System.out.println("Ingrese la patente:");
				patente = sc.next();
				System.out.println("¿El auto es usado? (SI - NO): ");
				String usado = sc.next();

				System.out.println("Ingrese el color: ");
				String color = sc.next();
				System.out.println("Ingrese la marca: ");
				String marca = sc.next();
				System.out.println("¿El auto tiene estereo (SI - NO): ?");
				String estereo = sc.next();

				System.out.println("Ingrese la cantidad de puertas: ");
				int cantidadDePuertas = sc.nextInt();
				System.out.println("Ingrese la traccion EJ (2000): ");
				int traccion = sc.nextInt();
				//System.out.println(auto.toString());
				datosVehiculo.insertarDatosVehiculo(patente, modelo, tipo, usado, color, marca);
				datosAuto.insertarDatosAuto(patente, estereo, cantidadDePuertas, traccion);

				leerDatosVehiculo.leerDatosVehiculo();
				leerDatosAutos.leerDatosAutos();
			}
			else
			{
				System.out.println("Ingrese el modelo: ");
				String modelo = sc.next();
				System.out.println("Ingrese el kilometraje: ");
				int kilometraje = sc.nextInt();
				System.out.println("Ingrese el tipo de moto (Deportivo o Familiar):");
				String tipo = sc.next();
				System.out.println("Ingrese la patente:");
				patente = sc.next();
				System.out.println("¿La moto es usada? (SI - NO): ");
				String usado = sc.next();

				System.out.println("Ingrese el color: ");
				String color = sc.next();
				System.out.println("Ingrese la marca: ");
				String marca = sc.next();
				System.out.println("¿Es cilindrada? (SI-NO):");
				String cilindrada = sc.next();

				System.out.println("¿Tiene asiento acompañanante? (SI-NO): ");
				String asientoAcompanante = sc.next();

				datosVehiculo.insertarDatosVehiculo(patente, modelo, tipo, usado, color, marca);
				datosMoto.insertarDatosMoto(patente, cilindrada, asientoAcompanante);

				leerDatosVehiculo.leerDatosVehiculo();
				leerDatosMotos.leerDatosMotos();
				//System.out.println(moto.toString());
			}

			if(i + 1 != cantidadVehiculos)
			{
				System.out.println("¿Desea seguir ingresando vehiculos?");
				String opcion = sc.next();

				if(opcion.equalsIgnoreCase("No"))
				{
					System.out.println("Se han ingresado " + (i + 1) + " vehiculos");
					break;
				}
			}
			else
			{
				System.out.println("Se han ingresado " + cantidadVehiculos + " vehiculos");
				break;
			}
		}
	}

}
