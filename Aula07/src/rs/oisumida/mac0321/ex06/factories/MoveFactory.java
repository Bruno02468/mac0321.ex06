package rs.oisumida.mac0321.ex06.factories;

import java.util.Random;

import rs.oisumida.mac0321.ex06.Move;
import rs.oisumida.mac0321.ex06.StatusEffect;
import rs.oisumida.mac0321.ex06.Type;

public class MoveFactory {
  public static Move tackle() {
    return new Move(
      "Tackle",
      35,
      40,
      1,
      null,
      0,
      Type.NORMAL,
      false
     );
  }
  
  public static Move aleatorio() {
    Random r = new Random();
    
    String acoes[] = {
      "Testinho",
      "Prova surpresa",
      "Transferência",
      "Imposto",
      "Reforma",
      "Privatização",
      "Auditoria",
      "Investigação",
      "CPI",
      "Medida Provisória",
      "Propina",
      "Inquérito",
      "Sindicância",
      "Jubilamento",
      "Trancaço",
      "Mensalidade",
      "Reprovação",
      "DP",
      "Superfaturamento",
      "Ofício"
    };
    
    String femininos[] = {
      "USP",
      "Receita Federal",
      "Alesp",
      "Poli",
      "FAU",
      "FFLCH",
      "FEA",
      "Diretoria",
      "Reitoria",
      "Raia",
      "Cidade Universitária",
      "Optativa Coxa",
      "Optativa Osso",
      "Lista de Presença",
      "Catraca",
    };
    
    String masculinos[] = {
      "Circular 1",
      "Circular 2",
      "Circular 3",
      "Politreco",
      "IF",
      "IME",
      "Grêmio",
      "Centro Acadêmico",
      "5bola",
      "PoliSemFio",
      "eduroam",
      "Biênio",
      "Vidro da Raia",
      "Duplo Diploma",
      "JupiterWeb",
      "Bandejão"
    };
    
    String nome = FactoryUtils.tirarUm(acoes, r) + " ";
    if (new Random().nextBoolean()) {
      // masculino
      nome += "do " + FactoryUtils.tirarUm(masculinos, r);
    } else {
      nome += "da " + FactoryUtils.tirarUm(femininos, r);
    }
    
    int power = FactoryUtils.randomInt(30, 100, r);
    int accuracy = FactoryUtils.randomInt(70, 100, r);
    int pp = FactoryUtils.randomInt(30, 45, r);
    boolean special = r.nextBoolean();
    StatusEffect se = null;
    double sec = 0;
    if (r.nextDouble() < 0.4) {
      se = StatusEffectFactory.aleatorio();
      sec = FactoryUtils.randomInt(70, 100, r)/100.0d;
    }
    Type t = FactoryUtils.randomEnum(Type.class);
    
    return new Move(nome, pp, power, accuracy, se, sec, t, special);
    
  }
}
