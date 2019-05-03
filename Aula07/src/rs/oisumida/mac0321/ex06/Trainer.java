package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;

public class Trainer {
	private String name;
	private Gender gender;
	private int money, current_pokemon;
	private ArrayList<Pokemon> roster;
	private ArrayList<ItemStack> bag;
	
	public Trainer(String name, Gender gender) {
	  this(name, gender, 1000);
	}
	
	public Trainer(String name, Gender gender, int money) {
		this.name = name;
		this.gender = gender;
		this.setMoney(money);
		this.current_pokemon = 0;
		this.roster = new ArrayList<Pokemon>();
		this.bag = new ArrayList<ItemStack>();
	}
	
	public String toString() {
		return this.gender.getColor() + this.name + Communicator.ANSI_RESET;
	}
	
	public Pokemon getCurrentPokemon() {
		return this.roster.get(this.current_pokemon);
	}
	
	public void switchPokemon(int new_pokemon) throws Exception {
		if (new_pokemon < 0 || new_pokemon >= this.roster.size()) {
			throw new Exception("número de pokemon inválido");
		}
		this.current_pokemon = new_pokemon;
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

	public Gender getGender() {
		return this.gender;
	}
}
