package rs.oisumida.mac0321.ex06;

import java.util.ArrayList;
import java.util.Random;

public class Pokemon {
  private String name;
  public final int max_hp;
  private int exp, level, hp;
  private Gender gender;
  private ArrayList<StatusEffect> effects;
  private ArrayList<Move> moves;
  public final int attack, special_attack, defense, special_defense, speed;
  private Type types[];
  
  public Pokemon(String name, int max_hp, int exp, int level, int hp,
      Gender gender, ArrayList<StatusEffect> effects,
      int a, int sa, int d, int sd, int spd, Type types[], ArrayList<Move> moves) {
    this.name = name;
    this.max_hp = max_hp;
    this.hp = hp;
    this.exp = exp;
    this.level = level;
    this.gender = gender;
    this.effects = effects;
    this.attack = a;
    this.special_attack = sa;
    this.defense = d;
    this.special_defense = sd;
    this.speed = spd;
    this.types = types;
    this.moves = moves;
  }
  
  public String toString() {
	  return this.name + " L"+this.level+" HP "+this.hp+"/"+this.max_hp;
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

  public ArrayList<Move> getMoves() {
    return moves;
  }

  public boolean isFainted() {
    return hp <= 0;
  }

  public Type[] getTypes() {
    return types;
  }

  public boolean addMovePP(int move_number, int pp) {
    int prev_pp = moves.get(move_number).getPP();
    if (prev_pp == moves.get(move_number).base_pp) {
      Communicator.passMessage("O ataque " + moves.get(move_number).getName()
          + " já estava com PP cheio!");
      return false;
    }
    int novo = Math.min(moves.get(move_number).base_pp, prev_pp + pp);
    moves.get(move_number).setPP(novo);
    int delta = novo - prev_pp;
    Communicator.passMessage("O ataque " + moves.get(move_number).getName()
        + " recebeu " + delta + " PP, e está com " + novo + "/"
        + moves.get(move_number).base_pp + "PP!");
    return true;
  }

  public boolean heal(int healing) {
    if (hp == max_hp) {
      Communicator.passMessage("Esse Pokemon já estava com HP cheio!");
      return false;
    }
    int prev = hp;
    this.hp = Math.min(max_hp, hp + healing);
    int delta = hp - prev;
    Communicator.passMessage(name + " recuperou " + delta + " HP!");
    return true;
  }
  
  public boolean damage(int dmg) {
    if (isFainted()) return false;
    this.hp = Math.max(0,  hp - dmg);
    if (isFainted()) {
      Communicator.passMessage(name + " desmaiou!");
      return true;
    }
    return false;
  }
  
  // retorna o fator aleatório de um critical hit
  public double critical() {
    return (new Random().nextDouble() < speed/512) ? 1.5 : 1;
  }
  
  // retorna o fator de efetividade de tipos (STAB)
  public double stab(Move m) {
    for (Type t : types) {
      if (t.equals(m.getType())) return 1.5;
    }
    return 1;
  }
  
  // assume que pode ser usado
  public void attack(Pokemon target, Move m) {
    // avisar o uso
    Communicator.passMessage(name + " usou " + m.getName() + "!");
    // primeiro, ver se tem algum status effect que causa chance de erro
    for (StatusEffect se : effects) {
      if (se.hindrance == Hindrance.MISS
        || se.hindrance == Hindrance.MISS_AND_HURT_SELF && se.doChance()) {
        Communicator.passMessage("Mas errou devido à " + se.getName());
        if (se.hindrance == Hindrance.MISS_AND_HURT_SELF) {
          int dmg = se.calculateDamage(this);
          System.out.println("E ainda por cima tomou " + dmg + " de dano!");
          this.damage(dmg);
        }
        return;
      }
    }
    // executar o ataque
    Effectiveness ef = Effectiveness.fromTypes(m.getType(), target.getTypes());
    double typeFactor = ef.damageFactor();
    if (typeFactor == 0) {
      Communicator.passMessage("Mas " + m.getName() + " é imune!");
      return;
    }
    // calcular o dano
    double randomizer = 0.85 + new Random().nextDouble() * 0.15;
    double modifier = critical() * stab(m) * typeFactor * randomizer;
    double frac = m.special ? (special_attack/target.special_defense)
      : (attack/target.defense);
    int damage = (int) ((((2*level/5 + 2)*m.power*frac)/50 + 2) * modifier);
    target.damage(damage);
    if (ef != Effectiveness.NORMAL)
      Communicator.passMessage(ef.toString());
    // implicar status effects
    StatusEffect se = m.effect;
    if (!target.isFainted() && m.doEffectChance()
      && !target.getEffects().contains(se)) {
      target.getEffects().add(se);
      Communicator.passMessage(target.getName() + " agora está "
        + se.getAdjective() + "!");
    }
  }
}
