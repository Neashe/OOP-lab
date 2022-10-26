package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {
    public MoveDirection[] parser(String[] tab){
        ArrayList<MoveDirection> tempArray= new ArrayList<>();
        for(String argument:tab){
            MoveDirection outcome = switch(argument){
                case "f", "forward" -> MoveDirection.FORWARD;
                case "b","backward" ->MoveDirection.BACKWARD;
                case "l","left"->MoveDirection.LEFT;
                case "r","right"->MoveDirection.RIGHT;
                default -> null;
            };
            if (outcome !=null){
                tempArray.add(outcome);
            }
        }
        MoveDirection[] table = new MoveDirection[tempArray.size()];
        tempArray.toArray(table);
        return table;
    }

}
