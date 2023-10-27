public class RadScorpion extends Monster {

    private static int id = 0;

    public RadScorpion() {
        super("RadScorpion #" + ++id + ": Crrr!", 80, 50);
        damage = 25;
    }

    @Override
    public boolean attack(Fighter fighter) {
        if (fighter == null) {
            return false;
        }
        if (closeTo != fighter) {
            System.out.println(getName() + ": I'm too far away from " + fighter.getName());
            return false;
        }
        if (ap < apcost) {
            return false;
        }
        ap -= apcost;
        System.out.println(getName() + " attacks " + fighter.getName());

        int dmg = damage * (fighter instanceof AssaultTerminator ? 2 : 1);
        fighter.receiveDamage(dmg);
        return true;
    }
}
