package mypokemons;
import attacksmypokemons.attacksglalie.DarkPulse;

public class Glalie extends Snorunt {
    public Glalie(String name, int level) {
        super(name, level);
        setStats(80,80,80,80,80,80);
        addMove(new DarkPulse());
    }
}
