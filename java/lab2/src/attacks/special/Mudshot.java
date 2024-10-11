package attacks.attacksstunfisk;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Stat;

public class Mudshot extends SpecialMove {
    public Mudshot() {
        super(Type.GROUND,55,95);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon) {
        Effect e = new Effect();
        e.turns(-1).stat(Stat.SPEED,-1);
        pokemon.addEffect(e);
    }

    @Override
    protected String describe() {
        return "Использует Mud shot";
    }
}
