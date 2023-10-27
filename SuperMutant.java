public class SuperMutant extends Monster {

    private static int id = 1;

    protected SuperMutant() {
        super("SuperMutant #" + id++, 170, 20);
        System.out.println(name + ": Roaarrr!");
        damage = 60;
        apcost = 20;
    }

}
