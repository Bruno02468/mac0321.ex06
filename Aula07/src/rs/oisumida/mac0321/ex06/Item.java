package rs.oisumida.mac0321.ex06;

public abstract class Item {
  private String name;
  public final int max_stack;
  
  public Item(String name, int max_stack) {
    this.name = name;
    this.max_stack = max_stack;
  }
  
  public String getName() {
    return name;
  }
  
  public abstract void applyTo(Pokemon target);
}
