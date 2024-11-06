package lab.action;

public enum State {
    HAPPY("дикая радость"),
    ANGRY("дикое недовольство"),
    NORMAL("асболютное спокойствие");

    private final String description;

    State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}