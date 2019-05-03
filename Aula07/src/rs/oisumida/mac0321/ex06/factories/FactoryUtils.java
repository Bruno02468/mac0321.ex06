package rs.oisumida.mac0321.ex06.factories;

import java.util.Random;

public class FactoryUtils {
  public static String tirarUm(String[] arr, Random r) {
    return arr[r.nextInt(arr.length)];
  }
  
  public static <T extends Enum<?>> T randomEnum(Class<T> classe){
    int i = new Random().nextInt(classe.getEnumConstants().length);
    return classe.getEnumConstants()[i];
  }
  
  public static int randomInt(int min, int max, Random r) {
    return (int) (min + r.nextDouble() * (max-min));
  }
}
