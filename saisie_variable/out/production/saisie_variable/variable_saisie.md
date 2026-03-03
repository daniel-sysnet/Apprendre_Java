# Cours sur les variables, saisies et affichages en Java

Ce document rassemble trois notions fondamentales que vous manipulez dans votre projet : **variables**, **saisie utilisateur** et **affichage**.
Les exemples sont tirés du fichier `App.java` du projet `Projet1_Variable_&_Saisie`.

---

## 📌 1. Qu'est‑ce qu'une variable ?

Une variable est un **nom symbolique** associé à un emplacement mémoire capable de contenir une valeur. En Java, chaque variable est déclarée avec un **type** qui fixe la nature des données autorisées.

> 💡 Imaginez une variable comme une boîte étiquetée : on ne peut y ranger qu’un type précis d’objets.

### Déclaration et affectation

```java
int entier;           // déclaration sans valeur
entier = 42;          // affectation ultérieure

double salaire = 1000.50; // déclaration + affectation
String nom = "Alice";   // type référence (objet)
boolean actif = true;     // type booléen
```

- Les noms doivent respecter la syntaxe Java (*camelCase*, pas de mots réservés, débuter par une lettre ou `_`).
- Vous pouvez déclarer une variable sans lui donner de valeur, mais il faut l’initialiser avant de l’utiliser.

### Types vus dans le projet

| Type     | Description                      | Exemple           |
|----------|----------------------------------|-------------------|
| `int`    | entier 32 bits                   | `int age = 20;`   |
| `double` | réel double précision            | `double pi = 3.14;`|
| `char`   | caractère Unicode                | `char lettre = 'a';` |
| `boolean`| vrai (`true`) ou faux (`false`)  | `boolean ok = false;`|
| Références | objets (`String`, `Scanner`, etc.) | `String nom = "Bob";` |

Les variables primitives stockent directement la valeur ; les références contiennent une adresse pointant vers un objet dans le tas.


## 📝 2. Saisie utilisateur avec `Scanner`

Pour lire des données entrées au clavier, on utilise la classe `java.util.Scanner`.

```java
import java.util.Scanner;

Scanner sc = new Scanner(System.in);
String texte = sc.nextLine();        // ligne complète
int n = sc.nextInt();               // entier
double d = sc.nextDouble();         // réel

sc.close();                         // fermer le scanner
```

> ⚠️ Après un `nextInt()` ou `nextDouble()`, il reste un saut de ligne dans le flux. Si vous appelez `nextLine()` juste après, il renverra une chaîne vide. Utilisez `sc.nextLine();` pour consommer ce retour à la ligne.

### Utilisation dans `App.java`

Voici la séquence d’exercices lue dans le programme :

```java
Scanner sc = new Scanner(System.in);

// 1. nom
System.out.print("Entrez votre nom : ");
String nom = sc.nextLine();
System.out.println("Votre nom est : " + nom + "\n");

// 2. km → miles
System.out.print("Saisissez une distance (km) : ");
double distanceKm = sc.nextDouble();
double distanceMiles = distanceKm * 0.621371;
System.out.println("La valeur en Miles est : " + distanceMiles + "\n");

// 3. °C → °F
System.out.print("Saisissez une temperature (Celsius) : ");
double degreC = sc.nextDouble();
double degreF = (degreC * 1.8) + 32;
System.out.println("La valeur en Fahrenheit est : " + degreF + "\n");

// 4. kg → livres
System.out.print("Saisissez un poids (kg) : ");
double poids = sc.nextDouble();
double livres = poids * 2.20462;
System.out.println("La valeur en livres est : " + livres + "\n");

sc.close();
```

Chaque appel à `nextXxx()` bloque le programme jusqu’à ce que l’utilisateur tape quelque chose et appuie sur Entrée.


## 📣 3. Affichage dans la console

Pour communiquer avec l’utilisateur, on utilise `System.out.print` et `System.out.println` :

- `print` : n’ajoute pas de saut de ligne à la fin.
- `println` : saute à la ligne après l’affichage.

Ils peuvent concaténer des textes et des variables :

```java
System.out.println("Le résultat est " + resultat);
```

On peut également afficher des expressions arithmétiques directement.


## 🔁 Conversions et types

Java convertit automatiquement (widening) un type vers un type plus large : `int` → `double`.
Pour aller dans l’autre sens (narrowing), on effectue un **cast** explicite :

```java
double d = 3.99;
int i = (int) d;    // i vaut 3
```

Attention aux pertes de précision et aux dépassements (`overflow`).


## 🧩 Exercices intégrés à `App.java`

1. Lire un nom et l’afficher.
2. Convertir des kilomètres en miles (1 km ≈ 0,621371 miles).
3. Convertir une température en Celsius vers Fahrenheit.
4. Convertir un poids en kilogrammes vers livres.

> 📌 Ces quatre exercices sont déjà implémentés dans le `main` de `App.java`. Vous pouvez modifier les formules ou enchaîner d’autres calculs.

### Exercices supplémentaires

- Ajouter un menu pour choisir l’opération à effectuer.
- Demander plusieurs valeurs dans une boucle et calculer la moyenne.
- Traiter les entrées incorrectes avec `try`/`catch`.

---
Ce document sert de guide complet pour débuter avec les variables, l’entrée et la sortie en Java. Conservez-le pour vos révisions ou pour accompagner un cours.

Bonne programmation ! 🎓
