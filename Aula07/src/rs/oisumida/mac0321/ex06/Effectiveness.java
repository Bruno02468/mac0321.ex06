package rs.oisumida.mac0321.ex06;

public enum Effectiveness {
  IMMUNE, NOT_VERY, NORMAL, SUPER;

  private static int typeIndex(Type t) {
    final Type[] indexes = { Type.NORMAL, Type.FIGHTING, Type.FLYING,
        Type.POISON, Type.GROUND, Type.ROCK, Type.BUG, Type.GHOST, Type.STEEL,
        Type.FIRE, Type.WATER, Type.GRASS, Type.ELECTRIC, Type.PSYCHIC,
        Type.ICE, Type.DRAGON, Type.DARK, Type.FAIRY
    };
    return java.util.Arrays.asList(indexes).indexOf(t);
  }
  
  public static double damageFactor(Type attack, Type defend[]) {
    double[][] matrix = {
        {1,  1,  1,  1,  1, .5,  1,  0, .5,  1,  1,  1,  1,  1,  1,  1,  1,  1},
        {2,  1, .5, .5,  1,  2, .5,  0,  2,  1,  1,  1,  1, .5,  2,  1,  2, .5},
        {1,  2,  1,  1,  1, .5,  2,  1, .5,  1,  1,  2, .5,  1,  1,  1,  1,  1},
        {1,  1,  1, .5, .5, .5,  1, .5,  0,  1,  1,  2,  1,  1,  1,  1,  1,  2},
        {1,  1,  0,  2,  1,  2, .5,  1,  2,  2,  1, .5,  2,  1,  1,  1,  1,  1},
        {1, .5,  2,  1, .5,  1,  2,  1, .5,  2,  1,  1,  1,  1,  2,  1,  1,  1},
        {1, .5, .5, .5,  1,  1,  1, .5, .5, .5,  1,  2,  1,  2,  1,  1,  2, .5},
        {0,  1,  1,  1,  1,  1,  1,  2,  1,  1,  1,  1,  1,  2,  1,  1, .5,  1},
        {1,  1,  1,  1,  1,  2,  1,  1, .5, .5, .5,  1, .5,  1,  2,  1,  1,  2},
        {1,  1,  1,  1,  1, .5,  2,  1,  2, .5, .5,  2,  1,  1,  2, .5,  1,  1},
        {1,  1,  1,  1,  2,  2,  1,  1,  1,  2, .5, .5,  1,  1,  1, .5,  1,  1},
        {1,  1, .5, .5,  2,  2, .5,  1, .5, .5,  2, .5,  1,  1,  1, .5,  1,  1},
        {1,  1,  2,  1,  0,  1,  1,  1,  1,  1,  2, .5, .5,  1,  1, .5,  1,  1},
        {1,  2,  1,  2,  1,  1,  1,  1, .5,  1,  1,  1,  1, .5,  1,  1,  0,  1},
        {1,  1,  2,  1,  2,  1,  1,  1, .5, .5, .5,  2,  1,  1, .5,  2,  1,  1},
        {1,  1,  1,  1,  1,  1,  1,  1, .5,  1,  1,  1,  1,  1,  1,  2,  1,  0},
        {1, .5,  1,  1,  1,  1,  1,  2,  1,  1,  1,  1,  1,  2,  1,  1, .5, .5},
        {1,  2,  1, .5,  1,  1,  1,  1, .5, .5,  1,  1,  1,  1,  1,  2,  2,  1}
    };
    double[] line = matrix[typeIndex(attack)];
    double factor = 1;
    for (Type t : defend) {
      if (t == null) continue;
      factor *= line[typeIndex(t)];
    }
    return factor;
  }
  
  public double damageFactor() {
    switch (this) {
      case IMMUNE:
        return 0;
      case NORMAL:
        return 1;
      case NOT_VERY:
        return 0.5;
      case SUPER:
        return 2;
      default:
        return 1;
    }
  }
  
  public static Effectiveness fromTypes(Type attack, Type defend[]) {
    switch ((int)Math.round(2*damageFactor(attack, defend))) {
      case 0:
        return IMMUNE;
      case 1:
        return NOT_VERY;
      case 2:
        return NORMAL;
      case 4:
        return SUPER;
    }
    // perigo
    return NORMAL;
  }
  
  @Override
  public String toString() {
    switch (this) {
      case IMMUNE:
        return "Não surtiu efeito!";
      case NORMAL:
        return "";
      case NOT_VERY:
        return "Não foi muito efetivo...";
      case SUPER:
        return "Foi super-efetivo!";
      default:
        return "Esta mensagem não deve aparecer!";
    }
  }
}
