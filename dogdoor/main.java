package dogdoor;

public class main {

    //MAIN METHOD - DEMONSTRATES THE WHOLE PROGRAM

    public static void main(String[] args) {
        //step 1 is to instantiate the door for us to use
        door myDoor = new door();

        //lets start by opening up some windows, by setting a code in keypad and then plugging it in to the remote
        myDoor.r.setWindowCloseCode(666);
        //this will print an error because it's not 5 digits, so we go again
        myDoor.r.setWindowCloseCode(54321);
        //now to open them: first an invalid code entry, an error, then the correct code to open windows
        myDoor.r.windowToggler(65432);
        myDoor.r.windowToggler(54321);

        //now for the barking: first create some barks (mimics hearing live dogs) [NOTE: bark c is my dog's bark]
        bark a = new bark("aroooroooroo");
        bark b = new bark("bababark");
        bark c = new bark("woofwoof");
        bark d = new bark("meeeoooowwwww");

        //use bark recognizer method to add the barks to an array as they come in
        myDoor.brkr.addBark(a);
        myDoor.brkr.addBark(b);
        myDoor.brkr.addBark(c);
        myDoor.brkr.addBark(d);
        if (myDoor.brkr.check()){
            myDoor.turnOn();
        }

        //run the iterator to test the barks, opening for c, and then closing after 15 seconds by use of timer
        //this concludes the barking portion of the program
        myDoor.brkr.check();
        //simulate and track the dog coming inside, using the motion sensor class on the door
        //this will toggle the inside boolean and print an alert message stating where the dog is
        myDoor.mtnSnsr.detectDogMotion();


        //now the manual button to open the door
        myDoor.r.press_open_button(myDoor.r.oB, myDoor);
        //now the dog can head back outside, and the sensor lets us know
        myDoor.mtnSnsr.detectDogMotion();

        // now, if there's something around we don't like,like a neighbor's cat, we can set off an alarm to scare it off
        myDoor.r.press_alarm_button(myDoor.r.aB);

        //next, let's use the scratching option - press the remote button to turn on scratch detection
        myDoor.r.press_scratch_button(myDoor.r.sB);

        //then simulate the door feeling a scratch - method automatically triggers door to open if button has been
        // pressed (using if statement, method in the scratch sensor class)
        myDoor.scratchSnsr.feelScratch(myDoor.r, myDoor);
        //and now, the dog comes right back inside
        myDoor.mtnSnsr.detectDogMotion();
    }
}

