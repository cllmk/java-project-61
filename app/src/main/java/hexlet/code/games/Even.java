package hexlet.code.games;

import hexlet.code.LogicsEven;

public class Even {
    public static void parityCheck() {
        LogicsEven.welcome();
        LogicsEven.setCountCycle(3);
        LogicsEven.setMinMaxRandom(0, 100);
        LogicsEven.run();
    }
}

