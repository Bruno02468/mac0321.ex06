package rs.oisumida.mac0321.ex06;

import java.util.Random;

public class Move {
  private String name;
  private int pp;
  public final int base_pp, power, accuracy;
  public final StatusEffect effect;
  public final double effect_chance;
  private Type type;
  public final boolean special;
  public final double go_away_chance;
  
  public Move(String name, int pp, int base_pp, int power, int accuracy, 
    StatusEffect effect, double effect_chance, Type type, boolean special,
    double go_away_chance) {
    this.name = name;
    this.pp = pp;
    this.base_pp = pp;
    this.power = power;
    this.accuracy = accuracy;
    this.effect = effect;
    this.effect_chance = effect_chance;
    this.type = type;
    this.special = special;
    this.go_away_chance = go_away_chance;
  }

  public String getName() {
    return name;
  }

  public int getPP() {
    return pp;
  }

  public void setPP(int pp) {
    this.pp = pp;
  }

  public Type getType() {
    return type;
  }
  
  public boolean doEffectChance() {
    return (new Random().nextDouble() < effect_chance);
  }
  
  public boolean doCureChance() {
    return (new Random().nextDouble() < go_away_chance);
  }
}
