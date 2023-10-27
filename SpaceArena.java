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

        Fighter fighter = spaceMarines.get(0);
        while(true){
            if(fighter instanceof SpaceMarine){
                if(monsters.isEmpty()){
                    System.out.println("Space Marines win!");
                    break;
                }
                fighter = monsters.get(0);
            } else {
                if(spaceMarines.isEmpty()){
                    System.out.println("Monsters win!");
                    break;
                }
                fighter = spaceMarines.get(0);
            }

            if(fighter.attack(fighter instanceof SpaceMarine ? monsters.get(0) : spaceMarines.get(0))){
                if(fighter instanceof SpaceMarine){
                    if(monsters.get(0).getHp() == 0){
                        monsters.remove(0);
                    }
                } else {
                    if(spaceMarines.get(0).getHp() == 0){
                        spaceMarines.remove(0);
                    }
                }
            }
        }

        return true;
    }

}
