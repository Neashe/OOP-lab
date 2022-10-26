package agh.ics.oop;


public class World {
    public static void main(String[] args) {
        //Laby3
        Animal kotek = new Animal();
        System.out.println(kotek);
        MoveDirection[] moveDirections=new OptionsParser().parser(args);
        for(MoveDirection argument : moveDirections){
            kotek.move(argument);
        }
        System.out.println(kotek);
    }
}
