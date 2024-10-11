package Attacksmypokemons.Attacksglalie;

import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class FrostBreath extends SpecialMove {
    public FrostBreath() {
        super(Type.ICE,60,90);
    }

    @Override
    protected double calcCriticalHit(Pokemon p, Pokemon p1) {
        return 1.5;
    }

    @Override
    protected String describe() {
        return "Использует FrostBreath";
    }
}
