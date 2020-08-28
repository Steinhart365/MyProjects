package dogdoor;

import java.util.Objects;

public class keypad {
    int input;

    //constructors
    keypad(){
        input = Integer.parseInt(null);
    }
    keypad(int input){
        this.input=input;
    }

    //copy constructor
    keypad(keypad kp){
        this.input = kp.input;
    }

    //getter and setter
    public int getInput() {
        return input;
    }
    public void setInput(int input) {
        this.input = input;
    }

    //to-string
    @Override
    public String toString() {
        return "keypad{" +
                "input=" + input +
                '}';
    }

    //equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        keypad keypad = (keypad) o;
        return input == keypad.input;
    }
}
