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
            return false;
        }
        if (ap < weapon.getApcost()) {
            return false;
        }
        if (weapon.isMelee() && closeTo != fighter) {
            return false;
        }
        ap -= weapon.getApcost();
        weapon.attack();
        fighter.receiveDamage(weapon.getDamage());
        return true;
    }

}
