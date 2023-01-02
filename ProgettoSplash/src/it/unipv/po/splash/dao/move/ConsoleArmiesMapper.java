package it.unipv.po.splash.dao.move;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleArmiesMapper implements IArmiesMapper {

	public ConsoleArmiesMapper() {
		super();
	}

	@Override
	public int getArmies() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(br.readLine());
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}