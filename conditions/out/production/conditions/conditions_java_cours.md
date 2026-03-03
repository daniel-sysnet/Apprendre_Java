# Cours : Les Conditions en Java

## 1. Introduction

Les **conditions** permettent à un programme Java de prendre des
décisions en fonction de valeurs ou de situations. Elles reposent
principalement sur des **expressions booléennes** (vrai ou faux).

Exemple :

``` java
int age = 20;
if(age >= 18){
    System.out.println("Majeur");
}
```

------------------------------------------------------------------------

## 2. Les opérateurs de comparaison

  Opérateur   Signification       Exemple
  ----------- ------------------- ----------
  `==`        égal à              `a == b`
  `!=`        différent de        `a != b`
  `>`         supérieur à         `a > b`
  `<`         inférieur à         `a < b`
  `>=`        supérieur ou égal   `a >= b`
  `<=`        inférieur ou égal   `a <= b`

Exemple :

``` java
int nombre = 10;
System.out.println(nombre > 0); // true
```

------------------------------------------------------------------------

## 3. Les opérateurs logiques

Ils permettent de combiner plusieurs conditions.

  Opérateur   Signification
  ----------- ---------------
  `&&`        ET logique
  `||`        OU logique
  `!`         NON logique

Exemples :

``` java
System.out.println(true && false); // false
System.out.println(true || false); // true
```

------------------------------------------------------------------------

## 4. Structure `if`

### Syntaxe simple

``` java
if(condition){
    // instructions
}
```

### Exemple

``` java
int nombre = 5;
if(nombre > 0){
    System.out.println("Nombre positif");
}
```

------------------------------------------------------------------------

## 5. Structure `if / else`

Permet d'exécuter une action alternative.

``` java
if(condition){
    // cas vrai
}else{
    // cas faux
}
```

Exemple :

``` java
int age = 15;

if(age >= 18){
    System.out.println("Majeur");
}else{
    System.out.println("Mineur");
}
```

------------------------------------------------------------------------

## 6. Structure `if / else if / else`

Utilisée lorsque plusieurs cas sont possibles.

``` java
int age = 65;

if(age >= 65){
    System.out.println("Senior");
}else if(age >= 18){
    System.out.println("Majeur");
}else{
    System.out.println("Mineur");
}
```

------------------------------------------------------------------------

## 7. Conditions combinées

On peut analyser plusieurs critères simultanément.

``` java
if(nombre > 0 && nombre % 2 == 0){
    System.out.println("Positif et pair");
}
```

Exemple complet :

``` java
if(nombre > 0 && nombre % 2==0){
    System.out.println("Le nombre est positif et pair");
}else if(nombre > 0){
    System.out.println("Le nombre est positif et impair");
}else if(nombre < 0 && nombre % 2==0){
    System.out.println("Le nombre est negatif et pair");
}else if(nombre < 0){
    System.out.println("Le nombre est negatif et impair");
}else{
    System.out.println("Le nombre est nul");
}
```

------------------------------------------------------------------------

## 8. Structure `switch`

Le `switch` permet de tester une variable contre plusieurs valeurs
fixes.

### Syntaxe :

``` java
switch(variable){
    case valeur1:
        // instructions
        break;
    case valeur2:
        // instructions
        break;
    default:
        // cas par défaut
}
```

### Exemple (jours de la semaine)

``` java
switch(jour) {
    case 1:
        System.out.println("Lundi");
        break;
    case 2:
        System.out.println("Mardi");
        break;
    case 3:
        System.out.println("Mercredi");
        break;
    case 4:
        System.out.println("Jeudi");
        break;
    case 5:
        System.out.println("Vendredi");
        break;
    case 6:
        System.out.println("Samedi");
        break;
    case 7:
        System.out.println("Dimanche");
        break;
    default:
        System.out.println("Jour invalide");
}
```

------------------------------------------------------------------------

## 9. Bonnes pratiques

-   Toujours utiliser des conditions claires et lisibles.
-   Éviter les conditions trop longues.
-   Ajouter des commentaires si la logique est complexe.
-   Toujours prévoir un cas `else` ou `default` lorsque nécessaire.

------------------------------------------------------------------------

# Énoncé du Projet (à réaliser)

Créer un programme Java permettant :

1.  De saisir le **nom d'un étudiant**.
2.  De saisir **quatre notes**.
3.  De calculer la **moyenne**.
4.  D'afficher la moyenne.
5.  D'afficher la **mention obtenue** selon les règles suivantes :

  Moyenne   Mention
  --------- -----------------------------------
  \> 18     Très bien + Félicitations du jury
  \> 16     Très bien
  \> 14     Bien
  \> 12     Assez bien
  \> 10     Passable
  ≤ 10      Échoué

Code de base fourni :

``` java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        System.out.println("Saisissez un nom : ");
        String nom = sc.nextLine();

        System.out.println("Saisissez la note 1 : ");
        double note1=sc.nextDouble();
        System.out.println("Saisissez la note 2 : ");
        double note2=sc.nextDouble();
        System.out.println("Saisissez la note 3 : ");
        double note3=sc.nextDouble();
        System.out.println("Saisissez la note 4 : ");
        double note4=sc.nextDouble();

        double moyenne = (note1+note2+note3+note4) /4.0;

        System.out.println("La moyenne de " + nom + " est : " + moyenne);

        if(moyenne > 18){
            System.out.println("Tres bien + Felicitations du jury !");
        }else if(moyenne > 16){
            System.out.println("Tres bien");
        }else if(moyenne > 14){
            System.out.println("Bien");
        }else if(moyenne > 12){
            System.out.println("Assez bien");
        }else if(moyenne > 10){
            System.out.println("Passable");
        }else{
            System.out.println("Echoue");
        }
        sc.close();
    }
}
```
