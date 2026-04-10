# Remove Linked List Elements

Ansatz: Dummy Node, Singly Linked List
Laufzeit: O(n)
Level: Easy
Memory: O(1)
URL: https://leetcode.com/problems/remove-linked-list-elements/description/

## Solution

```java
class Solution {
    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(0);
        // needed to be able to delete the head like all the ather notes
        dummy.next = head;

        ListNode c = dummy;

        while (c.next != null) {

            if (c.next.val == val) {
                c.next = c.next.next;
            } else {
                c = c.next;
            }
        }

        return dummy.next;
    }
}
```

## Beispiel

<aside>
💡

**Input:** `head = [7, 7, 1, 2]`, `val = 7`

1. **Dummy setzen:** Wir erstellen `dummy(0)` und setzen `dummy.next = head`.
    - Liste sieht jetzt so aus: `[Dummy] -> [7] -> [7] -> [1] -> [2]`
2. **Pointer `c` (current) startet beim Dummy:**
    - `c.next` ist die erste `7`. Wert matcht!
    - **Aktion:** `c.next = c.next.next` (Dummy zeigt jetzt direkt auf die zweite `7`).
3. **Wiederholung:** `c.next` ist die zweite `7`. Wert matcht!
    - **Aktion:** `c.next = c.next.next` (Dummy zeigt jetzt auf die `1`).
4. **Weiterlaufen:** `c.next` ist `1`. Kein Match.
    - **Aktion:** `c = c.next` (Wir rücken vor zur `1`).
5. **Ende:** Am Ende geben wir **`dummy.next`** zurück.
    - Da der Dummy treu auf den ersten gültigen Knoten zeigt, erhalten wir `[1, 2]`.
</aside>

## Ansatz

Das Hauptproblem bei Linked Lists ist die **Instabilität des Anfangs**. Wenn du ein Element löschen musst, das zufällig der `head` ist, hast du keinen "Vorgänger", um den Zeiger umzubiegen.

**Die Lösung: Der Dummy-Knoten (Sentinel)**
Stell dir vor, du rammst einen festen Pfosten vor den Start der Schlange.

- Dieser Pfosten (`dummy`) ist **permanent**.
- Er zeigt auf den aktuellen `head`.
- **Der Clou:** Jetzt hat jedes echte Element der Liste (auch das erste!) einen Vorgänger. Du musst keine Sonderregeln mehr für den Anfang schreiben (`if head == val ...`).

Verwende diesen Ansatz immer, wenn der `head` der Liste "in Gefahr" ist oder sich ändern könnte.

- **Initialisierung:** Erstelle einen neuen Knoten `ListNode dummy = new ListNode(0);`.
- **Ankern:** Verbinde ihn mit der Liste: `dummy.next = head;`.
- **Arbeits-Pointer:** Starte deinen Such-Zeiger beim Dummy (`ListNode c = dummy;`). So stehst du immer **vor** dem Element, das du eventuell löschen willst.
- **Die Lösch-Logik:** * Wenn `c.next.val == val`: Überspringe den Knoten (`c.next = c.next.next`). **Wichtig:** Bleib mit `c` stehen, um den neuen Nachfolger sofort zu prüfen!
    - Sonst: Gehe einen Schritt weiter (`c = c.next`).
- **Rückgabe:** Gib niemals `head` zurück (dieser könnte gelöscht worden sein!), sondern immer **`dummy.next`**.

## Stats

![image.png](image.png)