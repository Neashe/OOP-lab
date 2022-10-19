package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        ArrayList<Directions> enumList = new ArrayList<>();
        Directions[] newTable = changeToEnum(args,enumList);
        run(newTable);
    }
    public static void run(Directions[] table){
        System.out.println("System wystartował");
        //kod na wypluwanie reszty
        String sentence ="";
        for(Directions element:table){
            String message = switch(element){
                case FORWARD -> "zwierzak idzie do przodu";
                case BACKWARD -> "zwierzak idzie do tyłu";
                case LEFT -> "zwierzak idzie w lewo";
                case RIGHT -> "zwierzak idzie w prawo";
            };
            sentence = sentence+message+",";
        }
        System.out.println(sentence.substring(0,sentence.length()-1));
        System.out.println("System zakończył działanie");
    }
    public static Directions[] changeToEnum(String[] directions, ArrayList<Directions> enumList){
        for(String argument: directions){
            Directions message = switch(argument){
                case "f"-> Directions.FORWARD;
                case "b" -> Directions.BACKWARD;
                case "l" -> Directions.LEFT;
                case "r" -> Directions.RIGHT;
                default -> null;
            };
            if (message != null) {
                enumList.add(message);
            }
        }
        Directions[] enumArray = new Directions[enumList.size()];
        enumList.toArray(enumArray);
        return enumArray;
    }
}
