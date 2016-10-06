package com.iia.shop;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


import com.iia.shop.entity.Vehicule;

public class Store {

	private static ArrayList<Vehicule> vehicules;
	private static Scanner sc;

	public static void main(String[] args) {
		Store.vehicules = new ArrayList<Vehicule>();
		
		assets();
		
		File newFile = new File("C:\\Users\\EBOUDI\\test.txt");
		createFile(newFile, "");
		
		
		System.out.println("Gestion des v�hicules");
		System.out.println("1 - cr�er un v�hicule");
		System.out.println("2 - mettre � jour un v�hicule");
		System.out.println("3 - voir tous les v�hicules");
		System.out.println("4 - s�lectionner un v�hicule");
		System.out.println("5 - supprimer un v�hicule");
		
		sc = new Scanner(System.in);
		
		System.out.println("Votre choix");
		int choice = sc.nextInt();
		
		Vehicule vehicule;
		
		switch (choice) {
		case 1:
			vehicule = new Vehicule();
			
			setVehicule(vehicule);
			create(vehicule);
			
			saveObject(newFile, vehicule);
			break;
		case 2:
			System.out.println("Veuillez saisir l'id du v�hicule");
			vehicule = read(sc.nextInt());
			
			displayVehicule(vehicule);
			setVehicule(vehicule);
			break;
		case 3:
			ArrayList<Vehicule> vehicules = readAll();
			
			for (Vehicule vehicule2 : vehicules) {
				displayVehicule(vehicule2);
			}
			break;
			
		case 4:
			System.out.println("Veuillez saisir l'id du v�hicule");
			vehicule = read(sc.nextInt());
			
			displayVehicule(vehicule);
			
			break;
			
		case 5:
			System.out.println("Veuillez saisir l'id du v�hicule");
			delete(sc.nextInt());
			break;
		default:
			break;
		}

	}

	private static void create(Vehicule vehicule) {
		Store.vehicules.add(vehicule);
	}

	private static void delete(int index) {
		Store.vehicules.remove(index);
	}

	private static ArrayList<Vehicule> readAll() {
		return Store.vehicules;
	}

	private static Vehicule read(int index) {
		return Store.vehicules.get(index);
	}

	private static void displayVehicule(Vehicule vehicule) {
		System.out.println("Marque : " + vehicule.getMarque());
		System.out.println("Mod�le : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Ann�e : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
	}
	
	private static void setVehicule(Vehicule vehicule) {
		System.out.println("Veuillez saisir la marque du v�hicule");
		vehicule.setMarque(sc.next());
		
		System.out.println("Veuillez saisir l'ann�e du v�hicule");
		vehicule.setYear(sc.nextInt());
		
		System.out.println("Veuillez saisir le mod�le du v�hicule");
		vehicule.setModel(sc.next());
		
		System.out.println("Veuillez saisir la couleur du v�hicule");
		vehicule.setColor(sc.next());

		System.out.println("Veuillez saisir le prix du v�hicule");
		vehicule.setPrice(sc.nextDouble());
	}
	
	private static void assets() {
		Vehicule v1 = new Vehicule("peugeot", 2016, 50, "3008", "blanc", 20000);
		Vehicule v2 = new Vehicule("audi", 2016, 90, "A5", "noire", 47000);
		
		Store.vehicules.add(v1);
		Store.vehicules.add(v2);
	}
	
	
	
	
	public static void readFile(File file) {
		try {
			FileReader reader = new FileReader(file);

			BufferedReader buffer = new BufferedReader(reader);

			while (buffer.ready()) {
				System.out.println(buffer.readLine());
			}
			buffer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void createFile(File file, String value) {
		try {
			FileWriter writer = new FileWriter(file, true);
			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write(value);
			buffer.newLine();
			buffer.write(value);

			buffer.close();

			// Files.write(path, bytes, options);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void saveObject(File file, Vehicule vehicule){
		try {
			FileOutputStream out = new FileOutputStream(file, true);
			ObjectOutputStream objectOutput = new ObjectOutputStream(out);
		
			objectOutput.writeObject(vehicule);
			
			objectOutput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void readObject(File file){
		
		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(in);
			
			Vehicule vehicule = (Vehicule) objectIn.readObject();
			
			objectIn.close();
			
			System.out.println("Nom du v�hicule :" + vehicule.getMarque());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
}
