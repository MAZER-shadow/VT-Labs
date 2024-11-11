package lab.action;

public abstract class Personage {
    private String name;

    public Personage(String name) {
        this.name = name;
    }

    public abstract void printInformation();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
