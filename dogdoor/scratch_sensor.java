package dogdoor;

import java.util.Objects;

public class scratch_sensor {
    boolean feelsScratching;

    //constructors and copy constructor
    scratch_sensor(){
        feelsScratching=false;
    }
    scratch_sensor(boolean feelsScratching){
        this.feelsScratching = feelsScratching;
    }

    scratch_sensor(scratch_sensor scs){
        this.feelsScratching = scs.feelsScratching;
    }

    //getter and setter
    public boolean getFeelsScratching(){
        return this.feelsScratching;
    }

    public void setFeelsScratching(boolean feelsScratching) {
        this.feelsScratching = feelsScratching;
    }

    // method to simulate sensing a scratch
    public void feelScratch(remote r, door d){
        setFeelsScratching(true);
        System.out.println("scratch detected, sending signal...");
        if(r.caresAboutScratching){
            d.turnOn();
        }
        else{
            System.out.println("scratch-triggered-door function disabled, door still closed.");
    }
    }

    //to string and equals
    @Override
    public String toString() {
        return "scratch_sensor{" +
                "feelsScratching=" + feelsScratching +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        scratch_sensor that = (scratch_sensor) o;
        return feelsScratching == that.feelsScratching;
    }

}
