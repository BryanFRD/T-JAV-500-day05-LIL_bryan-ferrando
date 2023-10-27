public class AssaultTerminator extends SpaceMarine {
    public AssaultTerminator(String name) {
        super(name, 150, 30);
        weapon = new PowerFist();
        System.out.println(name + " has teleported from space.");
    }

    @Override
    public void receiveDamage(int damage) {
        super.receiveDamage(Math.max(1, damage - 3));
    }
}
