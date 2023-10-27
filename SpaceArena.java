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

        SpaceMarine spaceMarine = null;
        Monster monster = null;
        boolean monsterTurn = false;
        while(true){
            if(monsters.isEmpty()){
                System.out.println("The monsters are victorious.");
                break;
            }

            if(spaceMarines.isEmpty()){
                System.out.println("The spaceMarines are victorious.");
                break;
            }

            if(spaceMarine == null || spaceMarine.getHp() == 0){
                if(monster != null){
                    monster.recoverAP();
                }
                if(spaceMarine != null){
                    spaceMarines.remove(0);
                }
                if(spaceMarines.isEmpty()){
                    continue;
                }

                spaceMarine = spaceMarines.get(0);
                System.out.println(spaceMarine.getName() + " has entered the arena.");
            }

            if(monster == null || monster.getHp() == 0){
                if(spaceMarine != null){
                    spaceMarine.recoverAP();
                }
                if(monster != null){
                    monsters.remove(0);
                }
                if(monsters.isEmpty()){
                    continue;
                }

                monster = monsters.get(0);
                System.out.println(monster.getName() + " has entered the arena.");
            }

            if(monsterTurn){
                System.out.println(monster.getHp());
                if(!monster.attack(spaceMarine)){
                    if(monster.closeTo == null || monster.closeTo != spaceMarine){
                        monster.moveCloseTo(spaceMarine);
                    }
                }
            } else {
                System.out.println(spaceMarine.getHp());
                if(!spaceMarine.attack(monster)){
                    if((spaceMarine.closeTo == null || spaceMarine.closeTo != monster) && spaceMarine.getWeapon().isMelee()){
                        spaceMarine.moveCloseTo(monster);
                    }
                }
            }
            monsterTurn = !monsterTurn;
        }

        return true;
    }

}
