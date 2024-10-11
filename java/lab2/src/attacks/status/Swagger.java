package attacks.attacksclefable;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Stat;

public class Swagger extends StatusMove {
    public Swagger() {
        super(Type.NORMAL, 0, 85);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect.confuse(pokemon);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect e = new Effect().turns(-1).stat(Stat.ATTACK,2);
        pokemon.addEffect(e);
    }

    @Override
    protected String describe() {
        return "Использует Swagger";
    }
}
