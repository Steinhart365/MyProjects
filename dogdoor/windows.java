package dogdoor;

import java.util.Objects;

public class windows implements activate{
    boolean open;

    //constructors
    windows(){
        this.open = false;
    }
    windows(boolean open){
        this.open = open;
    }
    //copy constructor
    windows(windows w){
        this.open = w.open;
    }

    public boolean getOpen() {
        return this.open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    // using the interface methods to set open or closed
    @Override
    public void turnOn() {
        this.setOpen(true);
        System.out.println("Windows now open");
    }

    @Override
    public void turnOff() {
        this.setOpen(false);
        System.out.println("windows shut");
    }

    //to string
    @Override
    public String toString() {
        return "windows{" +
                "open=" + open +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        windows windows = (windows) o;
        return open == windows.open;
    }
}
