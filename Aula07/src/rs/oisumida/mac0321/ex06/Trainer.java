package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;

public class Trainer {
	private String name;
	private Gender gender;
	private int money;
	ArrayList<Pokemon> roster;
	ArrayList<ItemStack> bag;
	
	public Trainer(String name, Gender gender) {
	  this(name, gender, 1000);
	}
	
	public Trainer(String name, Gender gender, int money) {
		this.name = name;
		this.gender = gender;
		this.setMoney(money);
	}
	
	public String toString() {
		return this.gender.getColor() + this.name + Communicator.ANSI_RESET;
	}

  public int getMoney() {
    return money;
  }
  
  public ArrayList<Pokemon> getRoster() {
    return roster;
  }
  
  public ArrayList<ItemStack> getBag() {
    return bag;
  }
  
  public void setMoney(int money) {
    this.money = money;
  }
	
	public void giveItem(Item item, int amount) {
	  for (ItemStack is : bag) {
	    if (is.isOf(item)) {
	      is.giveMore(amount);
	      return;
	    }
	  }
	  if (bag.size() == GameConstants.MAX_ITEMS) return;
	  bag.add(new ItemStack(item, amount));
	}
	
	public void givePokemon(Pokemon p) {
	  if (roster.size() == GameConstants.MAX_ROSTER) return;
	  roster.add(p);
	}
}
