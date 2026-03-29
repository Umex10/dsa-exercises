import java.util.HashMap;

class RomanNumbers {

  public static void main(String[] args) {
    Integer result = romanToInt("III");

    System.out.println(result);
  }

  public static int romanToInt(String s) {

    HashMap<String, Integer> results = new HashMap<>();
    results.put("I", 1);
    results.put("IV", 4);
    results.put("V", 5);
    results.put("IX", 9);
    results.put("X", 10);
    results.put("XL", 40);
    results.put("L", 50);
    results.put("XC", 90);
    results.put("C", 100);
    results.put("CD", 400);
    results.put("D", 500);
    results.put("CM", 900);
    results.put("M", 1000);

   String key = ""; 
        Integer result = 0;

        for (int i = 0; i < s.length(); i++) {
            
            char c = s.charAt(i);
            Integer res = results.get(key + c); 
           
            if (res == null) {
                result += results.get(key);
                key = "";
            }

            key += c;

            if (i == s.length() - 1) {
                result += results.get(key);
            }
        }

    return result;
  }
}