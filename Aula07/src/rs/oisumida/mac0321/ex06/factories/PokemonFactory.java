package rs.oisumida.mac0321.ex06.factories; 

import java.util.ArrayList;
import java.util.Random;

import rs.oisumida.mac0321.ex06.Gender;
import rs.oisumida.mac0321.ex06.Move;
import rs.oisumida.mac0321.ex06.Pokemon;
import rs.oisumida.mac0321.ex06.StatusEffect;
import rs.oisumida.mac0321.ex06.Type;

public class PokemonFactory {
  public static Pokemon aleatorio() {
    String individuos[] = {
      "Aluno",
      "Politreco",
      "Ciclista de speed",
      "Professor",
      "Otaco",
      "Monitor",
      "Intercambista",
    };
    
    String adjetivos[] = {
      "que quer trabalhar em banco",
      "que usa celular na aula",
      "que joga LoL na aula",
      "que dorme na aula",
      "que não vai na aula",
      "que vende EP",
      "que compra EP",
      "que não fala português",
      "que baixa torrent no eduroam",
      "que não assina a lista",
      "que come no Sweden"
    };
    
    Random r = new Random();
    
    String nome = FactoryUtils.tirarUm(individuos, r) + " "
      + FactoryUtils.tirarUm(adjetivos, r);
    int hp = FactoryUtils.randomInt(150, 300, r);
    int lvl = FactoryUtils.randomInt(4, 100, r);
    Gender g = FactoryUtils.randomEnum(Gender.class); 
    ArrayList<StatusEffect> ses = new ArrayList<StatusEffect>();
    ArrayList<Move> ms = new ArrayList<Move>();
    for (int i = 0; i < 4; i++) {
      ms.add(MoveFactory.aleatorio());
    }
    int a = FactoryUtils.randomInt(50, 100, r);
    int sa = FactoryUtils.randomInt(50, 100, r);
    int d = FactoryUtils.randomInt(50, 100, r);
    int sd = FactoryUtils.randomInt(50, 100, r);
    int spd =  FactoryUtils.randomInt(70, 255, r);
    Type t[] = null;
    if (r.nextBoolean()) {
      // um tipo
      t = new Type[1];
    } else {
      t = new Type[2];
      t[1] = FactoryUtils.randomEnum(Type.class);
    }
    t[0] = FactoryUtils.randomEnum(Type.class);
    
    return new Pokemon(nome, hp, lvl, g, ses, a, sa, d, sd, spd, t, ms);
  }
}
