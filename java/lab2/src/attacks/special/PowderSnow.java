package attacks.special;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class PowderSnow extends SpecialMove {
    public PowderSnow() {
        super(Type.ICE,40,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random()<=0.1){
            Effect.freeze(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "Использует Powder Snow";
    }
}
