# Les Collections en Java — Cours Complet

---

## 1. Introduction

En Java, une **collection** est une structure de données permettant de stocker, organiser et manipuler des groupes d'objets. Contrairement aux tableaux (`[]`), les collections sont **dynamiques** : leur taille s'adapte automatiquement.

Toutes les collections Java se trouvent dans le package :
```java
import java.util.*;
```

### Hiérarchie simplifiée

```
java.util.Collection (interface)
├── List        → éléments ordonnés, doublons autorisés
│   ├── ArrayList
│   └── LinkedList
├── Set         → pas de doublons
│   ├── HashSet
│   └── TreeSet (trié)
└── Queue       → file d'attente (FIFO)
    └── LinkedList

java.util.Map (interface) — clé → valeur
├── HashMap     → non trié
└── TreeMap     → trié par clé
```

---

## 2. Les Tableaux (rappel)

Avant les collections, les tableaux sont des structures **statiques** à taille fixe.

```java
// Déclaration et initialisation
double[] notes = {10.0, 9.5, 8.0, 7.5};

// Parcours avec for-each (lecture uniquement)
for (double note : notes) {
    System.out.println(note);
}

// Parcours avec index (lecture ET écriture)
for (int i = 0; i < notes.length; i++) {
    notes[i] = notes[i] + 1;
}
```

> ⚠️ **Limite :** La taille d'un tableau est fixée à la création. Pour une taille variable, utilisez `ArrayList`.

---

## 3. ArrayList — Liste dynamique

### Déclaration

```java
import java.util.ArrayList;

// ArrayList<Type> — UN SEUL type générique
ArrayList<String> noms = new ArrayList<>();
ArrayList<Integer> nombres = new ArrayList<>();
```

### Opérations principales

```java
ArrayList<String> noms = new ArrayList<>();

// Ajout
noms.add("Daniel");       // ajoute à la fin
noms.add("Alice");
noms.add("Bob");
noms.add(0, "Zara");      // insère à l'index 0

// Accès
String premier = noms.get(0);       // "Zara"
int taille     = noms.size();       // 4

// Modification
noms.set(1, "Daniela");             // remplace l'élément à l'index 1

// Suppression
noms.remove("Alice");               // supprime par valeur
noms.remove(0);                     // supprime par index

// Recherche
boolean existe = noms.contains("Bob");   // true
int index      = noms.indexOf("Bob");    // position de "Bob"

// Vider
noms.clear();
```

### Parcours

```java
ArrayList<String> noms = new ArrayList<>();
noms.add("Daniel");
noms.add("Alice");
noms.add("Bob");

// For-each (recommandé pour la lecture)
for (String nom : noms) {
    System.out.println(nom);
}

// For classique (avec index)
for (int i = 0; i < noms.size(); i++) {
    System.out.println(i + " : " + noms.get(i));
}
```

### ✅ Code corrigé (exemple du cours)

```java
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        // ✅ ArrayList avec UN seul type générique
        ArrayList<String> noms = new ArrayList<>();

        // ✅ add() prend UN seul argument
        noms.add("Daniel");
        noms.add("Alice");
        noms.add("Bob");

        noms.remove("Alice"); // supprime "Alice"

        for (String nom : noms) {
            System.out.println(nom); // Affiche : Daniel, Bob
        }
    }
}
```

---

## 4. LinkedList

`LinkedList` implémente à la fois `List` et `Queue`. Elle est efficace pour les insertions/suppressions fréquentes.

```java
import java.util.LinkedList;

LinkedList<String> liste = new LinkedList<>();
liste.add("A");
liste.add("B");
liste.addFirst("Z");   // ajoute au début
liste.addLast("C");    // ajoute à la fin

String premier  = liste.getFirst();  // "Z"
String dernier  = liste.getLast();   // "C"

liste.removeFirst();  // supprime le premier
liste.removeLast();   // supprime le dernier
```

---

## 5. HashSet — Ensemble sans doublons

Un `Set` ne contient **pas de doublons** et n'est **pas ordonné**.

```java
import java.util.HashSet;

HashSet<String> villes = new HashSet<>();
villes.add("Paris");
villes.add("Lyon");
villes.add("Paris"); // ignoré, déjà présent

System.out.println(villes.size());           // 2
System.out.println(villes.contains("Lyon")); // true

for (String ville : villes) {
    System.out.println(ville); // ordre non garanti
}
```

### TreeSet — Set trié

```java
import java.util.TreeSet;

TreeSet<Integer> nombres = new TreeSet<>();
nombres.add(5);
nombres.add(1);
nombres.add(3);

// Affichage trié : 1, 3, 5
for (int n : nombres) {
    System.out.println(n);
}
```

---

## 6. HashMap — Dictionnaire clé/valeur

Une `Map` associe chaque **clé unique** à une **valeur**.

### Syntaxe

```java
import java.util.HashMap;
import java.util.Map;

// Map<TypeClé, TypeValeur>
Map<Integer, String> clients = new HashMap<>();
```

### Opérations principales

```java
Map<Integer, String> clients = new HashMap<>();

// Ajout
clients.put(1, "Daniel");
clients.put(2, "Alice");
clients.put(3, "Bob");

// Accès
String nom  = clients.get(2);           // "Alice"
boolean b   = clients.containsKey(3);   // true
boolean b2  = clients.containsValue("Bob"); // true

// Modification (put remplace si la clé existe)
clients.put(2, "Alicia");

// Suppression
clients.remove(3);

// Taille
int taille = clients.size(); // 2
```

### Parcours d'une Map

```java
Map<Integer, String> clients = new HashMap<>();
clients.put(1, "Daniel");
clients.put(2, "Alice");
clients.put(3, "Bob");

// Par les clés
for (Integer key : clients.keySet()) {
    System.out.println("ID : " + key + ", Nom : " + clients.get(key));
}

// Par les entrées (recommandé — plus efficace)
for (Map.Entry<Integer, String> entry : clients.entrySet()) {
    System.out.println("ID : " + entry.getKey() + ", Nom : " + entry.getValue());
}

// Par les valeurs seulement
for (String valeur : clients.values()) {
    System.out.println(valeur);
}
```

### TreeMap — Map triée par clé

```java
import java.util.TreeMap;

TreeMap<String, Integer> scores = new TreeMap<>();
scores.put("Bob", 85);
scores.put("Alice", 92);
scores.put("Zara", 78);

// Affiché trié par clé alphabétique : Alice, Bob, Zara
for (Map.Entry<String, Integer> e : scores.entrySet()) {
    System.out.println(e.getKey() + " : " + e.getValue());
}
```

---

## 7. Stocker des objets dans une collection

Pour associer plusieurs informations à une entité, créez une **classe**.

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Client {
    private int id;
    private String nom;
    private String email;

    public Client(int id, String nom, String email) {
        this.id    = id;
        this.nom   = nom;
        this.email = email;
    }

    public int    getId()    { return id; }
    public String getNom()   { return nom; }
    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Client{id=" + id + ", nom='" + nom + "', email='" + email + "'}";
    }
}

public class App {
    public static void main(String[] args) {

        // Dans une ArrayList
        ArrayList<Client> liste = new ArrayList<>();
        liste.add(new Client(1, "Daniel", "daniel@example.com"));
        liste.add(new Client(2, "Alice",  "alice@example.com"));
        liste.add(new Client(3, "Bob",    "bob@example.com"));

        for (Client c : liste) {
            System.out.println(c.getNom() + " → " + c.getEmail());
        }

        // Dans une HashMap
        Map<Integer, Client> map = new HashMap<>();
        for (Client c : liste) {
            map.put(c.getId(), c);
        }

        Client found = map.get(2);
        System.out.println("Client trouvé : " + found.getNom());
    }
}
```

---

## 8. Tableau comparatif des collections

| Collection   | Ordre    | Doublons | Clé/Valeur | Accès par index | Cas d'usage typique              |
|--------------|----------|----------|------------|-----------------|----------------------------------|
| `ArrayList`  | ✅ Oui   | ✅ Oui   | ❌ Non     | ✅ Oui          | Liste d'éléments ordonnés        |
| `LinkedList` | ✅ Oui   | ✅ Oui   | ❌ Non     | ✅ Oui          | Insertions/suppressions fréquentes |
| `HashSet`    | ❌ Non   | ❌ Non   | ❌ Non     | ❌ Non          | Éléments uniques sans ordre      |
| `TreeSet`    | ✅ Trié  | ❌ Non   | ❌ Non     | ❌ Non          | Éléments uniques et triés        |
| `HashMap`    | ❌ Non   | Clés: ❌ | ✅ Oui     | ❌ Non          | Association clé → valeur rapide  |
| `TreeMap`    | ✅ Trié  | Clés: ❌ | ✅ Oui     | ❌ Non          | Map triée par clé                |

---

## 9. Erreurs fréquentes à éviter

```java
// ❌ ArrayList avec plusieurs types génériques
ArrayList<String, Integer> liste = new ArrayList<>();  // ERREUR

// ✅ ArrayList avec un seul type
ArrayList<String> liste = new ArrayList<>();


// ❌ add() avec plusieurs arguments
liste.add("Daniel", 1);  // ERREUR

// ✅ add() avec un seul argument
liste.add("Daniel");


// ❌ Modifier un élément via le for-each
for (String s : liste) {
    s = "nouveau"; // N'affecte PAS la liste
}

// ✅ Modifier via index
for (int i = 0; i < liste.size(); i++) {
    liste.set(i, "nouveau"); // Modifie bien la liste
}


// ❌ ConcurrentModificationException : supprimer pendant un for-each
for (String s : liste) {
    if (s.equals("Alice")) liste.remove(s); // ERREUR

// ✅ Utiliser un Iterator
Iterator<String> it = liste.iterator();
while (it.hasNext()) {
    if (it.next().equals("Alice")) it.remove(); // OK
}
```

---

## 10. Résumé

- **`ArrayList`** → liste dynamique ordonnée, idéale en usage général.
- **`LinkedList`** → meilleures performances pour insertions/suppressions fréquentes.
- **`HashSet`** → garantit l'unicité des éléments, non ordonné.
- **`TreeSet`** → unicité + tri automatique.
- **`HashMap`** → association clé/valeur, accès ultra-rapide par clé.
- **`TreeMap`** → comme HashMap mais trié par clé.
- Pour stocker plusieurs champs par entrée → créer une **classe dédiée**.