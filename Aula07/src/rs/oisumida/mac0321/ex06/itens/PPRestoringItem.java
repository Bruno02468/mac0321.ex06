package rs.oisumida.mac0321.ex06.itens;

import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Move;
import rs.oisumida.mac0321.ex06.Pokemon;

public class PPRestoringItem extends Item {
  
  private final int pp;
  private final boolean every;

  public PPRestoringItem(String name, int max_stack, int pp, boolean every) {
    super(name, max_stack);
    this.pp = pp;
    this.every = every;
  }

  @Override
  public void applyTo(Pokemon target) {
    if (every) {
      int move_number = 0;
      for (Move m : target.getMoves()) {
        target.addMovePP(move_number, pp);
      }
    } else {
      Move m = Communicator.askWhich(target.getMoves());
    }
  }

}
