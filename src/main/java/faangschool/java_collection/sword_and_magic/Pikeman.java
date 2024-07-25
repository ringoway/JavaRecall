package faangschool.java_collection.sword_and_magic;

public class Pikeman extends Creature {
    private int damage;
    private int defence;
    private int speed;
    private int count;

    public Pikeman(String name, int level, int damage, int defence, int speed, int count) {
        super(name, level, damage, defence, speed, count);
    }
}
