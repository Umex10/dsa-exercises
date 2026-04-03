# Merge Two Sorted Lists

Ansatz: Singly Linked List
Laufzeit: O(n)
Level: Easy
Memory: O(1)
URL: https://leetcode.com/problems/merge-two-sorted-lists/description/

## Solution

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode c = dummy;

        while(list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                c.next = list1;
                list1 = list1.next;
            } else {
                c.next = list2;
                list2 = list2.next;
            }
            c = c.next;

        }

        // write the remaining list to c
        if (list1 == null) {
            c.next = list2;
        } else {
            c.next = list1;
        }

        // since "0" was only a start for us, we will give .next back
        return dummy.next;
        
    }
}
```

## Beispiel

<aside>
💡

**Beispiel-Input:** L1 = [1, 2, 4], L2 = [1, 3, 4]

1. **Vorbereitung:** Wir erstellen einen Dummy-Knoten (Wert 0). Unser Zeiger "c" (Cursor) steht am Anfang auf diesem Dummy.
2. **Schritt 1:** L1 (1) vs L2 (1). Beide sind gleich groß, wir nehmen L1.
    - c.next zeigt auf L1. L1 rückt einen Schritt weiter. c rückt ebenfalls vor.
3. **Schritt 2:** L1 (2) vs L2 (1). L2 ist kleiner.
    - c.next zeigt auf L2. L2 rückt einen Schritt weiter. c rückt vor.
4. **Schritt 3:** L1 (2) vs L2 (3). L1 ist kleiner.
    - c.next zeigt auf L1. L1 rückt vor auf die 4. c rückt vor.
5. **Resteverarbeitung:** Irgendwann ist eine Liste leer (null). Nehmen wir an, L1 ist fertig:
    - Wir müssen nicht weiter loopen. Wir sagen einfach: c.next = L2.
    - Der gesamte Rest der noch vollen Liste wird mit einem einzigen "Pfeil-Umstecken" angehängt.

**Ergebnis:** Die Kette vom Dummy.next aus ist nun `1 -> 1 -> 2 -> 3 -> 4 -> 4.`

---

</aside>

## Ansatz

Der Trick bei Linked Lists ist oft der **Dummy-Knoten**. Ohne ihn müsstest du am Anfang kompliziert prüfen: "Ist L1 oder L2 der Start der neuen Liste?". Mit dem Dummy baust du die neue Liste einfach "dahinter" auf.

**Die Logik:**

- Nutze zwei Pointer (`L1` und `L2`), um die aktuellen Köpfe der Listen zu vergleichen.
- Der kleinere Wert wird an unsere neue Liste angehängt.
- **Wichtig:** Am Ende bleibt fast immer ein Rest in einer der beiden Listen übrig. Da die Listen bereits sortiert sind, reicht ein einziger Befehl (`c.next = rest`), um alles anzuhängen.

**Merksatz:**

> Baue einen "Schatten-Start" (Dummy) und lass die beiden Listen um den nächsten Platz in der Schlange kämpfen. Wer kleiner ist, darf zuerst ran.
> 

## Stats

![image.png](image.png)