package dogdoor;
import java.util.*;

public class door implements activate {
    boolean open;

    //constructors
    door(){
        this.open=false; }

    door(boolean open){
        this.open = open; }

    //copy constructor
    door(door d){
        this.open = d.open;
    }

    //instantiating remote/bark recognizer/sensors - "has a" relationships
      static remote r = new remote();
      static barkRecognizer brkr = new barkRecognizer();
      static motion_sensor mtnSnsr = new motion_sensor();
      static scratch_sensor scratchSnsr = new scratch_sensor();

    // getter and setters
    public boolean getOpen() {
        return this.open; }

    public void setOpen(boolean open) {
        this.open = open; }

    // interface methods to set the open/closed status, and a timer to close once opened
    Timer limit = new Timer();
    @Override
    public void turnOn() {
        this.open = true;
        System.out.println("The door is now open!");
        limit.schedule(close, 15000);
    }

    TimerTask close = new TimerTask() {
        public void run() {
            turnOff();
        }
    };

    @Override
    public void turnOff() {
        this.open = false;
        System.out.println("The door is now closed!");
    }

    //to string method
    @Override
    public String toString() {
        return "door{" +
                "open=" + open +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        door door = (door) o;
        return open == door.open &&
                Objects.equals(limit, door.limit) &&
                Objects.equals(close, door.close);
    }
}
