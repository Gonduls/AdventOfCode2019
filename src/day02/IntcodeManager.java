package day02;

import java.util.List;

public class IntcodeManager {

    private int index = 0;
    private List<Integer> intcode;
    private int endCondition = 99;

    public IntcodeManager(List<Integer> list){
        intcode = list;
    };
    public IntcodeManager(List<Integer> list, int index){
        intcode = list;
        this.index = index;
    }

    public void play() throws UnknownOpcodeException {
        while(intcode.get(index) != endCondition){
            if(intcode.get(index) == 1){
                index = Rules.Rule1(intcode, index);
            }
            else if(intcode.get(index) == 2){
                index = Rules.Rule2(intcode, index);
            }
            else
                throw new UnknownOpcodeException("Opcode not 1,2 or " + endCondition);
        }

    }
}
