package week35;

import java.util.Objects;

public class Pokemon {
    private String name;
    private PokemonKind kind;
    private int attack;
    private int defense;
    private double effectiveness;

    private int life;

    public Pokemon(String name, PokemonKind kind, int attack, int defense, double effectiveness) {
        this.name = name;
        this.kind = kind;
        this.attack = attack;
        this.defense = defense;
        this.effectiveness = effectiveness;
        this.life = 1000;
    }

    public String getName() {
        return name;
    }

    public PokemonKind getKind() {
        return kind;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public double getEffectiveness() {
        return effectiveness;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int hit() {
        return (int) (50 * (getAttack() / getDefense()) * getEffectiveness());
    }

    public void receiveDamage(int damage) {
        this.setLife(this.getLife() - damage);
    }

    @Override
    public String toString() {
        return name +
                ", kind=" + kind +
                ", attack=" + attack +
                ", defense=" + defense +
                ", effectiveness=" + effectiveness +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return attack == pokemon.attack && defense == pokemon.defense && Double.compare(effectiveness, pokemon.effectiveness) == 0 && Objects.equals(name, pokemon.name) && kind == pokemon.kind;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kind, attack, defense, effectiveness);
    }
}
