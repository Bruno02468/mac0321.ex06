package rs.oisumida.mac0321.ex06;

import java.util.Random;

public class StatusEffect {
  private String name, message;
  public final boolean volatility;
  public final Hindrance hindrance;
  public final double value, chance;
  private final String adjective;
  
  public StatusEffect(String name, String message, boolean volatility,
      Hindrance hindrance, double value, double chance, String adjective) {
    this.name = name;
    this.volatility = volatility;
    this.message = message;
    this.hindrance = hindrance;
    this.value = value;
    this.chance = chance;
    this.adjective = adjective;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public String toString() {
    return name;
  }
  
  public String getMessage() {
    return message;
  }
  
  public String getAdjective() {
    return adjective;
  }
  
  public boolean doChance() {
    return (new Random().nextDouble() <= this.chance);
  }
  
  public int calculateDamage(Pokemon target) {
    return 50; // FIXME
  }
}
