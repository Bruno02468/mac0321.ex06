package rs.oisumida.mac0321.ex06;

public class Move {
  private String name;
  private int pp;
  public final int base_pp, power, accuracy;
  public final StatusEffect effect;
  public final double effect_chance;
  
  public Move(String name, int pp, int base_pp, int power, int accuracy, 
      StatusEffect effect, double effect_chance) {
    this.name = name;
    this.pp = pp;
    this.base_pp = pp;
    this.power = power;
    this.accuracy = accuracy;
    this.effect = effect;
    this.effect_chance = effect_chance;
  }
}
