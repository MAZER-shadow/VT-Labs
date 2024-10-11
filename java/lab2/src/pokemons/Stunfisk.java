package mypokemons;
import ru.ifmo.se.pokemon.Pokemon;
import attacksmypokemons.attacksstunfisk.Mudshot;
import attacksmypokemons.attacksstunfisk.Spark;
import attacksmypokemons.attacksstunfisk.Tackle;
import attacksmypokemons.attacksstunfisk.Thunder;
import ru.ifmo.se.pokemon.Type;

public class Stunfisk extends Pokemon{
    public Stunfisk(String name,int level){
        super(name,level);
        setType(Type.GROUND,Type.ELECTRIC);
        setStats(109,66,84,81,99,32);
        setMove(new Spark(),new Thunder(),new Mudshot(),new Tackle());
    }
}
