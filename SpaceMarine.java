public class SpaceMarine extends Unit {

    protected Weapon weapon;

    public SpaceMarine(String name, int hp, int ap) {
        super(name, hp, ap);
    }

    @Override
    public boolean equip(Weapon weapon) {
        if (this.weapon != null) {
            return false;
        }

        System.out.println(getName() + " has been equipped with a " + weapon.getName());
        this.weapon = weapon;
        return true;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (fighter == null) {
            return false;
        }
        if (weapon == null) {
            System.out.println("Hey, this is crazy. I'm not going to fight this empty-handed.");
            return false;
        }
        if (ap < weapon.getApcost()) {
            return false;
        }
        if (weapon.isMelee()) {
            if(closeTo != fighter) {
                System.out.println(getName() + ": I'm too far away from " + fighter.getName() + ".");
                return false;
            }
        }
        ap -= weapon.getApcost();
        weapon.attack();
        fighter.receiveDamage(weapon.getDamage());
        return true;
    }

    @Override
    public void recoverAP() {
        ap += 9;
        if (ap > 50) {
            ap = 50;
        }
    }



}