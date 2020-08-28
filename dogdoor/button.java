package dogdoor;

public abstract class button {
    boolean pressed;

    //constructors
    public void button(boolean pressed){
        this.pressed = pressed;
    }
    public void button(){
        this.pressed = false;
    }

    //setter and getter
    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }

    public boolean getPressed(){ return this.pressed; }

    //pressing button toggles truth value of 'pressed' (first press turns on second turns off etc)
    public boolean press(button b) {
        if( b.pressed==false){
        b.setPressed(true);
        }
        else{b.setPressed(false);}
    return b.pressed;}

    //no equals ot to-string, because it's abstract and would never be used. each specific button subclass has them.
}