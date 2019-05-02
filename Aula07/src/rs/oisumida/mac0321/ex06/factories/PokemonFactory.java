package rs.oisumida.mac0321.ex06.factories;

import java.util.ArrayList;

import rs.oisumida.mac0321.ex06.Gender;
import rs.oisumida.mac0321.ex06.Move;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.StatusEffect;
import rs.oisumida.mac0321.ex06.Type;

public class PokemonFactory {
  public static Pokemon pikachu() {
    return null;
  }
  public static Pokemon bulbasaur() {
	  ArrayList<StatusEffect> effects = new ArrayList<StatusEffect>(); 
	  Type types[] = {Type.GRASS, Type.POISON};
	  Move tackle = new Move("Tackle", 35, 35, 35, 95, null, 0, null, false, 0);
	  ArrayList<Move> moves = new ArrayList<Move>();
	  moves.add(tackle);
	  return new Pokemon("Bulbasaur", 45, 0, 1, 45, Gender.NONBINARY, effects, 49, 65, 49, 65, 45, types, moves);
  }
}
