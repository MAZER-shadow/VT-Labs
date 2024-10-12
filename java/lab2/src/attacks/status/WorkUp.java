package attacks.status;

import ru.ifmo.se.pokemon.StatusMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Stat;

public class WorkUp extends StatusMove {
    public WorkUp() {
        super(Type.NORMAL,0,0);
    }

    @Override
    protected void applySelfEffects(Pokemon pokemon) {
        Effect e = new Effect().turns(-1).stat(Stat.ATTACK,1);
        pokemon.addEffect(e);
        Effect b = new Effect().turns(-1).stat(Stat.SPECIAL_ATTACK,1);
        pokemon.addEffect(b);
    }

    @Override
    protected String describe() {
        return "Использует Work Up";
    }
}
