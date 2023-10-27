import java.util.ArrayList;
import java.util.List;

public class SpaceArena {

    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ArrayList<SpaceMarine> spaceMarines = new ArrayList<SpaceMarine>();

    public void enlistMonsters(List<Monster> monsterList) {
        monsterList.forEach(monster -> {
            if(!monsters.contains(monster)){
                System.out.println(monster.getName() + " has entered the arena.");
                monsters.add(monster);
            }
        });
    }

    public void enlistSpaceMarines(List<SpaceMarine> spaceMarineList) {
        spaceMarineList.forEach(spaceMarine -> {
            if(!spaceMarines.contains(spaceMarine)){
                System.out.println(spaceMarine.getName() + " has entered the arena.");
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
                    System.out.println("The monsters are victorious.");
                    return true;
                }
            } else {
                if(spaceMarines.isEmpty()){
                    System.out.println("The spaceMarines are victorious.");
                    return true;
                }
            }

            Fighter target = fighter instanceof SpaceMarine ? monsters.get(0) : spaceMarines.get(0);
            if(fighter.attack(target)){
                if(target.getHp() == 0){
                    if(target instanceof SpaceMarine)
                        spaceMarines.remove(0);
                    else
                        monsters.remove(0);
                }
            } else {
                fighter.moveCloseTo(target);
            }
            fighter = target;
        }
    }

}
