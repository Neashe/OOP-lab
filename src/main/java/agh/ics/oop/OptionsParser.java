package agh.ics.oop;

import java.util.ArrayList;
public class OptionsParser {
    public MoveDirection[] parse(String[] tab) throws IllegalArgumentException{
        ArrayList<MoveDirection> tempArray= new ArrayList<>();
        for(String argument:tab){
            switch(argument){
                case "f", "forward" -> tempArray.add(MoveDirection.FORWARD);
                case "b","backward" ->tempArray.add(MoveDirection.BACKWARD);
                case "l","left"->tempArray.add(MoveDirection.LEFT);
                case "r","right"->tempArray.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(argument+ " nie jest poprawnym argumentem!");
            };
        }
        MoveDirection[] table = new MoveDirection[tempArray.size()];
        tempArray.toArray(table);
        return table;
    }
}
