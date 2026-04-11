# First Unique Character in a String

Ansatz: Hash
Laufzeit: O(n)
Level: Easy
Memory: O(1)
URL: https://www.notion.so/LeetCode-3354e760adb38023888ade9f59ed998e?p=33f4e760adb380c79fc3e4f321d84a64&pm=s

## Solution

```java
class Solution {
    public int firstUniqChar(String s) {
        
        int[] letters = new int[26];
        int index = -1;

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            letters[c - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            
            if (letters[c - 'a'] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }
}
```

## Beispiel

<aside>
💡

| **Index i** | **Zeichen s.charAt(i)** | **Aktion im Array** | **Stand nach dem Durchlauf (Auszug)** |
| --- | --- | --- | --- |
| 0 | 'l' | `count['l' - 'a']++` | `count[11] = 1` |
| 1 | 'e' | `count['e' - 'a']++` | `count[4] = 1` |
| 2 | 'e' | `count['e' - 'a']++` | `count[4] = 2` |
| 3 | 't' | `count['t' - 'a']++` | `count[19] = 1` |
| 4 | 'c' | `count['c' - 'a']++` | `count[2] = 1` |
| 5 | 'o' | `count['o' - 'a']++` | `count[14] = 1` |
| 6 | 'd' | `count['d' - 'a']++` | `count[3] = 1` |
| 7 | 'e' | `count['e' - 'a']++` | `count[4] = 3` |
</aside>

## Ansatz

In Aufgaben mit Strings, die nur aus **kleingeschriebenen englischen Buchstaben** (`a-z`) bestehen, ist ein **Array der Größe 26** die effizienteste "HashMap" der Welt.

- **Vorteil:** Keine Objekte (`Character`, `Integer`), kein Hashing-Overhead, direkter Speicherzugriff.
- **Mechanik:** Wir nutzen den ASCII-Wert: `index = s.charAt(i) - 'a'`.
    - 'a' - 'a' = 0
    - 'b' - 'a' = 1
    - ...
    - 'z' - 'a' = 25

## Stats

![image.png](First%20Unique%20Character%20in%20a%20String/image.png)