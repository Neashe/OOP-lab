package agh.ics.oop;

import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        //MapDirectionCheck
        MapDirection test = MapDirection.NORTH;
        System.out.println(test.next());
        System.out.println(test.previous());
        System.out.println(test);
        System.out.println(test.toUnitVector());
        System.out.println("---------------------");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

//        Laby1
//        ArrayList<Directions> enumList = new ArrayList<>();
//        Directions[] newTable = changeToEnum(args,enumList);
//        run(newTable);
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
