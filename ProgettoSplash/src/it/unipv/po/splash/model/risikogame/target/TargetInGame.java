package it.unipv.po.splash.model.risikogame.target;

import java.util.ArrayList;

public class TargetInGame {
	private ArrayList<String> target;

	public TargetInGame() {
		super();
		target = new ArrayList<String>();
	}
	
	public void addTargetInGame(String gt) {
		target.add(gt);
	}
	
	public String getTargetInGame(int index) {
		return target.get(index);
	}
	
	public int getNumberOfTargets() {
		return target.size();
	} 
}
