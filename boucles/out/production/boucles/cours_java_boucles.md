# Les Boucles en Java

## Introduction

Une **boucle** permet de répéter un bloc d'instructions plusieurs fois, tant qu'une condition est vraie. Java propose trois types de boucles principales : `while`, `do...while` et `for`.

---

## 1. La boucle `while`

### Syntaxe

```java
while (condition) {
    // instructions répétées tant que la condition est vraie
}
```

La condition est évaluée **avant** chaque itération. Si elle est fausse dès le départ, le bloc n'est jamais exécuté.

### Exemple — Compter de 1 à 5

```java
int i = 0;
while (i < 5) {
    System.out.println(i + 1);
    i++;
}
```

### Exemple — Boucle infinie avec flag

```java
boolean isPlaying = true;
int i = 0;
while (isPlaying) {
    System.out.println(i + 1);
    if (i >= 5) {
        isPlaying = false;
    }
    i++;
}
```

> On utilise souvent un booléen (`isPlaying`, `running`, etc.) pour contrôler une boucle dont la fin dépend d'une logique métier.

### Exemple — Afficher uniquement les nombres pairs

```java
int i = 0;
while (i < 5) {
    i++;
    if (i % 2 == 1) {
        continue; // saute les impairs
    }
    System.out.println(i); // affiche 2, 4
}
```

Le mot-clé `continue` passe immédiatement à l'itération suivante sans exécuter la suite du bloc.

---

## 2. La boucle `do...while`

### Syntaxe

```java
do {
    // instructions
} while (condition);
```

La condition est évaluée **après** chaque itération. Le bloc est donc exécuté **au moins une fois**, même si la condition est fausse.

### Exemple — Menu interactif

```java
Scanner sc = new Scanner(System.in);
int choix;
do {
    System.out.println("Menu");
    System.out.println("Saisir votre choix");
    choix = sc.nextInt();

    if (choix == 1) {
        System.out.println("Option 1");
    } else if (choix == 2) {
        System.out.println("Option 2");
    } else if (choix == 3) {
        System.out.println("Option 3");
    } else if (choix == 4) {
        System.out.println("Option 4");
    }
} while (choix != 0); // 0 pour quitter
```

> Le `do...while` est idéal pour les menus : on affiche toujours le menu au moins une fois avant de vérifier si l'utilisateur veut quitter.

---

## 3. La boucle `for`

### Syntaxe

```java
for (initialisation; condition; incrément) {
    // instructions
}
```

Elle regroupe en une seule ligne l'initialisation, la condition et l'incrément. Pratique quand le nombre d'itérations est connu à l'avance.

### Exemple — Compter de 1 à 5

```java
for (int i = 0; i < 5; i++) {
    System.out.println(i + 1);
}
```

---

## 4. La boucle `for-each`

### Syntaxe

```java
for (Type variable : collection) {
    // instructions
}
```

Utilisée pour parcourir un tableau ou une collection sans gérer d'index manuellement.

### Exemple — Parcourir les arguments du programme

```java
for (String arg : args) {
    System.out.println(arg);
}
```

> ⚠️ En Java, le type de la variable d'itération est **obligatoire**. Écrire `for(arg : args)` provoque une erreur de compilation.

---

## 5. Mots-clés utiles dans les boucles

| Mot-clé    | Effet                                              |
|------------|----------------------------------------------------|
| `break`    | Interrompt la boucle immédiatement                 |
| `continue` | Passe à l'itération suivante                       |

### Exemple avec `break`

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) break;
    System.out.println(i); // affiche 0 à 4
}
```

---

## 6. Tableau récapitulatif

| Boucle       | Condition évaluée | Cas d'usage typique                        |
|--------------|-------------------|--------------------------------------------|
| `while`      | Avant             | Nombre d'itérations inconnu                |
| `do...while` | Après             | Au moins une exécution garantie (menus...) |
| `for`        | Avant             | Nombre d'itérations connu                  |
| `for-each`   | Avant             | Parcourir un tableau ou une collection     |

---

## Projet — Le jeu du nombre mystère

### Énoncé

Créez un programme Java qui génère aléatoirement un **nombre entier entre 1 et 100**, puis demande à l'utilisateur de le deviner.

À chaque tentative, le programme indique si le nombre à trouver est **plus grand** ou **plus petit** que la saisie. La boucle se termine lorsque l'utilisateur trouve le bon nombre. Le programme affiche alors un message de félicitations ainsi que le **nombre de tentatives** effectuées.

### Contraintes

- Utiliser une boucle `while` dont la condition porte sur la comparaison entre la saisie et le nombre mystère.
- Utiliser `Math.random()` pour générer le nombre aléatoire.
- Utiliser `Scanner` pour lire les saisies de l'utilisateur.
- Compter et afficher le nombre d'essais à la fin.

### Exemple d'exécution

```
Faites votre choix : 50
Le nombre est plus grand que 50
Faites votre choix : 75
Le nombre est plus petit que 75
Faites votre choix : 63
Félicitations, vous avez trouvé le bon numéro : 63
Nombre de tentatives : 3
```

### Solution

```java
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nombre = (int)(Math.random() * 100) + 1;
        int nb_essais = 0;
        int nombre_saisi = 0;

        while (nombre_saisi != nombre) {

            System.out.print("Faites votre choix : ");
            nombre_saisi = sc.nextInt();
            nb_essais++;

            if (nombre_saisi < nombre) {
                System.out.println("Le nombre est plus grand que " + nombre_saisi);
            } else if (nombre_saisi > nombre) {
                System.out.println("Le nombre est plus petit que " + nombre_saisi);
            } else {
                System.out.println("Félicitations, vous avez trouvé le bon numéro : " + nombre);
                System.out.println("Nombre de tentatives : " + nb_essais);
            }
        }

        sc.close();
    }
}
```

> **Note :** La variable `nombre_saisi` est initialisée à `0` avant la boucle pour pouvoir être utilisée dans la condition du `while`. Si elle était déclarée à l'intérieur de la boucle, elle serait inaccessible dans la condition.