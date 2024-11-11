package lab.action;

public class Musician extends Personage implements Soundeble {
    private float rating;
    private MusicInstrument instruments;
    private String voice;


    public Musician(String name, MusicInstrument instruments, float rating) {
        super(name);
        setRating(rating);
        this.instruments = instruments;
    }

    public Musician(String name, float rating, String voice) {
        super(name);
        setRating(rating);
        this.voice = voice;
    }

    @Override
    public void printInformation() {
        if (instruments != null) {
            System.out.println("Рейтинг музыканта: " + rating + " звук музыканта:" + voice);
        } else {
            System.out.println("Рейтинг музыканта: " + rating + " звук музыканта: " + instruments.getDescribe());
        }

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Musician musician = (Musician) obj;
        if (rating == musician.getRating() && voice == null && instruments == musician.getInstruments()) {
            return true;
        }else{
            return (rating == musician.getRating() && voice == musician.getVoice() && instruments == null);
        }
    }

    @Override
    public String toString() {
        return "Музыкант: " + getName();
    }

    @Override
    public int hashCode(){
        return (int) rating;
    }

    public void playSound() {
        if (instruments == null) {
            System.out.println(getName() + " издаёт звук " + voice);
        } else {
            System.out.println(getName() + " издаёт " + instruments.getDescribe());
        }
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        if (rating < 0.0 || rating > 10.0) {
            throw new NonExistentRatingException("Присвоен рейтинг музыканта не от 0 до 10");
        }
        this.rating = rating;
    }
    public MusicInstrument getInstruments() {
        return instruments;
    }

    public String getVoice() {
        return voice;
    }
}
