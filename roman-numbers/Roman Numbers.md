# Roman Numbers

Ansatz: Regeln einhalten
Laufzeit: O(n)
Level: Easy
Memory: O(1)
URL: https://leetcode.com/problems/roman-to-integer/

## Solution

```java
class Solution {
    public int romanToInt(String s) {

    int total = 0;

    for (int i = 0; i < s.length(); i++) {

      int current = scanRoman(s.charAt(i));

      if (i + 1 < s.length()) {
        int next = scanRoman(s.charAt(i + 1));

        if (current < next) {
          // IV --> 1 < 5 --> total = total - 1
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

    public int scanRoman(char c) {
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
        }

        return 0;
    }
}
```

## Beispiel

<aside>
💡

**Beispiel-Input:** `s = "MCMXCIV"` (Ergebnis: 1994)

Wir gehen den String von **links nach rechts** durch:

- **M (1000)**: Nächster ist C (100). Da 1000 > 100 ➜ **+1000**
- **C (100)**: Nächster ist M (1000). Da 10 < 1000 ➜ **100** (Sonderfall: Subtraktion)
- **M (1000)**: Nächster ist X (10). Da 1000 > 10 ➜ **+1000**
- **X (10)**: Nächster ist C (100). Da 10 < 100 ➜ **10** (Sonderfall: Subtraktion)
- **C (100)**: Nächster ist I (1). Da 100 > 1 ➜ **+100**
- **I (1)**: Nächster ist V (5). Da 1 < 5 ➜ **1** (Sonderfall: Subtraktion)
- **V (5)**: Letztes Element im String ➜ **+5** (Immer Addition beim letzten Zeichen)

**Die finale Rechnung:**
1000 - 100 + 1000 - 10 + 100 - 1 + 5 = **1994**

</aside>

## Ansatz

Roman Zahlen werden normalerweise von big nach klein geschrieben und addiert. Der einzige "Trick" sind die 6 Fälle, in denen eine kleinere Zahl **vor** einer biggeren steht (wie IV oder CM).

**Die Logik:**

- Schau dir die aktuelle Zahl (`current`) und die nächste Zahl (`next`) an.
- Ist `current < next`? Dann ziehe `current` vom Gesamtwert ab.
- Ansonsten: Addiere `current` zum Gesamtwert.

> **Merksatz:** Roman Zahlen liest man wie eine bedingte Additionsliste: "Wenn ich kleiner bin als mein Nachfolger, bin ich ein Abzug – sonst bin ich ein Bonus."
> 

## Stats

![image.png](Roman%20Numbers/image.png)