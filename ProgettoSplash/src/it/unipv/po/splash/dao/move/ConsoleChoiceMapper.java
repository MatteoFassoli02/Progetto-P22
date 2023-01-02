package it.unipv.po.splash.dao.move;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleChoiceMapper implements IChoiceMapper {

	public ConsoleChoiceMapper() {
		super();
	}

	@Override
	public boolean getChoice() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String response;
		System.out.println("y or yes = true");
		try {
			response = br.readLine();
			if (response.equalsIgnoreCase("y"))
				return true;
			if (response.equalsIgnoreCase("yes"))
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
