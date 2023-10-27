public class SuperMutant extends Monster {

    private static int id = 1;

    protected SuperMutant() {
        super("SuperMutant #" + id++, 170, 20);
        System.out.println(name + ": Roaarrr!");
        damage = 60;
        apcost = 20;
    }

    @Override
    public void recoverAP() {
        ap += 7;
        if (ap > 20) {
            ap = 20;
        }
        hp = Math.min(170, hp + 10);
    }

}
