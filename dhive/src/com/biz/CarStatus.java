package com.biz;

public class CarStatus {
	String id;
	double speed;
	double temp;
	double oiltemp;
	double rpm;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getSpeed() {
		return speed;
	}
	@Override
	public String toString() {
		return "CarStatus [id=" + id + ", speed=" + speed + ", temp=" + temp + ", oiltemp=" + oiltemp + ", rpm=" + rpm
				+ "]";
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public double getTemp() {
		return temp;
	}
	public void setTemp(double temp) {
		this.temp = temp;
	}
	public double getOiltemp() {
		return oiltemp;
	}
	public void setOiltemp(double oiltemp) {
		this.oiltemp = oiltemp;
	}
	public double getRpm() {
		return rpm;
	}
	public void setRpm(double rpm) {
		this.rpm = rpm;
	}
	public CarStatus() {
		super();
	}
	public CarStatus(String id, double speed, double temp, double oiltemp, double rpm) {
		super();
		this.id = id;
		this.speed = speed;
		this.temp = temp;
		this.oiltemp = oiltemp;
		this.rpm = rpm;
	}
}
