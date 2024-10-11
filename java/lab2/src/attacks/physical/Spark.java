package attacks.attacksstunfisk;

import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.PhysicalMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;

public class Spark extends PhysicalMove {
    public Spark() {
        super(Type.ELECTRIC,65,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        if (Math.random()<=0.1){
            Effect.paralyze(pokemon);
        }
    }

    @Override
    protected String describe() {
        return "Использует Spark";
    }
}
