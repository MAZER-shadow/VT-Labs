package attacks.special;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class Thunder extends SpecialMove {
    public Thunder() {
        super(Type.ELECTRIC,110,70);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random()<=0.3){
            Effect.paralyze(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "Использует Thunder";
    }
}
