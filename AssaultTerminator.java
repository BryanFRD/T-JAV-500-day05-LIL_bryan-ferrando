public class AssaultTerminator extends SpaceMarine {
    public AssaultTerminator(String name) {
        super(name, 150, 30);
        System.out.println(name + " has teleported from space.");
        equip(weapon = new PowerFist());
    }

    @Override
    public void receiveDamage(int damage) {
        super.receiveDamage(Math.max(1, damage - 3));
    }
}
