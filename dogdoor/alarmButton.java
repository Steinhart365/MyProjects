package dogdoor;
import java.util.*;

public class alarmButton extends button implements activate {

    //constructors
    alarmButton(){
        this.pressed = false;
    }

    alarmButton(boolean pressed){
        this.pressed = pressed;
    }
    //copy constructor
    alarmButton(alarmButton aB){
        this.pressed = aB.pressed;
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
    }

    @Override
    public boolean getPressed() {
        return super.getPressed();
    }

    //these control the ringing of the bell, when called
    Timer t = new Timer();
    TimerTask ring = new TimerTask() {
        @Override
        public void run() {
            System.out.println("BRRRRRRRRRRRRIIIIIIIIIIINNNNNNNNNNNGGGGGGGGGALINGALINGGGGGGG");
        }
    };

    @Override
    public void turnOn() {
        this.setPressed(true);
        for (int i = 0; i < 5; i++) {
        t.scheduleAtFixedRate(ring, 2000, 6);
        } }

    //turning off will stop the ringing
    @Override
    public void turnOff() {
        this.setPressed(false);
        ring.cancel();
    }

    //to string method
    @Override
    public String toString() {
        return "alarmButton{" +
                "t=" + t +
                ", ring=" + ring +
                 ", pressed=" + this.pressed +'}';
    }

    //equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        alarmButton that = (alarmButton) o;
        return Objects.equals(t, that.t) &&
                Objects.equals(ring, that.ring);
    }
}