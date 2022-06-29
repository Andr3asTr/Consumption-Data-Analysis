package mainengine;

public class MainEngineFactory {

	public IMainEngine createMainEngine(String engineType) {
		MainEngine mainengine = new MainEngine();
		return mainengine;
	}

}
