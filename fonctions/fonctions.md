# Maîtriser les Fonctions en Java

---

## Table des matières

1. [Qu'est-ce qu'une fonction ?](#1-quest-ce-quune-fonction-)
2. [Déclaration et syntaxe](#2-déclaration-et-syntaxe)
3. [Les types de retour](#3-les-types-de-retour)
4. [Les paramètres](#4-les-paramètres)
5. [Les modificateurs d'accès](#5-les-modificateurs-daccès)
6. [static vs non-static](#6-static-vs-non-static)
7. [La surcharge (overloading)](#7-la-surcharge-overloading)
8. [La récursivité](#8-la-récursivité)
9. [Passer des tableaux et objets](#9-passer-des-tableaux-et-objets)
10. [Les fonctions lambda](#10-les-fonctions-lambda)
11. [Bonnes pratiques](#11-bonnes-pratiques)
12. [Erreurs fréquentes](#12-erreurs-fréquentes)
13. [Exercices corrigés](#13-exercices-corrigés)

---

## 1. Qu'est-ce qu'une fonction ?

En Java, une **fonction** (aussi appelée **méthode**) est un bloc de code nommé qui effectue une tâche précise et peut être réutilisé autant de fois que nécessaire.

> ⚠️ En Java, toute fonction doit être **déclarée à l'intérieur d'une classe**.

### Pourquoi utiliser des fonctions ?

- **Réutilisabilité** : écrire une fois, appeler partout
- **Lisibilité** : le code est plus clair et organisé
- **Maintenabilité** : corriger un bug à un seul endroit
- **Découpage** : diviser un problème complexe en petits morceaux

---

## 2. Déclaration et syntaxe

```
[modificateur] [static] typeRetour nomFonction([paramètres]) {
    // corps de la fonction
    return valeur; // si typeRetour != void
}
```

### Exemple minimal

```java
public class Main {

    static void direBonjour() {
        System.out.println("Bonjour !");
    }

    public static void main(String[] args) {
        direBonjour(); // appel de la fonction
    }
}
```

### Anatomie détaillée

```java
//   ↓ modificateur   ↓ type de retour   ↓ nom        ↓ paramètre
    public             static int         additionner  (int a, int b) {
        return a + b; // ← valeur retournée
    }
```

---

## 3. Les types de retour

Le type de retour définit ce que la fonction renvoie à l'appelant.

| Type de retour | Description | Exemple |
|---------------|-------------|---------|
| `void` | Ne retourne rien | `static void afficher()` |
| `int` | Entier | `static int compter()` |
| `double` | Décimal | `static double moyenne()` |
| `boolean` | Vrai/Faux | `static boolean estPair()` |
| `String` | Texte | `static String saluer()` |
| `int[]` | Tableau d'entiers | `static int[] generer()` |

### Exemples

```java
// void : ne retourne rien
static void afficherMessage(String msg) {
    System.out.println(msg);
}

// int : retourne un entier
static int carre(int n) {
    return n * n;
}

// boolean : retourne vrai ou faux
static boolean estPair(int n) {
    return n % 2 == 0;
}

// String : retourne du texte
static String saluer(String prenom) {
    return "Bonjour, " + prenom + " !";
}

// double[] : retourne un tableau
static double[] creerTableau(int taille) {
    return new double[taille];
}
```

> ⚠️ Si le type de retour n'est pas `void`, **tous les chemins d'exécution** doivent contenir un `return`.

```java
// ❌ ERREUR : chemin sans return
static int valeurAbsolue(int n) {
    if (n >= 0) {
        return n;
    }
    // oubli du return pour n < 0 → erreur de compilation
}

// ✅ CORRECT
static int valeurAbsolue(int n) {
    if (n >= 0) {
        return n;
    }
    return -n;
}
```

---

## 4. Les paramètres

Les paramètres sont les **données d'entrée** de la fonction.

### Paramètres simples

```java
static double multiplier(double a, double b) {
    return a * b;
}

// Appel
double resultat = multiplier(3.5, 2.0); // résultat = 7.0
```

### Paramètres avec valeur par défaut (simulation)

Java ne supporte pas les valeurs par défaut directement, mais on peut les simuler avec la **surcharge** (voir section 7) :

```java
static void afficherLigne(int longueur, char caractere) {
    for (int i = 0; i < longueur; i++) {
        System.out.print(caractere);
    }
    System.out.println();
}

// Surcharge avec valeur "par défaut"
static void afficherLigne(int longueur) {
    afficherLigne(longueur, '-'); // caractere par défaut = '-'
}
```

### Passage par valeur vs par référence

En Java :
- Les **types primitifs** (`int`, `double`, `boolean`...) sont passés **par valeur** → la fonction travaille sur une copie.
- Les **objets et tableaux** sont passés **par référence** → la fonction peut modifier l'original.

```java
// Passage par valeur : l'original n'est PAS modifié
static void doubler(int n) {
    n = n * 2; // ne modifie pas la variable d'origine
}

// Passage par référence : l'original EST modifié
static void doublerTableau(int[] tab) {
    for (int i = 0; i < tab.length; i++) {
        tab[i] *= 2; // modifie le tableau d'origine
    }
}
```

### Nombre variable de paramètres (varargs)

```java
static int somme(int... nombres) {
    int total = 0;
    for (int n : nombres) {
        total += n;
    }
    return total;
}

// Appels possibles
somme(1, 2);
somme(1, 2, 3, 4, 5);
somme(); // tableau vide
```

---

## 5. Les modificateurs d'accès

Ils contrôlent **qui peut appeler** la fonction.

| Modificateur | Accessible depuis |
|---|---|
| `public` | Partout (autres classes, autres packages) |
| `private` | Uniquement dans la même classe |
| `protected` | La même classe + sous-classes + même package |
| *(aucun)* | Même package uniquement |

```java
public class Calculatrice {

    public double diviser(double a, double b) {
        verifierDiviseur(b); // appel d'une méthode privée
        return a / b;
    }

    private void verifierDiviseur(double b) {
        if (b == 0) {
            throw new ArithmeticException("Division par zéro !");
        }
    }
}
```

---

## 6. static vs non-static

| | `static` | non-`static` |
|---|---|---|
| Appartient à | La **classe** | L'**objet** |
| Appel | `NomClasse.methode()` | `monObjet.methode()` |
| Accès à `this` | ❌ Non | ✅ Oui |
| Usage typique | Utilitaires, `main` | Comportement d'un objet |

```java
public class MathUtils {

    // static : pas besoin d'instancier la classe
    static double cercleAire(double rayon) {
        return Math.PI * rayon * rayon;
    }
}

// Appel direct sans créer d'objet
double aire = MathUtils.cercleAire(5.0);
```

```java
public class Compteur {
    private int valeur = 0;

    // non-static : agit sur l'objet
    public void incrementer() {
        this.valeur++;
    }

    public int getValeur() {
        return this.valeur;
    }
}

// Utilisation
Compteur c = new Compteur();
c.incrementer();
System.out.println(c.getValeur()); // 1
```

---

## 7. La surcharge (Overloading)

Plusieurs fonctions peuvent avoir le **même nom** si leurs **paramètres sont différents**.

```java
static int addition(int a, int b) {
    return a + b;
}

static double addition(double a, double b) {
    return a + b;
}

static int addition(int a, int b, int c) {
    return a + b + c;
}

// Java choisit automatiquement la bonne version selon les arguments
addition(2, 3);           // → int version
addition(2.5, 3.1);       // → double version
addition(1, 2, 3);        // → version à 3 paramètres
```

> ⚠️ On ne peut **pas** surcharger uniquement en changeant le type de retour.

```java
// ❌ ERREUR : même nom, mêmes paramètres, type de retour différent
static int calculer(int n) { return n; }
static double calculer(int n) { return n; } // erreur !
```

---

## 8. La récursivité

Une fonction est **récursive** quand elle s'appelle elle-même. Elle nécessite obligatoirement :

1. Un **cas de base** (condition d'arrêt)
2. Un **appel récursif** qui se rapproche du cas de base

```
fonctionRecursive(n)
    ├── si condition de base → retourner résultat direct
    └── sinon → retourner fonctionRecursive(n réduit)
```

### Exemples classiques

```java
// Factorielle : n! = n × (n-1) × ... × 1
static int factorielle(int n) {
    if (n <= 1) return 1;          // cas de base
    return n * factorielle(n - 1); // appel récursif
}
// factorielle(5) = 5 × 4 × 3 × 2 × 1 = 120

// Suite de Fibonacci : f(n) = f(n-1) + f(n-2)
static int fibonacci(int n) {
    if (n <= 0) return 0;             // cas de base 1
    if (n == 1) return 1;             // cas de base 2
    return fibonacci(n - 1) + fibonacci(n - 2); // appel récursif
}
// fibonacci(6) = 8

// Puissance : base^exp
static double puissance(double base, int exp) {
    if (exp == 0) return 1;                      // cas de base
    if (exp < 0) return 1 / puissance(base, -exp); // exposant négatif
    return base * puissance(base, exp - 1);      // appel récursif
}
```

> ⚠️ Sans cas de base correct → **StackOverflowError** (récursion infinie).

---

## 9. Passer des tableaux et objets

### Tableaux en paramètre

```java
// Calcul de la moyenne d'un tableau
static double moyenne(double[] valeurs) {
    if (valeurs.length == 0) return 0;
    double somme = 0;
    for (double v : valeurs) {
        somme += v;
    }
    return somme / valeurs.length;
}

// Appel
double[] notes = {12.5, 15.0, 9.0, 18.0};
System.out.println(moyenne(notes)); // 13.625
```

### Retourner un tableau

```java
// Retourner les n premiers carrés
static int[] carres(int n) {
    int[] resultat = new int[n];
    for (int i = 0; i < n; i++) {
        resultat[i] = (i + 1) * (i + 1);
    }
    return resultat;
}

// Appel
int[] c = carres(5); // [1, 4, 9, 16, 25]
```

---

## 10. Les fonctions lambda

Introduites en Java 8, les **lambdas** sont des fonctions anonymes concises, souvent utilisées avec les interfaces fonctionnelles.

```java
// Syntaxe : (paramètres) -> { corps }

// Sans paramètre
Runnable r = () -> System.out.println("Hello !");
r.run();

// Avec paramètres
java.util.function.BiFunction<Integer, Integer, Integer> add =
    (a, b) -> a + b;
System.out.println(add.apply(3, 4)); // 7

// Tri d'une liste avec lambda
import java.util.*;
List<String> noms = Arrays.asList("Charlie", "Alice", "Bob");
noms.sort((a, b) -> a.compareTo(b));
System.out.println(noms); // [Alice, Bob, Charlie]
```

---

## 11. Bonnes pratiques

### ✅ Nommage

```java
// ❌ Mauvais noms
static int f(int x) { ... }
static void traitement() { ... }

// ✅ Bons noms (verbe + complément)
static int calculerAire(int largeur, int hauteur) { ... }
static boolean estNombrepremier(int n) { ... }
static void afficherMenu() { ... }
```

### ✅ Principe de responsabilité unique

```java
// ❌ Une fonction qui fait trop
static void gererUtilisateur() {
    // saisie + validation + calcul + affichage = trop !
}

// ✅ Fonctions ciblées
static String saisirNom(Scanner sc) { ... }
static boolean validerNom(String nom) { ... }
static void afficherBienvenue(String nom) { ... }
```

### ✅ Gérer les cas limites

```java
static double diviser(double a, double b) {
    if (b == 0) {
        throw new ArithmeticException("Division par zéro impossible.");
    }
    return a / b;
}
```

### ✅ Éviter les effets de bord inutiles

Privilégier les fonctions qui **retournent** une valeur plutôt que de modifier des variables globales.

```java
// ❌ Effet de bord
static int total = 0;
static void ajouterAuTotal(int n) {
    total += n; // modifie une variable extérieure
}

// ✅ Sans effet de bord
static int ajouter(int total, int n) {
    return total + n;
}
```

---

## 12. Erreurs fréquentes

| Erreur | Cause | Solution |
|--------|-------|----------|
| `missing return statement` | Un chemin ne retourne pas de valeur | Vérifier tous les `if/else` |
| `void cannot be converted` | Utiliser le retour d'une fonction `void` | Changer le type de retour |
| `StackOverflowError` | Récursion sans fin | Vérifier le cas de base |
| `;` après `}` | Point-virgule en fin de méthode | Supprimer le `;` |
| Méthode hors classe | Déclarer une fonction sans classe | Encadrer dans `public class` |
| `non-static method cannot be referenced` | Appeler une méthode non-static depuis `main` | Ajouter `static` ou instancier |

```java
// Erreur classique : appel non-static depuis main
public class Main {
    int addition(int a, int b) { return a + b; } // non-static

    public static void main(String[] args) {
        addition(2, 3); // ❌ ERREUR
        
        // ✅ Solution 1 : rendre static
        // static int addition(int a, int b) { ... }
        
        // ✅ Solution 2 : instancier
        Main m = new Main();
        m.addition(2, 3);
    }
}
```

---

## 13. Exercices corrigés

### Exercice 1 — Vérifier si un nombre est premier

```java
static boolean estPremier(int n) {
    if (n <= 1) return false;
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
    }
    return true;
}
// estPremier(7) → true
// estPremier(9) → false
```

### Exercice 2 — Inverser une chaîne

```java
static String inverser(String s) {
    String resultat = "";
    for (int i = s.length() - 1; i >= 0; i--) {
        resultat += s.charAt(i);
    }
    return resultat;
}
// inverser("Java") → "avaJ"
```

### Exercice 3 — Maximum d'un tableau

```java
static int maximum(int[] tab) {
    if (tab.length == 0) {
        throw new IllegalArgumentException("Tableau vide !");
    }
    int max = tab[0];
    for (int val : tab) {
        if (val > max) max = val;
    }
    return max;
}
// maximum(new int[]{3, 7, 1, 9, 4}) → 9
```

### Exercice 4 — Convertir Celsius en Fahrenheit

```java
static double celsiusVersfahrenheit(double celsius) {
    return celsius * 9.0 / 5.0 + 32;
}

static double fahrenheitVersCelsius(double fahrenheit) {
    return (fahrenheit - 32) * 5.0 / 9.0;
}
// celsiusVersfahrenheit(100.0) → 212.0
```

### Exercice 5 — Compter les occurrences d'un caractère

```java
static int compterOccurrences(String texte, char cible) {
    int compteur = 0;
    for (char c : texte.toCharArray()) {
        if (c == cible) compteur++;
    }
    return compteur;
}
// compterOccurrences("banana", 'a') → 3
```

---

### Projet 5 — Mini calculatrice à menu

#### 🎯 Objectif

Créer une application console interactive en Java qui propose un **menu de calculs mathématiques** à l'utilisateur, en mettant en pratique la **déclaration et l'appel de fonctions** séparées du `main`.

#### 📋 Énoncé

Écrivez un programme Java qui affiche en boucle un menu avec les options suivantes :

```
Menu :
1. Afficher la somme d'une suite de nombres
2. Calculer le factoriel d'un nombre
3. Déterminer si un nombre est premier
4. Afficher la table de multiplication
5. Mettre à la puissance
6. Quitter
```

Le programme doit :

- Répéter le menu jusqu'à ce que l'utilisateur choisisse **Quitter (6)**
- Déléguer chaque calcul à une **fonction dédiée** (pas de logique métier dans le `main`)
- Gérer les cas particuliers (nombre négatif pour la factorielle, tableau vide pour la somme, exposant négatif pour la puissance)

#### 🔧 Fonctions à implémenter

| Fonction | Signature | Description |
|---|---|---|
| `somme` | `static double somme(double[] nombres)` | Retourne la somme de tous les éléments du tableau |
| `factorielle` | `static int factorielle(int n)` | Retourne `n!` (lève une exception si `n < 0`) |
| `estPremier` | `static boolean estPremier(int n)` | Retourne `true` si `n` est premier |
| `tableMultiplication` | `static void tableMultiplication(int n)` | Affiche la table de `n` de 1 à 10 |
| `puissance` | `static double puissance(double base, int exposant)` | Retourne `base^exposant` (gère les exposants négatifs) |

#### 📌 Contraintes

- Utiliser une boucle `do...while` pour le menu
- Utiliser un `switch` pour traiter les choix
- Chaque fonction doit être `static` et indépendante du `main`
- La fonction `estPremier` doit être **correctement appelée** dans le `case 3` et son résultat affiché

#### 💡 Exemple d'exécution attendu

```
Menu :
1. Afficher la somme d une suite de nombre
2. Calculer le factoriel d'un nombre
3. Determiner si un nombre est premier
4. Afficher la table de multiplication
5. Mettre a la puissance
6. Quitter
Entrez votre choix : 1
Entrez le nombre de nombre a additionnes : 3
Entrez le nombre 1 : 4.5
Entrez le nombre 2 : 3.0
Entrez le nombre 3 : 2.5
La somme est : 10.0

Entrez votre choix : 2
Entrez le nombre : 5
Le factoriel est : 120

Entrez votre choix : 4
Entrez le nombre : 3
3 x 1 = 3
3 x 2 = 6
...
3 x 10 = 30

Entrez votre choix : 6
Au revoir !
```

---

## Résumé visuel

```
┌─────────────────────────────────────────────────────┐
│               ANATOMIE D'UNE FONCTION                │
│                                                     │
│  public  static  int  additionner (int a, int b)   │
│    │       │      │       │            │            │
│  accès   portée  retour   nom       paramètres      │
│                                                     │
│  {                                                  │
│      return a + b;  ← instruction de retour         │
│  }                                                  │
└─────────────────────────────────────────────────────┘
```

> 💡 **Règle d'or :** une bonne fonction fait **une seule chose**, la fait **bien**, et a un nom qui l'explique clairement.