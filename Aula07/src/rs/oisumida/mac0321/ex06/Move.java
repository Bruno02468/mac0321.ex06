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
  
  public Move(String name, int base_pp, int power, int accuracy, 
    StatusEffect effect, double effect_chance, Type type, boolean special) {
    this.name = name;
    this.base_pp = base_pp;
    this.pp = base_pp;
    this.power = power;
    this.accuracy = accuracy;
    this.effect = effect;
    this.effect_chance = effect_chance;
    this.type = type;
    this.special = special;
  }

  public String toString() {
	    return name;
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
  
  public boolean doMissChance() {
    return (new Random().nextDouble() < accuracy/100.0);
  }
  
}
