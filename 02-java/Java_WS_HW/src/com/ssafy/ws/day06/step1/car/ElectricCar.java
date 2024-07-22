package com.ssafy.ws.day06.step1.car;

public class ElectricCar extends Car {
	private int battery;

	public ElectricCar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ElectricCar(int battery) {
		this.battery = battery;
	}

	public ElectricCar(String VIN, String modelName, String color, int mileage, int battery) {
		super(VIN, modelName, color, mileage);
		this.battery = battery;
		// TODO Auto-generated constructor stub
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	@Override
	public String toString() {
		String result = super.toString();
		result = result.substring(0, result.length() - 1) +  ", battery=" + battery + "]";
		
		return result;
	}
}
