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

        while(!monsters.isEmpty() && !spaceMarines.isEmpty()){
            for(int i = 0; i < spaceMarines.size(); i++){
                if(monsters.isEmpty()){
                    break;
                }
                if(spaceMarines.get(i).getHp() <= 0){
                    spaceMarines.remove(i);
                    i--;
                    continue;
                }
                Monster monster = monsters.get(0);
                spaceMarines.get(i).attack(monster);
                if(monster.getHp() <= 0){
                    monsters.remove(0);
                }
            }
            for(int i = 0; i < monsters.size(); i++){
                if(spaceMarines.isEmpty()){
                    break;
                }
                if(monsters.get(i).getHp() <= 0){
                    monsters.remove(i);
                    i--;
                    continue;
                }
                SpaceMarine spaceMarine = spaceMarines.get(0);
                monsters.get(i).attack(spaceMarine);
                if(spaceMarine.getHp() <= 0){
                    spaceMarines.remove(0);
                }
            }
        }

        return true;
    }

}
