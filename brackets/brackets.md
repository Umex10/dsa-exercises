# Brackets

## Solution

```java
import java.util.ArrayDeque;
import java.util.Deque;

public boolean isValid(String s) {
// Wir nutzen Deque als Stack-Interface
Deque<Character> stack = new ArrayDeque<>();

for (char c : s.toCharArray()) {
    if (c == '(' || c == '[' || c == '{') {
        stack.push(c); // Auf den Stack legen
    } else {
        if (stack.isEmpty()) return false;

        char top = stack.pop(); // Oberstes Element holen

        // Check: Passt die schließende Klammer zum Stack-Inhalt?
        if (c == ')' && top != '(') return false;
        if (c == ']' && top != '[') return false;
        if (c == '}' && top != '{') return false;
    }
}

// Wenn der Stack leer ist, waren alle klammern richtig
return stack.isEmpty();
}
```

Wire wir sehen nutzen wir eine Structure von java die `Deque` heißt.  Das ist eigentlich ganz einfach, ich habe am Anfang nur die Angabe falsch verstanden, weswegen ich nie in der Lage war eine eigene Solution zu bilden. 

### Warum genau aber ein Stack? Wieso war das die Solution

Jede offene Klammer ist wie eine **"offene Baustelle"** oder eine **Unterbrechung**.

Wenn du `(` siehst, fängst du eine neue Ebene an. Wenn dann ein `[` kommt, ist das eine "Unterbrechung" der ersten Ebene. Du **musst** erst das `[` erledigen (schließen), bevor du dich wieder um das `(` kümmern kannst.

**Der Stack ist dein "Gedächtnis" für diese offenen Baustellen.**

### Wann weißt du das nächste Mal: "Hier brauche ich einen Stack!"?

Achte auf diese drei Warnsignale in einer Aufgabenstellung:

### 1. Die "Zwiebel-Struktur" (Verschachtelung)

Immer wenn Dinge ineinander liegen (Klammern, HTML-Tags, Ordnerstrukturen), ist ein Stack im Spiel.

- *Signalwörter:* nested, verschachtelt, paarweise, ausgeglichen (balanced).

### 2. Das "Rückwärts-Prinzip"

Wenn du Daten in einer Reihenfolge bekommst, sie aber später genau andersherum (Last-In, First-Out) verarbeiten musst.

- *Beispiel:* Du liest einen Text und sollst ihn rückwärts ausgeben. (Buchstaben auf den Stack werfen, dann wieder runternehmen).

### 3. Das "Undo"-Muster

Immer wenn es eine Aktion gibt, die eine vorherige Aktion "aufhebt" oder "abschließt".

- *Beispiel:* Der "Zurück"-Button im Browser oder `Strg+Z` in Word. Jede Aktion wird auf den Stack gelegt. "Undo" nimmt die oberste (letzte) Aktion einfach wieder weg.