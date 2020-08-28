package dogdoor;

public class openButton extends button implements activate {
    boolean opening;

    //constructors
    openButton() {
        this.opening = false;
    }
    openButton(boolean opening) {
        this.opening = opening;
    }
    openButton(boolean opening, boolean pressed) {
        this.opening = opening;
        this.pressed = pressed;
    }
    //copy constructor
    openButton(openButton oB) {
        this.pressed = oB.pressed;
        this.opening = oB.opening;
    }

    //overriding the button on and off methods
    @Override
    public void turnOn() {
        opening = true;
        setPressed(true);
    }

    @Override
    public void turnOff() {
        opening = false;
        setPressed(false);
    }

    //overriding the getter and setter
    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
    }

    @Override
    public boolean getPressed() {
        return super.getPressed();
    }

    //to string
    public String toString() {
        return "openButton{" +
                "opening=" + opening +
                ", pressed=" + this.pressed + '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        openButton that = (openButton) o;
        return opening == that.opening;
    }
}