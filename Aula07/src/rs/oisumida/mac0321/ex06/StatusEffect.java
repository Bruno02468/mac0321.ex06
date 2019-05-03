package rs.oisumida.mac0321.ex06;

import java.util.Random;

public class StatusEffect {
  private String name;
  public final boolean volatility;
  public final Hindrance hindrance;
  public final double value, chance;
  private final String adjective;
  private final double cure_chance;
  
  public StatusEffect(String name, boolean volatility,
      Hindrance hindrance, double value, double chance, String adjective,
      double cure_chance) {
    this.name = name;
    this.volatility = volatility;
    this.hindrance = hindrance;
    this.value = value;
    this.chance = chance;
    this.adjective = adjective;
    this.cure_chance = cure_chance;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public String toString() {
    return name;
  }
  
  public String getAdjective() {
    return adjective;
  }
  
  public boolean doChance() {
    return (new Random().nextDouble() <= this.chance);
  }

  public boolean doCureChance() {
    return (new Random().nextDouble() < cure_chance);
  }
  
  public int calculateDamage(Pokemon target) {
    return 50; // FIXME
  }
}
