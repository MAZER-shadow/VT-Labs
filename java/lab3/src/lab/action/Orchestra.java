package lab.action;

import java.util.List;
import java.util.ArrayList;

public class Orchestra implements Moveble {
    private Location location;
    private String name;
    private Genre genre;
    private List<Musician> members = new ArrayList<>();
    private double rating;


    public Orchestra() {
        this("Unknown");
    }

    public Orchestra(String name) {
        this(new Location("Unknown", "Unknown"), name);
    }

    public Orchestra(Location location, String name) {
        this(location, name, Genre.CLASSICAL);
    }

    public Orchestra(Location location, String name, Genre genre) {
        this.location = location;
        this.name = name;
        this.genre = genre;
        System.out.println("Появился оркестр: \"" + this.getName() + "\" " + "c жанром: " + genre);
    }

    public void addMember(Musician member) {
        this.members.add(member);
        System.out.println("К оркестру \"" + name + "\" присоеденился " + member.getName());
    }

    public void removeMembers(Musician member) {
        this.members.remove(member);
    }

    public void formRating() {
        for (Musician member : members) {
            rating += member.getRating();
        }
        rating = rating / this.members.size();
    }

    public void printSize(){
        System.out.println("Оркестр состоит из " + members.size() + " человек");
    }

    public Location getLocation() {
        return location;
    }

    public void moveLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public List<Musician> getMembers() {
        List<Musician> xxx = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            xxx.add(members.get(i));
        }
        return xxx;
    }

    public double getRating() {
        return rating;
    }
}
