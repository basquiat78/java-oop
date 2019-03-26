package io.basquiat.solid.b.ocp;

import io.basquiat.solid.b.ocp.model.BigBird;
import io.basquiat.solid.b.ocp.model.GameCharacter;
import io.basquiat.solid.b.ocp.model.Horse;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GameCharacter gameCharacter = new GameCharacter();
		gameCharacter.setVehicle(new Horse());
		gameCharacter.ride();
		gameCharacter.move();
		
		gameCharacter.setVehicle(new BigBird());
		gameCharacter.ride();
		gameCharacter.move();
	}

}
