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
		
		vehicules = new ArrayList<Vehicule>();
		
		assets();
		
		File dir = new File("C:\\windows");
		
		File file = new File(dir, "system.ini");
		
		readFile(file);
		
		
		File newFile = new File("test.txt");
		
		
		System.out.println("Gestion des véhicules");
		System.out.println("1 - créer un véhicule");
		System.out.println("2 - mettre à jour un véhicule");
		System.out.println("3 - voir tous les véhicules");
		System.out.println("4 - sélectionner un véhicule");
		System.out.println("5 - supprimer un véhicule");
		
		sc = new Scanner(System.in);
		
		System.out.println("Votre choix");
		int choice = sc.nextInt();
		
		
		Vehicule vehicule ;
		
		File serialFile = new File("vehicule.txt");

		switch (choice) {
		case 1:
			vehicule = new Vehicule();
			setVehicule(vehicule);
			create(vehicule);
			writeFile(newFile, vehicule.getMarque(), vehicule.getModel(), vehicule.getColor(), vehicule.getYear(),
					vehicule.getSpeed(), vehicule.getPrice());
			Store.saveObject(serialFile, vehicule);
			break;
		case 2:
			System.out.println("Veuillez saisir l'id du véhicule");
			vehicule = read(sc.nextInt());

			displayVehicule(vehicule);
			setVehicule(vehicule);
			break;
		case 3:
			readFile(newFile);
			Store.readObject(serialFile);
			break;

		case 4:
			System.out.println("Veuillez saisir l'id du véhicule");
			vehicule = read(sc.nextInt());

			displayVehicule(vehicule);

			break;

		case 5:
			System.out.println("Veuillez saisir l'id du véhicule");
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
		System.out.println("Modèle : " + vehicule.getModel());
		System.out.println("Couleur : " + vehicule.getColor());
		System.out.println("Année : " + vehicule.getYear());
		System.out.println("Vitesse : " + vehicule.getSpeed());
		System.out.println("Prix : " + vehicule.getPrice());
	}

	private static void setVehicule(Vehicule vehicule) {
		System.out.println("Veuillez saisir la marque du véhicule");
		vehicule.setMarque(sc.next());

		System.out.println("Veuillez saisir l'année du véhicule");
		vehicule.setYear(sc.nextInt());

		System.out.println("Veuillez saisir le modèle du véhicule");
		vehicule.setModel(sc.next());

		System.out.println("Veuillez saisir la couleur du véhicule");
		vehicule.setColor(sc.next());

		System.out.println("Veuillez saisir le prix du véhicule");
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

	public static void saveObject(File file, Vehicule vehicule) {
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

	public static void readObject(File file) {

		try {
			FileInputStream in = new FileInputStream(file);
			ObjectInputStream objectIn = new ObjectInputStream(in);

			Vehicule vehicule = (Vehicule) objectIn.readObject();

			objectIn.close();
			System.out.println("Marque de la voiture : " + vehicule.getMarque() + "\n" + "Modele de la voiture : "
					+ vehicule.getModel());
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

	public static void writeFile(File file, String value, String string, String string2, int i, int j, double d) {
		try {

			String total = String.valueOf(d);
			String integ = String.valueOf(i);
			String integ2 = String.valueOf(j);
			FileWriter writer = new FileWriter(file, true);

			BufferedWriter buffer = new BufferedWriter(writer);
			buffer.write("--------------------------");
			buffer.newLine();
			buffer.write("Marque : " + value);
			buffer.newLine();
			buffer.write("Modèle : " + string);
			buffer.newLine();
			buffer.write("Couleur : " + string2);
			buffer.newLine();
			buffer.write("Année : " + integ);
			buffer.newLine();
			buffer.write("Vitesse : " + integ2);
			buffer.newLine();
			buffer.write("Prix : " + total);
			buffer.newLine();

			buffer.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
