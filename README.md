Fortgeschrittene Programmierung (Java 2)


# Übung 10


Klonen Sie dieses Repository direkt in Eclipse und importieren Sie das Maven-Projekt. Legen Sie einen neuen Branch an, den Sie nach Ihrem GitHub-Benutzernamen benennen.


## Aufgabe 1

In der Klasse `idh.java.ATM` finden Sie eine vereinfachte Version des Geldautomaten, den wir früher schonmal gesehen haben. Der Automat kennt jetzt keine Banken oder Kontos mehr, sondern gibt nur noch die passende Stückelung an Scheinen für einen Betrag aus. Dies passiert in der Methode `convertToBills(int amount)`, die ein `int[]` zurückliefert. Verstehen Sie zunächst wie diese Methode funktioniert. 

Für diese Methode sollen Sie nun Unit-Tests schreiben um zu überprüfen, ob sie sich korrekt verhält.

Das korrekte Verhalten ist das folgende:

- Bei einer durch fünf teilbaren Eingabe wird eine Stückelung erzeugt, die möglichst wenig Scheine verbraucht (d.h. es werden immer möglichst große Scheine ausgegeben). Testen Sie dies mit einer Reihe von möglichen Eingaben. Achten Sie dabei auf extreme Eingaben, also mit kleinst- und größtmöglichen Zahlen.

- Bei Eingabe einer negativen Zahl wird ein Array mit Nullen zurückgegeben.

- Bei Eingabe einer Zahl die nicht durch fünf teilbar ist, wird eine Exception der Klasse `IllegalInputException` geworfen.

## Aufgabe 2

Das Semester neigt sich ja allmählich dem Ende zu, daher gibt es keine weitere Programmieraufgabe. Gehen Sie stattdessen Ihre Notizen, Aufzeichnungen und vergangenen Übungen durch und stellen Sie sicher, dass Sie alles (wichtige) verstanden haben. Nutzen Sie die kommende Sitzungen um ggf. nochmal nachzufragen.


----

Wenn Sie fertig sind, committen Sie alle Ihre Änderungen, und pushen Sie den neuen Branch auf das remote namens `origin` (= GitHub). 