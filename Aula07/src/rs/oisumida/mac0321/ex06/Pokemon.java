package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;

public class Pokemon {
  private String name;
  public final int max_hp;
  private int exp, level, hp;
  private Gender gender;
  private ArrayList<StatusEffect> effects;
  private Move moves[];
  private boolean fainted;
  public final int attack, special_attack, defense, special_defense, speed;
  private Type types[];
  
  public Pokemon(String name, int max_hp, int exp, int level, int hp,
      Gender gender, ArrayList<StatusEffect> effects, Move moves[],
      boolean fainted, int a, int sa, int d, int sd, int spd, Type types[]) {
    this.name = name;
    this.max_hp = max_hp;
    this.hp = hp;
    this.exp = exp;
    this.level = level;
    this.gender = gender;
    this.effects = effects;
    this.moves = moves;
    this.fainted = fainted;
    this.attack = a;
    this.special_attack = sa;
    this.defense = d;
    this.special_defense = sd;
    this.speed = spd;
    this.types = types;
  }
  
  public String getName() {
    return name;
  }

  public int getExp() {
    return exp;
  }

  public int getLevel() {
    return level;
  }

  public int getHP() {
    return hp;
  }

  public Gender getGender() {
    return gender;
  }

  public ArrayList<StatusEffect> getEffects() {
    return effects;
  }

  public Move[] getMoves() {
    return moves;
  }

  public boolean isFainted() {
    return fainted;
  }

  public Type[] getTypes() {
    return types;
  }

  public void addMovePP(int move_number, int pp) {
    // TODO Auto-generated method stub
    
  }

  public void heal(int healing) {
    int prev = hp;
    this.hp = Math.min(max_hp, hp + healing);
    int delta = hp - prev;
    Communicator.passMessage(name + " foi curado em " + delta + " HP!");
  }
}
