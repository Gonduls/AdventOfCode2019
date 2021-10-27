package day05;

import day02.UnknownOpcodeException;

import java.util.List;

public class IntcodeManager2 extends day02.IntcodeManager{
    public IntcodeManager2(List<Integer> list){
        super(list);
    }
    public IntcodeManager2(List<Integer> list, int index){
        super(list, index);
    }

    public void play() throws UnknownOpcodeException{
        while(intcode.get(index) != endCondition){
            if(intcode.get(index) % 100 == 1){
                index = Rules2.Rule1(intcode, index);
            }
            else if(intcode.get(index) % 100 == 2){
                index = Rules2.Rule2(intcode, index);
            }
            else if(intcode.get(index) % 100 == 3){
                index = Rules2.Rule3(intcode, index);
            }
            else if(intcode.get(index) % 100 == 4){
                index = Rules2.Rule4(intcode, index);
            }
            else if(intcode.get(index) % 100 == 5){
                index = Rules2.Rule5(intcode, index);
            }
            else if(intcode.get(index) % 100 == 6){
                index = Rules2.Rule6(intcode, index);
            }
            else if(intcode.get(index) % 100 == 7){
                index = Rules2.Rule7(intcode, index);
            }
            else if(intcode.get(index) % 100 == 8){
                index = Rules2.Rule8(intcode, index);
            }
            else
                throw new UnknownOpcodeException("Opcode not 1, 2, 3, 4, 5, 6, 7, 8 or " + endCondition);
        }

    }

}
