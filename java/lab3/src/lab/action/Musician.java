package lab.action;

public class Musician extends Personage implements Soundeble{
    private float rating;
    private MusicInstrument Instruments;

    public Musician(String name) throws NonExistentRatingException {
        this(name, MusicInstrument.NOUN, 4.0f);
    }

    public Musician(String name, MusicInstrument Instruments) throws NonExistentRatingException {
        this(name, Instruments, 4.0f);
    }

    public Musician(String name, MusicInstrument Instruments, float rating) throws NonExistentRatingException{
        super(name);
        this.Instruments = Instruments;
        if (rating < 0.0 || rating > 10.0) {
            throw new NonExistentRatingException();
        }
        this.rating = rating;

    }

    public void playSound(){
        System.out.println(getName() + " playing sound");
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
