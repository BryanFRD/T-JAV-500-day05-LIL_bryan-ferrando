public abstract class Monster extends Unit {

    protected int damage = 0;
    protected int apcost = 0;

    protected Monster(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    public int getDamage(){
        return damage;
    }
    public int getApcost(){
        return apcost;
    }

    @Override
    public boolean equip(Weapon weapon) {
        System.out.println("Monsters are proud and fight with their own bodies.");
        return false;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (fighter == null || ap < apcost) {
            return false;
        }
        if (closeTo != fighter) {
            System.out.println(getName() + ": I'm too far away from " + fighter.getName() + ".");
            return false;
        }

        ap -= apcost;
        System.out.println(getName() + " attacks " + fighter.getName() + ".");
        fighter.receiveDamage(damage);
        return true;
    }

}
