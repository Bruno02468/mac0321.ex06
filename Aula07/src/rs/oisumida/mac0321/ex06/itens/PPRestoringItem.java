package rs.oisumida.mac0321.ex06.itens;

import rs.oisumida.mac0321.ex06.Communicator;
import rs.oisumida.mac0321.ex06.Item;
import rs.oisumida.mac0321.ex06.Move;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.Trainer;

public class PPRestoringItem extends Item {
  
  private final int pp;
  private final boolean every;

  public PPRestoringItem(String name, int max_stack, int pp, boolean every) {
    super(name, max_stack, true);
    this.pp = pp;
    this.every = every;
  }

  public boolean applyAs(Trainer player, Pokemon target) {
    boolean result = false;
    if (every) {
      for (int move_number = 0; move_number < target.getMoves().size();
          move_number++) {
        result |= target.addMovePP(move_number, pp);
      }
    } else {
      Move m = (Move) Communicator.askWhichArrayList("Quer recarregar o PP de"
        + " qual ataque?", target.getMoves());
      int index = target.getMoves().indexOf(m);
      result |= target.addMovePP(index, pp);
    }
    return result;
  }

}
