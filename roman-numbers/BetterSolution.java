class BetterSolution {

  public static void main(String[] args) {
    int result = romanToInt("III");

    System.out.println(result);
  }

  public static int romanToInt(String s) {

    int total = 0;

    for (int i = 0; i < s.length(); i++) {

      int current = getValue(s.charAt(i));

      if (i + 1 < s.length()) {
        int next = getValue(s.charAt(i + 1));

        if (current < next) {
          // IV --> 1 < 5 --> 5 - 1 = 4
          total -= current;
        } else {
          // MC --> 1100
          total += current;
        }
      } else {
        // Always add the last element, since there is no next
        total += current;
      }
    }

    return total;
  }

  private static int getValue(char c) {
    switch (c) {
      case 'I':
        return 1;
      case 'V':
        return 5;
      case 'X':
        return 10;
      case 'L':
        return 50;
      case 'C':
        return 100;
      case 'D':
        return 500;
      case 'M':
        return 1000;
      default:
        return 0;
    }
  }

}