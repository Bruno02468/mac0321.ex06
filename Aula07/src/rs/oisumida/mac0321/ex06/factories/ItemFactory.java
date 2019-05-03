package rs.oisumida.mac0321.ex06.factories;

import rs.oisumida.mac0321.ex06.itens.HealingItem;
import rs.oisumida.mac0321.ex06.itens.PPRestoringItem;
import rs.oisumida.mac0321.ex06.itens.Pokeball;

public class ItemFactory {
  public static HealingItem healingAleatorio() {
    switch (FactoryUtils.randomInt(1, 5)) {
      case 1:
        return new HealingItem("Strogonoff da Química", 300);
      case 2:
        return new HealingItem("Casquinha da Minerva", 100);
      case 3:
        return new HealingItem("Red Bull vencida", 20);
      }
      return new HealingItem("Salgado barato", 50);
  }
  
  public static PPRestoringItem ppAleatorio() {
    switch (FactoryUtils.randomInt(1, 5)) {
    case 1:
      return new PPRestoringItem("Videoaula do Possani", 50, true);
    case 2:
      return new PPRestoringItem("Resumo da Xerox", 10, false);
    case 3:
      return new PPRestoringItem("Prova antiga", 15, false);
    }
    return new PPRestoringItem("Lista de exercícios", 5, false);
  }
  
  public static Pokeball pokebolaAleatoria() {
    switch (FactoryUtils.randomInt(1, 4)) {
      case 1:
        return new Pokeball("Pokebola de Bixo", 0.3);
      case 2:
        return new Pokeball("Pokebola de Veterano", 0.6);
      case 3:
        return new Pokeball("Pokebola de Formado", 0.9);
    }
    return new Pokeball("Pokebola do Possani", 1.0);
  }
}
