package rs.oisumida.mac0321.ex06.itens;

import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class HealingItem extends Item {
  
  private int healing;
  
  public HealingItem(String name, int healing) {
    super(name, 10, true);
  }
  
  public boolean applyAs(Trainer player, Pokemon target) {
    return target.heal(healing);
  }

}
