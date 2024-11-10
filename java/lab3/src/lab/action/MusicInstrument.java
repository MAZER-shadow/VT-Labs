package lab.action;

public enum MusicInstrument {
    GUITAR("звук струн гитары"),
    POT("звук баса от банки"),
    NOUN("звук из горла: ");

    private String describe;

    MusicInstrument(String describe) {
        this.describe = describe;
    }
    public String getDescribe() {
        return describe;
    }
}
