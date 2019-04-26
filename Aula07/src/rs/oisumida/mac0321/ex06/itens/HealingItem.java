package rs.oisumida.mac0321.ex06.itens;

import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Pokemon;

public class HealingItem extends Item {
  
  private int healing;
  
  public HealingItem(String name, int max_stack, int healing) {
    super(name, max_stack);
  }

  @Override
  public boolean applyTo(Pokemon target) {
    return target.heal(healing);
  }

}
