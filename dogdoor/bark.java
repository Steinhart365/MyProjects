package dogdoor;

import java.util.Objects;

public class bark{
    protected String sound;

    //constructors and copy constructor
    bark() {
        this.sound = "barkbarkbark";
    }

    bark(String sound){
        this.sound = sound;
    }

    bark(bark b){
        this.sound = b.sound;
    }

    //getter and setter for sound variable
    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getSound() {
        return this.sound;
    }

    //to string
    @Override
    public String toString() {
        return "bark{" +
                "sound='" + sound + '\'' +
                '}';
    }

    //equals methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        bark bark = (bark) o;
        return Objects.equals(sound, bark.sound);
    }
}

