package rs.oisumida.mac0321.ex06.factories;

import java.util.ArrayList;

import rs.oisumida.mac0321.ex06.Gender;
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
	  return new Pokemon("Bulbasaur", 45, 0, 1, 45, Gender.NONBINARY, effects, 49, 65, 49, 65, 45, types);
  }
}
