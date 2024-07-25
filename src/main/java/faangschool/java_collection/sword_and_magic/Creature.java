package faangschool.java_collection.sword_and_magic;

public abstract class Creature {
    private String name;
    private int level;
    private int damage;
    private int defence;
    private int speed;
    private int count;

    public Creature(String name, int level, int damage, int defence, int speed, int count) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defence = defence;
        this.speed = speed;
        this.count = count;
    }
}
