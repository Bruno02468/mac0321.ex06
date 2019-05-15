package rs.oisumida.mac0321.ex06;

public abstract class Item {
  private String name;
  public final int max_stack;
  public boolean mine;
  
  public Item(String name, int max_stack, boolean mine) {
    this.name = name;
    this.max_stack = max_stack;
    this.mine = mine;
  }
  
  public String getName() {
    return name;
  }
  
  @Override
  public String toString() {
    return name;
  }
  
  public boolean equals(Item other) {
    return name.equals(other.getName());
  }
  
  public abstract boolean applyAs(Trainer player, Pokemon target);
}
