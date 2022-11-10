package agh.ics.oop;

public class SimulationEngine implements IEngine{
    MoveDirection[] moveTable;
    IWorldMap map;
    Vector2d[] initialAnimalPositions;

    public SimulationEngine(MoveDirection[] moveTable,IWorldMap map,Vector2d[] initialAnimalPositions){
        this.moveTable = moveTable;
        this.map = map;
        this.initialAnimalPositions = initialAnimalPositions;
        for(Vector2d position:this.initialAnimalPositions){
            this.map.place(new Animal(this.map,position));
        }
    }

    @Override
    public void run() {

        int animalNumb = this.initialAnimalPositions.length;
        int moveNumb = this.moveTable.length;
        for(int i = 0;i<moveNumb;i++){
            Animal animal = (Animal) (this.map.objectAt(this.initialAnimalPositions[i%animalNumb]));
            if (animal != null){
                animal.move(moveTable[i]);
                this.initialAnimalPositions[i%animalNumb] = animal.getPosition();
                //System.out.println("zwierze nr"+(i%animalNumb)+animal.getPosition());

            }

        }
        System.out.println(this.map);
    }
}
