package dogdoor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class barkRecognizer{
    String myDogBark;
    ArrayList<String> barks = new ArrayList<String>();

    //constructors
    barkRecognizer(){
        this.myDogBark = "woofwoof";
       }
    barkRecognizer(String bark){
        myDogBark =bark;
       }

   //copy constructor
    barkRecognizer(barkRecognizer bR){
        this.myDogBark = bR.myDogBark;
    }

    //getters and setters
    public void setMyDogBark(String myDogBark) {
        this.myDogBark = myDogBark;
    }

    public String getMyDogBark() {
        return myDogBark;
    }

    //getter and setter for the arraylist- usually not neceassary, but just in case
    public void setBarks(ArrayList<String> barks) {
        this.barks = barks;
    }

    public ArrayList<String> getBarks() {
        return barks;
    }

    //adding a bark to our ArrayList as it is heard
    public void addBark(bark b){
        barks.add(b.sound);
    }

    //using iterator to check each bark in the arrayList
    Iterator<String> checker = barks.iterator();
    public boolean check(){
        while (checker.hasNext()) {
            if (checker.next() == myDogBark) {
                return true;
            }
            }
    return false;}

    //to string
    @Override
    public String toString() {
        return "barkRecognizer{" +
                "myDogBark='" + myDogBark + '\'' +
                ", barks=" + barks +
                ", checker=" + checker +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        barkRecognizer that = (barkRecognizer) o;
        return Objects.equals(myDogBark, that.myDogBark) &&
                Objects.equals(barks, that.barks) &&
                Objects.equals(checker, that.checker);
    }
}
