public class RadScorpion extends Monster {

    private static int id = 1;

    public RadScorpion() {
        super("RadScorpion #" + id++, 80, 50);
        System.out.println(name + ": Crrr!");
        damage = 25;
        apcost = 8;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (fighter == null) {
            return false;
        }
        if (closeTo != fighter) {
            System.out.println(getName() + ": I'm too far away from " + fighter.getName() + ".");
            return false;
        }
        if (ap < apcost) {
            return false;
        }
        ap -= apcost;
        System.out.println(getName() + " attacks " + fighter.getName() + ".");

        int dmg = damage * ((fighter instanceof AssaultTerminator || fighter instanceof Monster) ? 1 : 2);
        fighter.receiveDamage(dmg);
        return true;
    }

}
