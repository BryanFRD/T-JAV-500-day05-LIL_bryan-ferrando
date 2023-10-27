public class SuperMutant extends Monster {

    private static int id = 0;

    protected SuperMutant() {
        super("SuperMutant #" + ++id, 170, 20);
        System.out.println(name + ": Roaarrr!");
        damage = 60;
    }

    @Override
    public void recoverAP() {
        super.recoverAP();
        hp = Math.min(170, hp + 10);
    }

}
