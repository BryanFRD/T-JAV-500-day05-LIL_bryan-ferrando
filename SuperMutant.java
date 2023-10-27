public class SuperMutant extends Monster {

    private static int id = 0;

    protected SuperMutant() {
        super("SuperMutant #" + ++id + ": Roaarrr!", 170, 20);
        damage = 60;
    }

    @Override
    public void recoverAP() {
        super.recoverAP();
        hp = Math.min(170, hp + 10);
    }

}
