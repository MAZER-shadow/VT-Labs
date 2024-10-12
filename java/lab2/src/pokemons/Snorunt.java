package pokemons;

import attacks.special.FrostBreath;
import attacks.special.IceBeam;
import attacks.special.PowderSnow;
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
