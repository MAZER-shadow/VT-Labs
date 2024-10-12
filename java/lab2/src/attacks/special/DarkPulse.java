package attacks.special;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;

public class DarkPulse extends SpecialMove {
    public DarkPulse() {
        super(Type.DARK,80,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random()<=0.2){
            Effect.flinch(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "Использует Dark Pulse";
    }
}
