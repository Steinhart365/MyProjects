package dogdoor;

import java.util.ArrayList;
import java.util.Objects;

public class remote {
    int windowCloseCode;
    boolean caresAboutScratching;
    //The CaresAboutScratching variable determines whether or not feeling a scratch will cause the door to open.
    //The actual detection of a scratch is in the feelsScratching variable in the scratch_sensor class,
    // because the sensor on the door itself feels the scratch, not the remote

    //constructors contingent on different parameter combinations given
    remote(){
        this.windowCloseCode = Integer.parseInt(null);
        this.caresAboutScratching= false;
    }
    remote(int code){
        this.windowCloseCode = code;
        this.caresAboutScratching =false;
    }
    remote(boolean cares){
        this.caresAboutScratching = cares;
        this.windowCloseCode= Integer.parseInt(null);
    }
    remote(int code, boolean cares){
        this.windowCloseCode = code;
        this.caresAboutScratching = cares;
    }
    //copy constructor
    remote(remote r){
        this.caresAboutScratching = r.caresAboutScratching;
        this.windowCloseCode = r.windowCloseCode;
    }

    //aggregate instantiations- "has a" relationships
    windows w = new windows();
    keypad kp = new keypad();
    alarmButton aB = new alarmButton();
    openButton oB = new openButton();
    scratchButton sB = new scratchButton();


    //using polymorphism to fill the arraylist with buttons (this is not really utilized anywhere in current system, but it could be);
    ArrayList<button> buttons = new ArrayList<button>();
    public void register_buttons(){
        buttons.add(aB);
        buttons.add(oB);
        buttons.add(sB);
    }

    //window code setter with validation
    public void setWindowCloseCode(int code) {
        kp.setInput(code);
        if (String.valueOf(code).length() == 5) {
            this.windowCloseCode = code;
        } else {
            windowCloseCode= Integer.parseInt(null);
            System.out.println("code must be exactly 5 numbers long");
        }
    }

    //getter for code
    public int getWindowCloseCode() {
        return windowCloseCode;
    }

    //acceptor of code to close or open windows
    public void windowToggler(int i) {
        kp.setInput(i);
        if (i == windowCloseCode) {
            if (w.open == true) {
                w.turnOff();
            } else {
                w.turnOn();
            }
        } else {
            System.out.println("invalid code");
        }}

 //this section of code simulates the pressing of each button- alarm, open, scratch_detection

    //the alarm button control
    public void press_alarm_button(alarmButton a){
        if(!a.getPressed()){
        a.turnOn();}
        else{
        a.turnOff();}}

    //scratch button control
    public void press_scratch_button(scratchButton s){
        if(!s.getPressed()){
            s.turnOn();}
        else{ s.turnOff();}}

    //open button control
    public void press_open_button(openButton o, door d){
        if(!o.getPressed()){
            o.turnOn();
        d.turnOn();}
        else{ o.turnOff();}}

    //to string method for all the info in remote
    @Override
    public String toString() {
        return "remote{" +
                "windowCloseCode=" + windowCloseCode +
                ", caresAboutScratching=" + caresAboutScratching +
                ", w=" + w +
                ", buttons=" + buttons +
                '}';
    }

    //equals method for all the info in remote
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        remote remote = (remote) o;
        return windowCloseCode == remote.windowCloseCode &&
                caresAboutScratching == remote.caresAboutScratching &&
                Objects.equals(w, remote.w) &&
                Objects.equals(kp, remote.kp) &&
                Objects.equals(aB, remote.aB) &&
                Objects.equals(oB, remote.oB) &&
                Objects.equals(sB, remote.sB) &&
                Objects.equals(buttons, remote.buttons);
    }
}

