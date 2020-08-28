package dogdoor;

public class motion_sensor{
    boolean myDogInside;

    //constructors
    motion_sensor() {
        this.myDogInside = false;
    }

    motion_sensor(boolean myDogInside) {
        this.myDogInside = myDogInside;
    }
    //copy constructor
    motion_sensor(motion_sensor ms){
        this.myDogInside = ms.myDogInside;
    }

    //getter and setter
    public void setMyDogInside(boolean myDogInside) {
        this.myDogInside = myDogInside;
    }
    public boolean getMyDogInside() {
        return this.myDogInside;
    }
    //this method detects movement through the door and sets the inside/outside variable
    public void detectDogMotion() {
        if (!this.getMyDogInside()) {
            this.setMyDogInside(true);
            System.out.println("Alert: my dog has entered the house.");
        } else {
            this.setMyDogInside(false);
            System.out.println("Alert: the dog has left the building.");
        }
    }

    //to string
    @Override
    public String toString() {
        return "motion_sensor{" +
                "myDogInside=" + myDogInside +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        motion_sensor that = (motion_sensor) o;
        return myDogInside == that.myDogInside;
    }
}

