package rs.oisumida.mac0321.ex06.factories;

import java.util.Random;

import rs.oisumida.mac0321.ex06.Hindrance;
import rs.oisumida.mac0321.ex06.StatusEffect;

public class StatusEffectFactory {

  public static StatusEffect aleatorio() {
    String situacoes[] = {
      "DP",
      "Rec",
      "Reprovação",
      "RF",
      "Requerimento Indeferido",
      "Sem calça no lab"
    };
    
    String materias[] = {
      "Cálculo",
      "Algelin",
      "Física",
      "MAC2166",
      "PCC3100"
    };
    
    Random r = new Random();
    
    String nome = FactoryUtils.tirarUm(situacoes, r) + " de "
      + FactoryUtils.tirarUm(materias, r);
    
    boolean vol = r.nextDouble() < 0.7;
    Hindrance hin = FactoryUtils.randomEnum(Hindrance.class);
    double val = FactoryUtils.randomInt(50, 150, r);
    double chance = FactoryUtils.randomInt(50, 100, r)/100.0d;
    String adj = "com " + nome;
    double cure = FactoryUtils.randomInt(30, 70, r);
    
    return new StatusEffect(nome, vol, hin, val, chance, adj, cure);
  }

}
