package lab.action;

import javax.swing.*;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import java.awt.event.ActionListener;

public class Listener extends Personage implements Moveble {
    private Location location;
    private Location homeLocation;
    private State state;
    private Genre loveGenre;
    private double rating;

    public Listener(String name) {
        this(name, new Location("дом", "Unknown"));
    }

    public Listener(String name, Location location) {
        this(name, location, Genre.CLASSICAL);
    }

    public Listener(String name, Location homeLocation, Genre genre) {
        super(name);
        this.homeLocation = homeLocation;
        this.location = homeLocation;
        loveGenre = genre;
    }

    public void showEmotional() {
        System.out.println("выражает " + state.getDescription());
    }

    public void formRating(Genre genre, double rating) {
        if (loveGenre == genre) {
            this.rating = 2 + rating;
        } else {
            this.rating = rating;
        }

    }

    public void moveLocation(Location location) {
        System.out.println(getName() + " пришёл из " + this.location.address() + " в " + location.address());
        this.location = location;
    }

    public void moveHome() {
        System.out.println(getName() + " пришёл из " + this.location.address() + " в " + homeLocation.name());
        this.location = homeLocation;
    }

    @Override
    public void printInformation() {
        System.out.println("Локация слушателя: " + location.name() + " домашняя локация: " + homeLocation.name() + " любимый жанр: " + loveGenre.name());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Listener listener = (Listener) obj;
        return loveGenre == listener.getLoveGenre();
    }

    @Override
    public int hashCode(){
        return loveGenre.name().hashCode();
    }

    @Override
    public String toString() {
        return "Слушатель: " + getName();
    }

    public State getState() {
        return state;
    }

    public void setState() {
        if (rating > 0 && rating < 4) {
            state = State.ANGRY;
        } else if (rating >= 4 && rating <= 7) {
            state = State.NORMAL;
        } else {
            state = State.HAPPY;
        }

    }

    public Genre getLoveGenre() {
        return loveGenre;
    }

    public void setLoveGenre(Genre loveGenre) {
        this.loveGenre = loveGenre;
    }

    public double getRating() {
        return rating;
    }

    public Location getLocation() {
        return location;
    }

    public Location getHomeLocation() {
        return homeLocation;
    }

    public void setHomeLocation(Location homeLocation) {
        this.homeLocation = homeLocation;
    }
}