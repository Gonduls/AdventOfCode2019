package day06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Count extends Thread{
    String planet;
    final HashMap<String, List<String>> orbits;
    private int number = 0;
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
     *      set the found variable to true, "return" through the shared classes the planets passed to get to SAN or YOU
     * -else if end of planets is found or if SAN or YOU have already been found:
     *      "return" 0 through the shared classes, join threads, repeat
     */
    @Override
    public void run(){
        if(SharedTotal.Exit())
            return;

        //System.out.println("While " + planet);

        while(orbits.containsKey(planet) && orbits.get(planet).size() == 1){
            //System.out.println("While " + planet);
            if(orbits.get(planet).get(0).equals("SAN")){
                father.FoundSAN = true;
                SharedTotal.FoundSAN = true;
                //System.out.println("4\tSan = " + son.FoundSAN + "\tYOU = " + son.FoundYOU);
                return;
            }
            if(orbits.get(planet).get(0).equals("YOU")){
                father.FoundYOU = true;
                SharedTotal.FoundYOU = true;
                //System.out.println("3\tSan = " + son.FoundSAN + "\tYOU = " + son.FoundYOU);
                return;
            }

            father.answers[index] ++;

            if(orbits.containsKey(planet))
                planet = orbits.get(planet).get(0);
            else{
                father.answers[index] = 0;
                return;
            }
        }

        if(orbits.containsKey(planet) == false) {
            father.answers[index] = 0;
            return;
        }

        if(SharedTotal.Exit()){
            father.answers[index] = 0;
            return;
        }
        if(orbits.get(planet).contains("SAN")){
            father.FoundSAN = true;
            SharedTotal.FoundSAN = true;
            //System.out.println("2\tSan = " + son.FoundSAN + "\tYOU = " + son.FoundYOU);
            return;
        }
        if(orbits.get(planet).contains("YOU")){
            father.FoundYOU = true;
            SharedTotal.FoundYOU = true;
            //System.out.println("1\tSan = " + son.FoundSAN + "\tYOU = " + son.FoundYOU);
            return;
        }

        //initializing new threads
        Count[] sons = new Count[orbits.get(planet).size()];
        SharedSingular son = new SharedSingular(orbits.get(planet).size());
        int i;
        for(i = 0; i< orbits.get(planet).size(); i ++){
            sons[i] = new Count(orbits, orbits.get(planet).get(i), i, son);
            sons[i].run();
        }

        //collecting threads
        for(i = 0; i< orbits.get(planet).size(); i ++){
            try{
                sons[i].join();
            }catch(InterruptedException e){
                System.out.println("Error in joining threads\n" + e);
                return;
            }
            if(son.answers[i] != 0) {
                father.FoundYOU = son.FoundYOU;
                father.FoundSAN = son.FoundSAN;
                father.answers[index] += son.answers[i] + 1;
                System.out.println("Planet " + planet + " dists " + son.answers[i] + " to:");
                System.out.println("\tSan = " + son.FoundSAN + "\tYOU = " + son.FoundYOU);
            }
        }
        if(son.Exit())
            SharedTotal.answer = Arrays.stream(son.answers).sum();

        if(Arrays.stream(son.answers).sum() == 0)
            father.answers[index] = 0;

        return;

    }
}

class SharedTotal{
    static int answer = 0;
    static boolean FoundSAN = false;
    static boolean FoundYOU = false;

    static boolean Exit(){
        return (FoundSAN && FoundYOU);
    }
}

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
