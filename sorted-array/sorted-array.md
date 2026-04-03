# remove-dulicates-from-sorted-array

## Solution

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
}
```

## Was bei mir schiefging ("Verschiebe-Ansatz")

- Ich wollte Duplikate aktiv „löschen“ oder den Rest des Arrays nach vorne schieben.
- Das führte zu:
    - Verschachtelten Schleifen (O(n^2)) → bei großen Inputs zu langsam
    - Zu vielen Index-Variablen ($z, c, i, j$) → Überblick verloren
    - Manueller Manipulation von Zählern (z. B. `i--`) → sehr fehleranfällig

## Die Idee ("Überschreibe-Ansatz")

Statt Elemente zu verschieben, nutzen wir zwei Zeiger (**Two-Pointer**) und laufen das Array genau einmal von links nach rechts ab (O(n)).

- **`i` (Anker):** zeigt auf das letzte „saubere“ (einzigartige) Element.
- **`j` (Scanner):** sucht das nächste Element, das sich von `nums[i]` unterscheidet.
- **Wenn `nums[j] != nums[i]`:**
    - `i` um 1 erhöhen
    - `nums[i] = nums[j]` (wir überschreiben vorne die nächste freie Position)

## Merksatz

Bei sortierten Arrays sind Duplikate Nachbarn. Such nicht nach dem, was weg soll, sondern scanne mit einem zweiten Zeiger nach dem, was als Nächstes kommen muss – und überschreibe einfach von vorne nach hinten.