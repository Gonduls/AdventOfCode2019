package day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Count extends Thread{
    String planet;
    final HashMap<String, List<String>> orbits;
    private final int index;
    private SharedSingular father, son;

    public Count(HashMap<String, List<String>> orbits){
        this(orbits, "COM", 0, new SharedSingular(1));
    }
    public Count(HashMap<String, List<String>> orbits, String firstPlanet, int index, SharedSingular father){
        this.orbits = orbits;
        this.planet = firstPlanet;
        this.index = index;
        this.father = father;
    }

    /**
     * threads activity:
     * -as long as a planet only has one orbiting planet around itself:
     *      go down the line to the next planet, keep track of how many planets have passed
     * -when more planets are orbiting the current one:
     *      make a new thread for every planet doing so
     * -if SAN or YOU are found:
     *      set found variables to true, "return" through the shared classes the planets passed to get to SAN or YOU
     * -else if end of planets is found or if SAN or YOU have already been found:
     *      "return" -1 through the shared classes, join threads, repeat
     */
    @Override
    public void run(){
        if(SharedTotal.Exit()) {
            father.answers[index] = -1;
            return;
        }

        // as long as there is a row of single planets: follow it until SAN|YOU|more than 1 planet|no planets  are found
        while(orbits.containsKey(planet) && orbits.get(planet).size() == 1){

            if(orbits.get(planet).get(0).equals("SAN")){
                father.FoundSAN = true;
                SharedTotal.FoundSAN = true;
                return;
            }
            if(orbits.get(planet).get(0).equals("YOU")){
                father.FoundYOU = true;
                SharedTotal.FoundYOU = true;
                return;
            }

            father.answers[index] ++;
            planet = orbits.get(planet).get(0);

        }

        // end of the line not finding SAN or YOU
        if(orbits.containsKey(planet) == false) {
            father.answers[index] = -1;
            return;
        }

        // if other threads already succeeded just exit
        if(SharedTotal.Exit()){
            father.answers[index] = -1;
            return;
        }

        if(orbits.get(planet).contains("SAN")){
            father.FoundSAN = true;
            SharedTotal.FoundSAN = true;
            return;
        }
        if(orbits.get(planet).contains("YOU")){
            father.FoundYOU = true;
            SharedTotal.FoundYOU = true;
            return;
        }

        //initializing new threads
        Count[] sons = new Count[orbits.get(planet).size()]; //threads variables
        son = new SharedSingular(orbits.get(planet).size()); //shared variable
        int i;

        for(i = 0; i< orbits.get(planet).size(); i ++){
            sons[i] = new Count(orbits, orbits.get(planet).get(i), i, son);
            son.answers[i] = 0;
            sons[i].start();
        }


        //collecting threads
        for(i = 0; i< orbits.get(planet).size(); i ++) {
            try {
                sons[i].join();

                // propagating found results
                if (son.FoundYOU)
                    father.FoundYOU = true;
                if (son.FoundSAN)
                    father.FoundSAN = true;

            }
            catch (InterruptedException e) {
                System.out.println("Error in joining threads\n" + e);
                return;
            }

            if (son.answers[i] != -1)
                father.answers[index] += son.answers[i] + 1;
        }

        // if this planet is the "last common ancestor": add up the distances to SAN and YOU and get the result
        if(son.Exit()) {
            SharedTotal.answer = Arrays.stream(son.answers).sum() + 2; // adds all elements in an array
            // prevent from propagating the Found = true result to father (it would overwrite the result)
            father.FoundYOU = false;
            father.FoundSAN = false;
            father.answers[index] = -1;
            return;
        }

        // if this planet only leads to dead ends: "return" -1
        if(!son.FoundSAN && !son.FoundYOU)
            father.answers[index] = -1;

        return;
    }
}

/**
 * Class shared between all threads, holds answer and return conditions
 */
class SharedTotal{
    static int answer = 0;
    static boolean FoundSAN = false;
    static boolean FoundYOU = false;

    static boolean Exit(){
        return (FoundSAN && FoundYOU);
    }
}

/**
 * Class only shared between a thread and its sons, needed to propagate found results and return conditions
 */
class SharedSingular{
    int[] answers;
    boolean FoundSAN = false;
    boolean FoundYOU = false;

    SharedSingular(int num){
        answers = new int[num];
    }

    boolean Exit(){
        return(FoundSAN && FoundYOU);
    }
}
