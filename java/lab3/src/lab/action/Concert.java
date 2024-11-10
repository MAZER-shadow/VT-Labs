package lab.action;

import java.util.ArrayList;
import java.util.List;

public class Concert{
    private String name;
    private Orchestra orchestra;
    private Location location;
    private List<Listener> listeners = new ArrayList<>();

    public Concert(String name, Orchestra orchestra, Location location){
        this.name = name;
        this.orchestra = orchestra;
        this.location = location;
        System.out.println(orchestra.getName() + " объявили о проведении концерта \"" + name + "\"");
    }

    public void play(){
        System.out.println("Оркестр: \"" + orchestra.getName() + "\" начал давать концерт: \"" + name + "\" в " + location.name());
        for (Musician musician :orchestra.getMembers()){
            musician.playSound();
        }
        System.out.println("Оркестр: \"" + orchestra.getName() + "\" закончил давать концерт: \"" + name + "\" в " + location.name());
        for (Listener listener : listeners){
            listener.formRating(orchestra.getGenre(),orchestra.getRating());
        }
        for (Listener listener: getListeners()){
            listener.setState();
            listener.moveHome();
            listener.showEmotional();
        }

    }

    public void addListener(Listener listener){
        listeners.add(listener);
        System.out.println("На концерт пришёл из " + listener.getLocation().name() + " " + listener.getName());
        listener.moveLocation(location);
    }

    public String getName() {
        return name;
    }

    public Orchestra getOrchestra() {
        return orchestra;
    }

    public Location getLocation() {
        return location;
    }

    public List<Listener> getListeners() {
        return listeners;
    }
}
