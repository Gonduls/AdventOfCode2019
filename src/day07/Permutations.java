package day07;

import java.util.*;
import java.util.stream.IntStream;

class Permutations implements Iterable<int[]> {
    private final int[] startArray;
    private final int len;
    private int index = 0;
    private Permutations subPer;
    private Iterator<int[]> itr;


    public Permutations(int len){
        this(IntStream.range(0, len).toArray());
    }
    public Permutations(int[] startArray){
        this.startArray = startArray;
        this.len = startArray.length;

        // if this is not a base case of recursion:
        // set sub permutations right off the bat. Later done in while loop.
        if(this.len > 2){
            this.subPer = new Permutations(Arrays.copyOfRange(startArray, 1, this.len));
            itr = subPer.iterator();
        }
    }

    public Iterator<int[]> iterator() {
        return new PermIterator();
    }

    /**
     *  It's essentially a recursive iterator that cycles each number in the startArray;
     *  appending it with all the possible combinations of remaining numbers in startArray.
     *  Had to behave differently for len == 2 case as the base case of recursion
     */
    class PermIterator implements Iterator<int[]>{
        @Override
        public boolean hasNext(){
            if(len == 2)
                return (index < 2);

            // if index has reached last value and sub permutations are done:
            // this level of permutation is done as well
            return(itr.hasNext() || index != len - 1);
        }

        @Override
        public int[] next(){

            if(len == 2){
                index ++;
                return (index <2 ? startArray : new int[]  {startArray[1], startArray[0]});
            }

            if(!itr.hasNext() && index == len - 1)
                throw new NoSuchElementException("No next element");

            // sub permutations are done:
            // change index and create new sub permutations with all values in startArray except startArray[index]
            if (!itr.hasNext()){
                index++;
                int[] toPass = new int[len - 1];
                System.arraycopy(startArray, 0, toPass, 0, index);
                System.arraycopy(startArray, index + 1, toPass, index, len - index - 1);
                subPer = new Permutations(toPass);
                itr = subPer.iterator();

            }

            int[] result = new int[len];
            int[] passed = itr.next();
            result[0] = startArray[index];

            System.arraycopy(passed, 0, result, 1, len -1);

            return result;
        }
    }
}