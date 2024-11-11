//import lab.action.CommonShorty;
//import lab.action.Shorty;
//import lab.action.SpecialShorty;

import lab.action.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Musician maks = new Musician("Макс", 5,"пение");
            Musician ivan = new Musician("Иван", MusicInstrument.POT, 7);
            Musician artem = new Musician("Артем", MusicInstrument.GUITAR, 8);
            Musician aleksandr = new Musician("Александр", MusicInstrument.POT, 3);
            Musician nikita = new Musician("Никита", 6, "мурчание");
            Musician dmitry = new Musician("Дмитрий", 7, "квакание");
            Musician kirill = new Musician("Кирилл", 8, "лаяние");

            Listener anton = new Listener("Антон", new Location("дом", "Пионерская 32"), Genre.CLASSICAL);
            Listener ruslan = new Listener("Руслан", new Location("дом", "Пионерская 31"), Genre.MODERN);
            Listener daniil = new Listener("Даниил", new Location("дом", "Пионерская 30"), Genre.MODERN);
            Listener andrey = new Listener("Андрей", new Location("дом", "Пионерская 29"), Genre.OLD);
            Listener ilya = new Listener("Илья", new Location("дом", "Пионерская 28"), Genre.MODERN);
            Listener egor = new Listener("Егор", new Location("дом", "Пионерская 27"), Genre.MODERN);
            Listener vlad = new Listener("Влад", new Location("дом", "Пионерская 26"), Genre.OLD);
            Listener aleksey = new Listener("Алексей", new Location("дом", "Пионерская 25"), Genre.MODERN);
            Listener roman = new Listener("Роман", new Location("дом", "Пионерская 24"), Genre.MODERN);

            Location placeConcert = new Location("Вологда", "Мира 1");

            Orchestra orchestra = new Orchestra(placeConcert, "Banda_52", Genre.MODERN);
            addMembers(orchestra, maks, ivan, artem, aleksandr, nikita, dmitry, kirill);
            orchestra.formRating();

            Concert concert = new Concert("52", orchestra, placeConcert);
            addMembers(concert, anton, ruslan, andrey, daniil, aleksey, ilya, egor, roman, vlad);
            orchestra.printSize();
            concert.play();

        } catch (NonExistentRatingException | NoMemberFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addMembers(Orchestra orchestra, Musician... musician) {
        for (Musician m : musician) {
            orchestra.addMember(m);
        }
    }
    public static void addMembers(Concert concert, Listener... listeners) {
        for (Listener m : listeners) {
            concert.addListener(m);
        }
    }
}

