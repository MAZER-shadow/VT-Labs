package pokemons;

import attacks.physical.Pound;

public class Clefairy extends Cleffa{
    public Clefairy(String name, int level){
        super(name, level);
        setStats(70,45,48,60,65,35);
        addMove(new Pound());
    }
}
