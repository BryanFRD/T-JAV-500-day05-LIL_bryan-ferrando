public abstract class Unit implements Fighter {

    protected String name;
    protected int hp;
    protected int ap;
    protected Fighter closeTo;

    protected Unit(String name, int hp, int ap) {
        this.name = name;
        this.hp = hp;
        this.ap = ap;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHp() {
        return hp;
    }

    @Override
    public int getAP() {
        return ap;
    }

    @Override
    public void receiveDamage(int damage) {
        if (damage < 0) {
            return;
        }
        if (damage > hp) {
            hp = 0;
        } else {
            hp -= damage;
        }
    }

    @Override
    public boolean moveCloseTo(Fighter fighter) {
        if(fighter == null || fighter == this) {
            return false;
        }

        if (closeTo == fighter) {
            return false;
        }

        this.closeTo = fighter;
        return true;
    }

    @Override
    public void recoverAP() {
        ap += 7;
        if (ap > 50) {
            ap = 50;
        }
    }

}
