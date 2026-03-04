# Les Collections en Java

## Table des matières
1. [Les Tableaux (Arrays)](#1-les-tableaux-arrays)
2. [ArrayList](#2-arraylist)
3. [HashMap](#3-hashmap)
4. [Comparaison des structures](#4-comparaison-des-structures)
5. [Erreurs fréquentes à éviter](#5-erreurs-fréquentes-à-éviter)
6. [Projet : Gestionnaire de notes](#6-projet--gestionnaire-de-notes)

---

## 1. Les Tableaux (Arrays)

### Définition
Un tableau est une structure de données **de taille fixe** qui stocke des éléments du **même type**.

### Déclaration et initialisation

```java
// Déclaration avec taille fixe
double[] notes = new double[4];

// Déclaration avec valeurs initiales
double[] notes = {10.0, 9.5, 8.0, 7.5};
```

### Remplir un tableau avec Scanner

```java
Scanner sc = new Scanner(System.in);

System.out.print("Saisissez une taille de tableau : ");
int taille = sc.nextInt();

double[] notes = new double[taille];

for (int i = 0; i < notes.length; i++) {
    System.out.print("Saisissez la note " + (i + 1) + " : ");
    notes[i] = sc.nextDouble(); // on affecte via l'index
}
```

> ⚠️ Pour **remplir** un tableau, on utilise une boucle `for` avec index (`notes[i] = ...`).  
> Le `for-each` sert uniquement à **lire** les valeurs.

### Parcourir un tableau

```java
// Boucle for classique (accès par index)
for (int i = 0; i < notes.length; i++) {
    System.out.println("Note " + (i + 1) + " : " + notes[i]);
}

// Boucle for-each (lecture seule)
for (double note : notes) {
    System.out.println(note);
}
```

### Opérations courantes

```java
double[] notes = {10.0, 9.5, 8.0, 7.5};

// Calcul de la moyenne
double moyenne = 0.0;
for (double note : notes) {
    moyenne += note;
}
moyenne /= notes.length;
System.out.println("Moyenne : " + moyenne); // 8.75

// Minimum et maximum
double min = notes[0];
double max = notes[0];

for (double note : notes) {
    if (note < min) min = note;
    else if (note > max) max = note;
}
System.out.println("Min : " + min); // 7.5
System.out.println("Max : " + max); // 10.0
```

### Limites des tableaux
| Caractéristique | Tableau |
|---|---|
| Taille | **Fixe** à la création |
| Type | Un seul type |
| Méthode d'ajout | Par index `tab[i] = val` |
| `.add()` | ❌ Non disponible |
| `.length` | ✅ Disponible |

---

## 2. ArrayList

### Définition
`ArrayList` est une **liste dynamique** dont la taille s'ajuste automatiquement. Elle fait partie du package `java.util`.

### Import nécessaire

```java
import java.util.ArrayList;
```

### Déclaration

```java
// ✅ Un seul paramètre de type
ArrayList<String> noms = new ArrayList<>();

// ❌ ERREUR : ArrayList n'accepte pas deux types
ArrayList<String, Integer> noms = new ArrayList<>(); // Ne compile pas
```

### Méthodes principales

```java
ArrayList<String> noms = new ArrayList<>();

// Ajouter des éléments
noms.add("Daniel");  // ✅ un seul argument
noms.add("Alice");
noms.add("Bob");

// Supprimer un élément par valeur
noms.remove("Alice");

// Accéder à un élément par index
String premier = noms.get(0); // "Daniel"

// Taille de la liste
int taille = noms.size(); // 2

// Vérifier si un élément existe
boolean existe = noms.contains("Bob"); // true
```

### Parcourir une ArrayList

```java
// Boucle for-each
for (String nom : noms) {
    System.out.println(nom);
}

// Boucle for classique
for (int i = 0; i < noms.size(); i++) {
    System.out.println(noms.get(i));
}
```

### Caractéristiques
| Caractéristique | ArrayList |
|---|---|
| Taille | **Dynamique** |
| Paramètres de type | **1 seul** |
| `.add(valeur)` | ✅ |
| `.remove(valeur)` | ✅ |
| `.get(index)` | ✅ |
| `.size()` | ✅ |
| Doublons | ✅ Autorisés |
| `null` | ✅ Autorisé |

> 💡 **Conseil :** Si tu as besoin d'associer une clé à une valeur (ex : un ID à un nom), utilise `HashMap` plutôt qu'une `ArrayList`.

---

## 3. HashMap

### Définition
`HashMap` est une structure de données qui stocke des paires **clé → valeur**. Elle fait partie du package `java.util`.

### Import nécessaire

```java
import java.util.HashMap;
import java.util.Map;
```

### Déclaration

```java
// Map<TypeClé, TypeValeur>
Map<Integer, String> client_list = new HashMap<>();
```

### Méthodes principales

```java
Map<Integer, String> client_list = new HashMap<>();

// Ajouter des paires clé/valeur
client_list.put(1, "Daniel");
client_list.put(2, "Alice");
client_list.put(3, "Bob");

// Accéder à une valeur par clé
String nom = client_list.get(1); // "Daniel"

// Supprimer une entrée
client_list.remove(2);

// Vérifier si une clé existe
boolean existe = client_list.containsKey(1); // true

// Taille
int taille = client_list.size(); // 2
```

### Parcourir une HashMap

```java
// Parcourir les clés
for (Integer key : client_list.keySet()) {
    String name = client_list.get(key);
    System.out.println("ID: " + key + ", Name: " + name);
}

// Parcourir les valeurs uniquement
for (String value : client_list.values()) {
    System.out.println(value);
}

// Parcourir les paires clé/valeur
for (Map.Entry<Integer, String> entry : client_list.entrySet()) {
    System.out.println("ID: " + entry.getKey() + ", Name: " + entry.getValue());
}
```

### Stocker des objets complexes

Quand une entrée nécessite plusieurs champs, on crée une **classe dédiée** :

```java
class Client {
    private String name, email, phone;

    public Client(String name, String email, String phone) {
        this.name  = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName()  { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}
```

```java
Map<Integer, Client> clients = new HashMap<>();
clients.put(1, new Client("Daniel", "daniel@example.com", "123456789"));
clients.put(2, new Client("Alice",  "alice@example.com",  "987654321"));
clients.put(3, new Client("Bob",    "bob@example.com",    "456789123"));

for (Integer key : clients.keySet()) {
    String name  = clients.get(key).getName();
    String email = clients.get(key).getEmail();
    String phone = clients.get(key).getPhone();
    System.out.println("ID: " + key + " | " + name + " | " + email + " | " + phone);
}
```

### Caractéristiques
| Caractéristique | HashMap |
|---|---|
| Paramètres de type | **2** (`<Clé, Valeur>`) |
| `.put(clé, valeur)` | ✅ |
| `.get(clé)` | ✅ |
| `.remove(clé)` | ✅ |
| Clés dupliquées | ❌ Écrase l'ancienne valeur |
| Ordre garanti | ❌ Non ordonné |

---

## 4. Comparaison des structures

| Critère | `Array` | `ArrayList` | `HashMap` |
|---|---|---|---|
| Taille | Fixe | Dynamique | Dynamique |
| Type de données | Primitifs ou objets | Objets uniquement | Paires Clé/Valeur |
| Accès | Par index | Par index | Par clé |
| Ajout | `tab[i] = val` | `.add(val)` | `.put(clé, val)` |
| Suppression | Impossible directement | `.remove(val)` | `.remove(clé)` |
| Cas d'usage | Taille connue à l'avance | Liste ordonnée flexible | Associations clé → valeur |

---

## 5. Erreurs fréquentes à éviter

### ❌ Mauvais nombre de types génériques
```java
// ArrayList n'a qu'un type, Map en a deux
ArrayList<String, Integer> liste = new ArrayList<>();  // ERREUR
Map<Integer, String, String> map = new HashMap<>();    // ERREUR
```

### ❌ Utiliser .add() sur un tableau
```java
double[] notes = new double[3];
notes.add(10.0); // ERREUR : les tableaux n'ont pas de méthode add()
notes[0] = 10.0; // ✅ Correct
```

### ❌ Modifier une variable de boucle for-each
```java
for (double note : notes) {
    note = sc.nextDouble(); // ❌ ne modifie pas le tableau
}
// ✅ Utiliser une boucle for avec index à la place
for (int i = 0; i < notes.length; i++) {
    notes[i] = sc.nextDouble();
}
```

### ❌ Variable non définie dans la boucle
```java
for (Integer key : map.keySet()) {
    map.get(id);  // ❌ 'id' n'est pas défini ici
    map.get(key); // ✅ utiliser la variable de boucle
}
```

### ❌ Passer plusieurs arguments à .add()
```java
noms.add("Daniel", 1); // ❌ add(index, valeur) insère à une position, pas un deuxième champ
noms.add("Daniel");    // ✅
```

---

## 6. Projet : Gestionnaire de notes

### Énoncé

En vous basant sur le programme suivant, **étendez-le** pour créer un gestionnaire de notes complet :

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Saisissez une taille de tableau : ");
        int taille = sc.nextInt();

        double[] notes = new double[taille];

        for (int i = 0; i < notes.length; i++) {
            System.out.print("Saisissez la note " + (i + 1) + " : ");
            notes[i] = sc.nextDouble();
        }

        System.out.println("Notes saisies :");
        for (double note : notes) {
            System.out.println("  " + note);
        }

        double moyenne = 0.0;
        for (double note : notes) {
            moyenne += note;
        }
        moyenne /= notes.length;
        System.out.println("Moyenne : " + moyenne);

        double min = notes[0];
        double max = notes[0];

        for (double note : notes) {
            if (note < min) min = note;
            else if (note > max) max = note;
        }
        System.out.println("Note minimale : " + min);
        System.out.println("Note maximale : " + max);
        sc.close();
    }
}
```

### Travail demandé

**Partie 1 — ArrayList**
- Remplacez le tableau `double[]` par une `ArrayList<Double>`
- Ajoutez une méthode permettant de **supprimer une note** par sa valeur
- Affichez la liste mise à jour après suppression

**Partie 2 — HashMap**
- Créez une `Map<String, Double>` qui associe le **nom d'un étudiant** à sa **note**
- Permettez à l'utilisateur de saisir les paires nom/note
- Affichez le classement : qui a la meilleure note ? qui a la moins bonne ?

**Partie 3 — Classe dédiée (bonus)**
- Créez une classe `Etudiant` avec les champs : `nom`, `email`, `note`
- Stockez les étudiants dans une `Map<Integer, Etudiant>`
- Affichez le tableau complet des étudiants avec leur mention :
  - `< 10` → Insuffisant
  - `10 ≤ note < 12` → Passable
  - `12 ≤ note < 14` → Assez bien
  - `14 ≤ note < 16` → Bien
  - `≥ 16` → Très bien

### Contraintes
- Le programme doit gérer les saisies incorrectes (note négative ou > 20)
- Utilisez des méthodes séparées pour chaque fonctionnalité
- Commentez votre code

---

*Bonne chance !*