package lab.action;

public class Musician extends Personage implements Soundeble{
    private float rating;
    private MusicInstrument instruments;
    private String voice;

    public Musician(String name) throws NonExistentRatingException {
        this(name, MusicInstrument.NOUN, 4.0f);
    }

    public Musician(String name, MusicInstrument Instruments) throws NonExistentRatingException {
        this(name, Instruments, 4.0f);
    }

    public Musician(String name, MusicInstrument Instruments, float rating) throws NonExistentRatingException {
        this(name, Instruments, rating, "пение");
    }

    public Musician(String name, MusicInstrument Instruments, float rating, String voice) throws NonExistentRatingException{
        super(name);
        this.instruments = Instruments;
        this.rating = rating;
        this.voice = voice;
        if (rating < 0.0 || rating > 10.0) {
            throw new NonExistentRatingException();
        }
        this.rating = rating;

    }

    @Override
    public void printInformation() {
        if (instruments != null && instruments != MusicInstrument.NOUN) {
            System.out.println("Рейтинг музыканта: " + rating + " звук музыканта:" + voice);
        }else {
            System.out.println("Рейтинг музыканта: " + rating + " звук музыканта: " + instruments.getDescribe());
        }

    }

    public void playSound(){
        if (instruments == MusicInstrument.NOUN){
            System.out.println(getName() + " издаёт " +  instruments.getDescribe() + voice);
        } else{
            System.out.println(getName() + " издаёт " +  instruments.getDescribe());
        }
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
