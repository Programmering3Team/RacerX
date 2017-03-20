package com.prog3team.racerx.cars;


public enum CarType {
	STANDARD (100, 10, 10, 10, "xxx", 0);
	
	private float maxSpeed;
	private float acceleration;
	private float turnSpeed;
	private int health;
	private String path;
	private int id;
	
	private CarType(float maxSpeed, float acceleration, float turnSpeed, int health, String path, int id) {
		this.maxSpeed = maxSpeed;
		this.acceleration = acceleration;
		this.turnSpeed = turnSpeed;
		this.health = health;
		this.path = path;
		this.id = id;
	}

	public float getMaxSpeed() {
		return maxSpeed;
	}

	public float getAcceleration() {
		return acceleration;
	}

	public float getTurnSpeed() {
		return turnSpeed;
	}

	public int getHealth() {
		return health;
	}

	public String getPath() {
		return path;
	}

	public int getId() {
		return id;
	}
}
