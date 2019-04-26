package rs.oisumida.mac0321.ex06;

public class ItemStack {
  private final Item item;
  private int amount;
  
  public int getAmount() {
	  return this.amount;
  }
  
  public ItemStack(Item item, int amount) {
    this.item = item;
    this.amount = amount;
  }
  
  public void applyTo(Pokemon target) {
    if (amount <= 0) return;
    boolean shouldConsume = item.applyTo(target);
    if (shouldConsume) {
      amount--;
    } else {
      Communicator.passMessage(item + " não foi consumido(a).");
    }
  }
  
  public void giveMore(int howMany) {
    if (howMany <= 0) return;
    amount += howMany;
  }
  
  public boolean isOf(Item i) {
    return this.item.equals(i);
  }
}
