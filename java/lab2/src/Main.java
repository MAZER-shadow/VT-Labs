import pokemons.*;
import ru.ifmo.se.pokemon.Battle;

public class Main {
    public static void main(String[] args) {
        Stunfisk a1 = new Stunfisk("Maga",1);
        Snorunt a2 = new Snorunt("Shax",1);
        Glalie b1 = new Glalie("Cheburashka",1);
        Cleffa b2 = new Cleffa("Gena",1);
        Clefairy a3 = new Clefairy("Ronaldo",1);
        Clefairy b3 = new Clefairy("Messi",1);
        Battle go = new Battle();
        go.addAlly(a1);
        go.addAlly(a2);
        go.addAlly(a3);
        go.addFoe(b1);
        go.addFoe(b2);
        go.addFoe(b3);
        go.go();
    }
}