# GeomFigur

Aufgabenlösung zur Programmieraufgabe Schuljahr 2023/2024

## How to run
Im Ordner `target/` liegt die fertig kompilierte GeomFigur-1.0.0.jar, diese
kann auf der Kommandozeile mit `java -jar GeomFigur-1.0.0.jar` ausgeführt
werden.

Alternativ kann unter Unix mit `./mvnw package` das Projekt gebaut und in ein
*.jar File gepackt werden, das dann am selben Pfad wie das bereits fertig
gebaute und gepackte *.jar File liegt.

Vorausgesetzt ist eine Installation von Java >= 17.


## Schnittstellendokumentation

Da die gestellte Aufgabe lediglich erfordert, die errechneten Werte für die
verschiedenen Formen oder Körper anzuzeigen, wurde sich für einen möglichst
einfachen und damit weniger fehleranfälligen GUI-Entwurf entschieden.

Die einfachen, untereinander aufgelisteten Eingabefelder und die durch eine
Trennlinie davon abgesetzten Ausgabefelder lassen so wenig Spielraum wie
möglich für Fehlbedienungen.

Bei der Auswahl eines Körpers oder einer Fläche aus dem Drop-Down Menü werden
automatisch nur die relevanten Ein- und Ausgabefelder angezeigt, damit wird
ebenfalls wieder erreicht, dass der Nutzer quasi keine "falschen" 
Bedienvorgänge tätigen kann.

Wenn der Nutzer versucht, etwas anderes als Zahlen in die Eingabefelder 
einzugeben, werden die Tastendrücke einfach verworfen und nicht angezeigt, da
es ansonsten, wenn man dem Nutzer erlauben würde etwa Buchstaben in die
Eingabefelder einzutippen, zu Konvertierungsfehlern im Programm kommen würde.

Falls der Nutzer es trotzdem schafft, etwa per Copy+Paste fehlerhaften Input zu
geben, wird der Konvertierungsfehler abgefangen und dem Nutzer in einem Pop-Up
mitgeteilt, dass er lediglich Zahlen eingeben darf.

Die Ergebnisse werden nach einem Klick auf den Calculate Button errechnet, auch
hier werden nur die relevanten Felder angezeigt, je nachdem welche Fläche oder 
welchen Körper der Nutzer ausgewählt hat.
