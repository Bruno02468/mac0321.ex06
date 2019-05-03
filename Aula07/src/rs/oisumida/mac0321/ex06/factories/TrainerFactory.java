package rs.oisumida.mac0321.ex06.factories;

import java.util.Random;

import rs.oisumida.mac0321.ex06.Gender;
import rs.oisumida.mac0321.ex06.Trainer;

public class TrainerFactory {
  public static Trainer randomTrainer(boolean vs) {
    Random r = new Random();
    String primeiros[] = {
      "Fulanx",
      "Sicranx",
      "Beltranx"
    };
    String adjetivos[] = {
      "inimagniável",
      "terrível",
      "imprevisível",
      "espetacular",
      "incrível",
      "inesquecível",
      "formidável"
    };
    String profissoes[] = {
      "assinador§ de listas",
      "miador§ de aulas",
      "autor§ de resumos",
      "vendedor§ de EPs",
      "monitor§ de PCC3100"
    };
    
    Gender g = r.nextBoolean() ? Gender.FEMALE : Gender.MALE;
    
    char desinencia1 = g == Gender.FEMALE ? 'a' : 'o';
    String desinencia2 = g == Gender.FEMALE ? "a" : "";
    String primeiro = FactoryUtils.tirarUm(primeiros, r);
    String adjetivo = FactoryUtils.tirarUm(adjetivos, r);
    String profissao = FactoryUtils.tirarUm(profissoes, r);
    primeiro = primeiro.replace('x', desinencia1);
    profissao = profissao.replaceAll("§", desinencia2);
    String nome = primeiro + ", " + desinencia1 + " " + adjetivo + " "
      + profissao;
    
    Trainer t = new Trainer(nome, g, FactoryUtils.randomInt(500, 10000));
    
    // dar uns itens de cura
    for (int i = 0; i < FactoryUtils.randomInt(2, 4); i++) {
      t.giveItem(ItemFactory.healingAleatorio(), FactoryUtils.randomInt(2, 4));
    }
    
    // dar uns itens de PP
    for (int i = 0; i < FactoryUtils.randomInt(2, 4); i++) {
      t.giveItem(ItemFactory.ppAleatorio(), FactoryUtils.randomInt(2, 4));
    }
    
    if (!vs) {
      // e umas pokebolas, se não for VS
      for (int i = 0; i < FactoryUtils.randomInt(2, 4); i++) {
        t.giveItem(ItemFactory.pokebolaAleatoria(),
          FactoryUtils.randomInt(3, 5));
      }
    }
    
    // dar uns pokemons
    for (int i = 0; i < FactoryUtils.randomInt(4, 6); i++) {
      t.givePokemon(PokemonFactory.aleatorio());
    }
    
    return t;
    
  }
}
