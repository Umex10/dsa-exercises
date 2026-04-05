# Remove Element

Ansatz: Zwei Zeiger
Laufzeit: O(n)
Level: Easy
Memory: O(1)
URL: https://leetcode.com/problems/remove-element/description/

## Solution

```java
class Solution {
    public int removeElement(int[] nums, int val) {

        int i = 0;

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != val) {

                nums[i] = nums[j];

                i++;

            }
        }
        return i;
    }
}
```

## Beispiel

<aside>
💡

**Beispiel-Input:** `nums = [3, 2, 2, 3]`, `val = 3`

Wir nutzen zwei Zeiger: `i` (der "Schreiber") und `j` (der "Entdecker").

1. **Start:** `i = 0`, `j = 0`.
2. **Check (j=0, Wert 3):** Ist 3 ungleich `val` (3)? **Nein.**
    - `i` bleibt stehen. `j` rückt vor.
3. **Check (j=1, Wert 2):** Ist 2 ungleich `val` (3)? **Ja!**
    - **Aktion:** Schreibe die 2 auf die Position von `i`.
    - `nums` sieht jetzt so aus: `[2, 2, 2, 3]` (die erste Stelle wurde überschrieben).
    - `i` rückt vor auf Position 1.
4. **Check (j=2, Wert 2):** Ist 2 ungleich `val` (3)? **Ja!**
    - **Aktion:** Schreibe die 2 auf die Position von `i` (Index 1).
    - `i` rückt vor auf Position 2.
5. **Check (j=3, Wert 3):** Ist 3 ungleich `val` (3)? **Nein.**
    - `i` bleibt stehen. `j` ist am Ende.

**Ergebnis:** `i` ist 2. Die ersten zwei Elemente des Arrays sind `[2, 2]`.

</aside>

## Ansatz

Anstatt Elemente wirklich zu "löschen" (was bei Arrays bedeuten würde, alle nachfolgenden Zahlen mühsam zu verschieben), **überschreiben** wir einfach die unerwünschten Werte.

**Der code:**

- Der Zeiger `j` scannt das gesamte Array ab.
- Immer wenn `j` auf eine Zahl stößt, die **nicht** gelöscht werden soll, werfen wir diese Zahl nach vorne an die Stelle, an der unser Schreib-Zeiger `i` gerade wartet.
- Der Zeiger `i` zählt gleichzeitig mit, wie viele "gültige" Zahlen wir bisher gefunden haben.

**Merksatz:**
Lass einen Entdecker das Array nach guten Werten absuchen. Jedes Mal, wenn er einen findet, schickt er ihn nach vorne auf den nächsten freien "Parkplatz", den der Schreib-Pointer reserviert hat.

## Stats

![image.png](image.png)