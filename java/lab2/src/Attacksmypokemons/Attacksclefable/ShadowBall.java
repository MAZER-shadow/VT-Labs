package Attacksmypokemons.Attacksclefable;

import ru.ifmo.se.pokemon.SpecialMove;
import ru.ifmo.se.pokemon.Pokemon;
import ru.ifmo.se.pokemon.Type;
import ru.ifmo.se.pokemon.Effect;
import ru.ifmo.se.pokemon.Stat;

public class ShadowBall extends SpecialMove {
    public ShadowBall() {
        super(Type.GHOST,80,100);
    }

    @Override
    protected void applyOppEffects(Pokemon pokemon){
        Effect e = new Effect();
        e.chance(0.2).turns(-1).stat(Stat.SPECIAL_DEFENSE,-1);
        pokemon.addEffect(e);
    }

    @Override
    protected String describe() {
        return "Использует Shadow Ball";
    }
}
