import java.util.ArrayList;
import java.util.List;

public class SpaceArena {

    private ArrayList<Monster> monsters = new ArrayList<Monster>();
    private ArrayList<SpaceMarine> spaceMarines = new ArrayList<SpaceMarine>();
    private SpaceMarine spaceMarine;
    private Monster monster;
    private boolean monsterTurn = false;

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

        if(spaceMarine == null || spaceMarine.getHp() == 0){
            spaceMarine = spaceMarines.get(0);
            System.out.println(spaceMarine.getName() + " has entered the arena.");
        }

        if(monster == null || monster.getHp() == 0){
            monster = monsters.get(0);
            System.out.println(monster.getName() + " has entered the arena.");
            monsterTurn = false;
        }

        while(true){
            if(spaceMarines.isEmpty()){
                System.out.println("The monsters are victorious.");
                break;
            }

            if(monsters.isEmpty()){
                System.out.println("The spaceMarines are victorious.");
                break;
            }

            if(spaceMarine.getHp() == 0){
                //monster.recoverAP();

                spaceMarines.remove(0);
                if(spaceMarines.isEmpty()){
                    continue;
                }
                spaceMarine = spaceMarines.get(0);
                System.out.println(spaceMarine.getName() + " has entered the arena.");
            }

            if(monster.getHp() == 0){
                //spaceMarine.recoverAP();

                monsters.remove(0);
                if(monsters.isEmpty()){
                    continue;
                }

                monster = monsters.get(0);
                System.out.println(monster.getName() + " has entered the arena.");
                monsterTurn = false;
            }

            if(monsterTurn){
                if(!monster.attack(spaceMarine)){
                    if(monster.closeTo == null || monster.closeTo != spaceMarine){
                        monster.moveCloseTo(spaceMarine);
                    } else if(monster.getAp() <= 0 || monster.getApcost() > monster.getAp()) {
                        monster.recoverAP();
                    }
                } else {
                    if(spaceMarine.getHp() <= 0){
                        monster.recoverAP();
                    }
                }
            } else {
                if(!spaceMarine.attack(monster)){
                    if((spaceMarine.closeTo == null || spaceMarine.closeTo != monster) && spaceMarine.getWeapon().isMelee()){
                        spaceMarine.moveCloseTo(monster);
                    } else if(spaceMarine.getAp() <= 0 || spaceMarine.getWeapon().getApcost() > spaceMarine.getAp()) {
                        spaceMarine.recoverAP();
                    }
                } else {
                    if(monster.getHp() <= 0){
                        spaceMarine.recoverAP();
                    }
                }
            }

            monsterTurn = !monsterTurn;
        }

        return true;
    }

}
