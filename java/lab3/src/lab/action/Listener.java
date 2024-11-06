package lab.action;

import javax.swing.text.html.HTMLDocument;
import java.awt.event.ActionListener;

public class Listener extends Personage implements Moveble {
    private Location location;
    private State state;
    private Genre loveGenre;
    private double rating;

    public Listener(String name) {
        this(name, new Location("дом"));
    }
    public Listener(String name, Location location) {
        this(name, location, State.NORMAL);
    }
    public Listener(String name, Location location, State state) {
        super(name);
        this.location = location;
        this.state = state;
    }

    public void showEmotional(){
        System.out.println("выражает"+ state.getDescription());
    }

    public void moveLocation(Location location) {
        System.out.println("Пришёл из "+this.location.name()+" в "+location.name());
        this.location = location;
    }

    public State getState() {
        return state;
    }
}
