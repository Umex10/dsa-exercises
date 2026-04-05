# Anagram

Ansatz: Einfache iteration
Laufzeit: O(n)
Level: Easy
Memory: O(1)
URL: https://leetcode.com/problems/valid-anagram/description/

## Solution

```java
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            letters[c - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);

            letters[c - 'a']--;

            if (letters[c - 'a'] < 0) {
                return false;
            }
        }

        return true;
    }
}
```

## Beispiel

<aside>
💡

**Beispiel-Input:** s = "anagram", t = "nagaram"

1. **Vorbereitung:** Wir prüfen die Länge. Beide sind 7 Zeichen lang. OK.
2. **Phase 1 (Zählen):** Wir gehen durch "anagram".
    - Unser Array speichert danach: a:3, n:1, g:1, r:1, m:1.
3. **Phase 2 (Abziehen):** Wir gehen durch "nagaram".
    - 'n' -> Zähler für n wird 0.
    - 'a' -> Zähler für a wird 2.
    - 'g' -> Zähler für g wird 0.
    - ... und so weiter.
4. **Ergebnis:** Da am Ende alle Buchstaben genau auf 0 landen (und nie unter 0 gefallen sind), ist es ein perfektes Anagramm.
</aside>

## Ansatz

Ein Anagramm ist im Grunde das gleiche wie die "Ransom Note" Aufgabe, nur mit einer strengeren Regel: Man darf keine Buchstaben übrig haben.

**Die Logik:**

1. **Längen-Check:** Wenn die Strings unterschiedlich lang sind, brich sofort ab.
2. **Frequenz-Tabelle:** Nutze ein Array der Größe 26 als Zählstation.
3. **Plus und Minus:** Du kannst entweder im ersten String alles hochzählen und im zweiten alles abziehen (wie in deinem Code), oder in einer einzigen Schleife durch beide gleichzeitig laufen (wenn sie gleich lang sind).

**Merksatz:**
Zwei Wörter sind Anagramme, wenn sie im "Buchstaben-Inventar" exakt die gleichen Bestände aufweisen.

## Stats

![image.png](image.png)