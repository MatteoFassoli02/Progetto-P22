package it.unipv.po.splash.model.risikogame.components;

import java.util.Random;

public class Dice {
	private int numFaces;

	public Dice(int numFaces) {
		super();
		this.numFaces = numFaces;
	}

	public int roll() {
		Random random = new Random();
		return random.nextInt(numFaces) + 1;
	}
}
