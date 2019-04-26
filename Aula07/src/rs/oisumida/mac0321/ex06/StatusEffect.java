package rs.oisumida.mac0321.ex06;

public class StatusEffect {
  private String name, message;
  public final boolean volatility;
  public final Hindrance hindrance;
  public final double value, chance;
  
  public StatusEffect(String name, String message, boolean volatility,
      Hindrance hindrance, double value, double chance) {
    this.name = name;
    this.volatility = volatility;
    this.message = message;
    this.hindrance = hindrance;
    this.value = value;
    this.chance = chance;
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
}
