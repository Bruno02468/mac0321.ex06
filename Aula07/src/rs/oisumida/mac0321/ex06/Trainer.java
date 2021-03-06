package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;
import java.util.Iterator;

public class Trainer {
	private String name;
	private Gender gender;
	private int money, current_pokemon;
	private ArrayList<Pokemon> roster;
	private ArrayList<ItemStack> bag;
	private boolean setCanFlee;
	private boolean auto_play=false;
	
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
	
	public boolean givePokemon(Pokemon p) {
	  if (roster.size() == GameConstants.MAX_ROSTER) return false;
	  p.setTrainer(this);
	  roster.add(p);
	  return true;
	}

	public Gender getGender() {
		return this.gender;
	}
	
	public boolean areAllFainted() {
		Iterator<Pokemon> it = this.roster.iterator();
		while (it.hasNext()) {
			if (!it.next().isFainted()) {
				return false;
			}
		}
		return true;
	}

	public void printStats() {
		System.out.println(this.toString() + ", seus pokemons:");
		Iterator<Pokemon> it = this.roster.iterator();
		while (it.hasNext()) {
			System.out.print("\t");
			it.next().printStats();
		}
	}

	public void setCanFlee(boolean can_flee) {
		this.setCanFlee = can_flee;
	}
	public boolean canFlee() {
		return this.setCanFlee;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public void setAutoPlay(boolean auto_play) {
		 this.auto_play = auto_play;
	}
	
	public boolean getAutoPlay() {
		 return this.auto_play;
	}

	public void removePokemon(Pokemon target) {
		if (this.roster.remove(target)) {
			Communicator.passMessage(
					this.gender.getColor() + this.name + Communicator.ANSI_RESET +
					", você perdeu o pokemon " + target.getName());	
		}
	}

	public String getName() {
		return this.name;
	}
}
