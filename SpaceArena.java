import java.util.ArrayList;
import java.util.List;

public class SpaceArena {

    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ArrayList<SpaceMarine> spaceMarines = new ArrayList<SpaceMarine>();

    public void enlistMonsters(List<Monster> monsterList) {
        monsterList.forEach(monster -> {
            if(!monsters.contains(monster)){
                monsters.add(monster);
            }
        });
    }

    public void enlistSpaceMarines(List<SpaceMarine> spaceMarineList) {
        spaceMarineList.forEach(spaceMarine -> {
            if(!spaceMarines.contains(spaceMarine)){
                spaceMarines.add(spaceMarine);
            }
        });
    }

    public boolean fight(){
        if(monsters.isEmpty()){
            System.out.println("No monsters available to fight.");
            return false;
        }
        if(spaceMarines.isEmpty()){
            System.out.println("Those cowards ran away.");
            return false;
        }

        SpaceMarine spaceMarine = spaceMarines.get(0);
        Monster monster = monsters.get(0);
        boolean monsterTurn = false;
        while(true){
            if(monsters.isEmpty()){
                System.out.println("The monsters are victorious.");
                return false;
            }
            if(spaceMarines.isEmpty()){
                System.out.println("The spaceMarines are victorious.");
                return false;
            }

            if(spaceMarine.getHp() == 0){
                monster.recoverAP();
                spaceMarines.remove(0);
                spaceMarine = spaceMarines.get(0);
                System.out.println("");
            }
            if(monster.getHp() == 0){
                spaceMarine.recoverAP();
                monsters.remove(0);
                monster = monsters.get(0);
                System.out.println("");
            }

            if(monsterTurn){
                if(!(monster.closeTo == null)){
                    monster.moveCloseTo(spaceMarine);
                } else {
                    monster.attack(spaceMarine);
                }
            } else {
                if(!(spaceMarine.closeTo == null)){
                    spaceMarine.moveCloseTo(monster);
                } else {
                    spaceMarine.attack(monster);
                }
            }
            monsterTurn = !monsterTurn;
        }
    }

}
