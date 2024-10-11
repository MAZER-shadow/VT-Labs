package mypokemons;

import attacksmypokemons.attacksglalie.FrostBreath;
import attacksmypokemons.attacksglalie.IceBeam;
import attacksmypokemons.attacksglalie.PowderSnow;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Snorunt extends Pokemon {
    public Snorunt(String name, int level) {
        super(name, level);
        setType(Type.ICE);
        setStats(50,50,50,50,50,50);
        setMove(new FrostBreath(),new PowderSnow(),new IceBeam());
    }
}
