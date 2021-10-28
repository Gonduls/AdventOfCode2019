package day07;

import day02.UnknownOpcodeException;
import day05.Rules2;

import java.util.List;

public class IntcodeManager3 extends day05.IntcodeManager2{
    private final int number; // thruster number, used for correct phase setting and different behavior on last thruster
    private final int[] phaseSettings;
    private final IntcodeManager3 next;
    private int input;
    private int[] output = {0};
    private boolean setting = true;

    public IntcodeManager3(List<Integer> list, int[] phaseSettings){
        super(list);
        this.number = 0;
        this.phaseSettings = phaseSettings;
        this.input = 0;
        this.next = new IntcodeManager3(list, 1, phaseSettings, this);

    }
    public IntcodeManager3(List<Integer> list, int number, int[] phaseSettings, IntcodeManager3 first){
        super(list);
        this.number = number;
        this.phaseSettings = phaseSettings;
        if(number<4)
            this.next = new IntcodeManager3(list, number+1, phaseSettings, first);
        else
            this.next = first;

    }

    public void setInput(int input) {
        this.input = input;
    }

    public void giveOutput(int i){
        next.setInput(i);
    }

    public void play() throws UnknownOpcodeException {
        while(intcode.get(index) != endCondition){
            if(intcode.get(index) % 100 == 1){
                index = Rules2.Rule1(intcode, index);
            }
            else if(intcode.get(index) % 100 == 2){
                index = Rules2.Rule2(intcode, index);
            }
            else if(intcode.get(index) % 100 == 3){
                if(setting) {
                    index = Rules3.Rule3(intcode, index, phaseSettings[number]);
                    setting = false;
                }
                else
                    index = Rules3.Rule3(intcode, index, input);

            }
            else if(intcode.get(index) % 100 == 4){
                index = Rules3.Rule4(intcode, index, output);
                giveOutput(output[0]);
                next.play();
                return;
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

        if(number != 4)
            next.play();
        else
            part1.answer = part1.answer > output[0] ? part1.answer : output[0];

    }
}
