//import lab.action.CommonShorty;
//import lab.action.Shorty;
//import lab.action.SpecialShorty;

import lab.action.*;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        try{
            Musician maks = new Musician("Maks",MusicInstrument.NOUN,10);

            Listener anton = new Listener("Anton");

            Location vologda = new Location("Vologda");

            Orchestra orchestra = new Orchestra(vologda,"Banda_52", Genre.MODERN);
            orchestra.addMembers(maks);

            Concert concert = new Concert("52",orchestra,vologda);
            concert.addListener(anton);
            concert.play();
        }catch (NonExistentRatingException e){
            System.out.println(e.getMessage());
        }
    }
}

