package rs.oisumida.mac0321.ex06.factories;

import rs.oisumida.mac0321.ex06.itens.HealingItem;
import rs.oisumida.mac0321.ex06.itens.PPRestoringItem;

public class ItemFactory {
  public static HealingItem healingAleatorio() {
    String[] nomes = {
      "Strogonoff da Química",
      "Casquinha da Minerva",
      "Red Bull vencida",
      "Salgado barato"
    };
    
    return new HealingItem(FactoryUtils.tirarUm(nomes), 6,
      FactoryUtils.randomInt(30, 150));
  }
  
  public static PPRestoringItem ppAleatorio() {
    String[] nomes = {
      "Videoaula do Possani",
      "Resumo da Xerox",
      "Prova antiga",
      "Lista de exercícios"
    };
    String nome = FactoryUtils.tirarUm(nomes);
    
    return new PPRestoringItem(nome, 6,
      FactoryUtils.randomInt(5, 10), nome == "Videoaula do Possani");
  }
}
