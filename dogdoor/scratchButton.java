package dogdoor;

import java.util.Objects;

public class scratchButton extends button implements activate{
    boolean caresAboutScratching;

    //constructors
    scratchButton(){
        this.caresAboutScratching=false;
    }

    scratchButton(boolean cares ){
        this.caresAboutScratching = cares;
    }

    scratchButton(boolean cares, boolean pressed){
        this.caresAboutScratching = cares;
        this.pressed = pressed;
    }

    //copy constructor
    scratchButton(scratchButton sB){
        this.pressed = sB.pressed;
        this.caresAboutScratching = sB.caresAboutScratching;
    }

    @Override
    public void turnOn() {
        this.pressed = true;
        caresAboutScratching = true;
        System.out.println("scratch auto-open activated.");
    }

    @Override
    public void turnOff() {
        this.pressed = false;
        caresAboutScratching = false;
        System.out.println("scratch detector deactivated");
    }

    //getters and setters
    public void setCaresAboutScratching(boolean caresAboutScratching) {
        this.caresAboutScratching = caresAboutScratching;
    }

    public boolean getCaresAboutScratching(){return this.caresAboutScratching;}
    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
    }

    @Override
    public boolean getPressed() {
        return super.getPressed();
    }

    public boolean press() {
        super.press(this);
    return this.pressed;}

    //toString and equals
    @Override
    public String toString() {
        return "scratchButton{" +
                "caresAboutScratching=" + caresAboutScratching +
                ", pressed=" + this.pressed +'}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        scratchButton that = (scratchButton) o;
        return caresAboutScratching == that.caresAboutScratching;
    }
}
