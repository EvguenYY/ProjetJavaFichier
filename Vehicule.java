package com.iia.shop.entity;

import java.io.Serializable;

public class Vehicule implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4023151205697171176L;
	protected String marque;
	protected int year;
	protected int speed;
	protected String model;
	protected String color;
	protected double price;

	public Vehicule() {
		super();
	}

	public Vehicule(String marque, int year, int speed, String model, String color, double price) {
		super();
		this.marque = marque;
		this.year = year;
		this.speed = speed;
		this.model = model;
		this.color = color;
		this.price = price;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void start() {
	}

	public void stop() {
	}

	public void speedUp(int speed) {
		this.speed = this.speed + speed;
	}

	public void speedDown(int speed) {
		this.speed = this.speed - speed;
	}
}
