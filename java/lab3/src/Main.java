//import lab.action.CommonShorty;
//import lab.action.Shorty;
//import lab.action.SpecialShorty;

import lab.action.*;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        try{
            Musician maks = new Musician("Макс",MusicInstrument.NOUN,5);
            Musician ivan = new Musician("Иван",MusicInstrument.POT,7);
            Musician artem = new Musician("Артем",MusicInstrument.GUITAR,8);
            Musician aleksandr = new Musician("Александр",MusicInstrument.POT,5);
            Musician nikita = new Musician("Никита",MusicInstrument.NOUN,6,"мурчание");
            Musician dmitry = new Musician("Дмитрий",MusicInstrument.NOUN,7,"квакание");
            Musician kirill = new Musician("Кирилл",MusicInstrument.NOUN,8,"лаянье");

            Location placeConcert = new Location("Вологда","Мира 1");

            Listener anton = new Listener("Антон", new Location("дом","Пионерская 32"), Genre.CLASSICAL);
            Listener ruslan = new Listener("Руслан", new Location("дом","Пионерская 31"), Genre.MODERN);
            Listener daniil = new Listener("Даниил", new Location("дом","Пионерская 30"), Genre.MODERN);
            Listener andrey = new Listener("Андрей", new Location("дом","Пионерская 29"), Genre.OLD);
            Listener ilya = new Listener("Илья", new Location("дом","Пионерская 28"), Genre.MODERN);
            Listener egor = new Listener("Егор", new Location("дом","Пионерская 27"), Genre.MODERN);
            Listener vlad = new Listener("Влад", new Location("дом","Пионерская 26"), Genre.OLD);
            Listener aleksey = new Listener("Алексей", new Location("дом","Пионерская 25"), Genre.MODERN);
            Listener roman = new Listener("Роман", new Location("дом","Пионерская 24"), Genre.MODERN);
            


            Orchestra orchestra = new Orchestra(placeConcert,"Banda_52", Genre.MODERN);
            orchestra.addMembers(maks);
            orchestra.addMembers(ivan);
            orchestra.addMembers(artem);
            orchestra.addMembers(aleksandr);
            orchestra.addMembers(nikita);
            orchestra.addMembers(dmitry);
            orchestra.addMembers(kirill);
            orchestra.formRating();

            Concert concert = new Concert("52",orchestra,placeConcert);
            concert.addListener(anton);
            concert.addListener(ruslan);
            concert.addListener(daniil);
            concert.addListener(andrey);
            concert.addListener(ilya);
            concert.addListener(egor);
            concert.addListener(vlad);
            concert.addListener(aleksey);
            concert.addListener(roman);
            concert.play();

        }catch (NonExistentRatingException e){
            System.out.println(e.getMessage());
        }
    }
}

