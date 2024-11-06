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
    }

    public void addListener(Listener listener){
        listeners.add(listener);
        System.out.println("На концерт пришёл " + listener.getName());
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
}
