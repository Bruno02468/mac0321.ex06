package rs.oisumida.mac0321.ex06.factories;

import java.util.Random;

public class FactoryUtils {
  public static String tirarUm(String[] arr, Random r) {
    return arr[r.nextInt(arr.length)];
  }
  
  public static String tirarUm(String[] arr) {
    return tirarUm(arr, new Random());
  }
  
  public static <T extends Enum<?>> T randomEnum(Class<T> classe){
    int i = new Random().nextInt(classe.getEnumConstants().length);
    return classe.getEnumConstants()[i];
  }
  
  public static int randomInt(int min, int max) {
    return randomInt(min, max, new Random());
  }
  
  public static int randomInt(int min, int max, Random r) {
    return r.nextInt((max - min) + 1) + min;
  }
}
