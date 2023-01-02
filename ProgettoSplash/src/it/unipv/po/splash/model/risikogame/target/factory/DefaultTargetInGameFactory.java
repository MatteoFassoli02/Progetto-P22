package it.unipv.po.splash.model.risikogame.target.factory;

import it.unipv.po.splash.model.risikogame.target.TargetInGame;

public class DefaultTargetInGameFactory implements ITargetInGameFactory {
	private final static String CONQUEST_TERRITORY = "it.unipv.po.splash.model.risikogame.target.ConquestTerritory";
	private final static String KILL_PLAYER = "it.unipv.po.splash.model.risikogame.target.KillPlayer";
	private final static String CONQUEST_CONTINENTS = "it.unipv.po.splash.model.risikogame.target.ConquestContinents";

	public DefaultTargetInGameFactory() {
		super();
	}

	@Override
	public TargetInGame getTargetInGame() {
		TargetInGame result = new TargetInGame();
		result.addTargetInGame(CONQUEST_CONTINENTS);
		result.addTargetInGame(CONQUEST_TERRITORY);
		result.addTargetInGame(KILL_PLAYER);
		return result;
	}

}
