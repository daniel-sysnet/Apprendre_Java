# 🟠 Programmation Orientée Objet en Java
### Cours complet — Classes, Attributs, Constructeurs, Méthodes, Encapsulation, Static, Surcharge, Composition & Héritage

---

## Table des matières

1. [Introduction à la POO](#1-introduction-à-la-poo)
2. [Les Classes et les Objets](#2-les-classes-et-les-objets)
3. [Les Attributs](#3-les-attributs)
4. [Les Constructeurs](#4-les-constructeurs)
5. [Les Méthodes](#5-les-méthodes)
6. [L'Encapsulation](#6-lencapsulation)
7. [Le mot-clé `static`](#7-le-mot-clé-static)
8. [La Surcharge (Overloading)](#8-la-surcharge-overloading)
9. [La Composition](#9-la-composition)
10. [L'Héritage](#10-lhéritage)
11. [Exemple récapitulatif complet](#11-exemple-récapitulatif-complet)

---

## 1. Introduction à la POO

La **Programmation Orientée Objet (POO)** est un paradigme de programmation qui organise le code autour d'**objets** — des entités qui regroupent des **données** (attributs) et des **comportements** (méthodes).

### Les 4 piliers de la POO

| Pilier | Description |
|---|---|
| **Encapsulation** | Protéger les données internes d'un objet |
| **Abstraction** | Cacher la complexité, exposer l'essentiel |
| **Héritage** | Une classe peut hériter d'une autre |
| **Polymorphisme** | Un même nom peut avoir plusieurs comportements |

### Pourquoi utiliser la POO ?

- Modéliser le monde réel (une `Personne`, un `CompteBancaire`, un `Animal`)
- Réutiliser le code via l'héritage et la composition
- Faciliter la maintenance et l'évolution du code
- Organiser les projets complexes de manière lisible

---

## 2. Les Classes et les Objets

### Qu'est-ce qu'une classe ?

Une **classe** est un **modèle** (ou plan) qui décrit la structure et le comportement d'un type d'objet. Elle définit les attributs et méthodes que ses objets posséderont.

```java
public class Personne {
    // Attributs, constructeurs, méthodes...
}
```

### Qu'est-ce qu'un objet ?

Un **objet** est une **instance** d'une classe. C'est la réalisation concrète du modèle défini par la classe.

```java
// Création d'un objet de type Personne
Personne p1 = new Personne("AGOMA", "Daniel", 21);
```

> **Analogie** : la classe `Personne` est le plan d'architecte, et `p1` est la maison construite à partir de ce plan.

### Syntaxe générale d'une classe Java

```java
public class NomDeLaClasse {

    // 1. Attributs (données)
    type attribut;

    // 2. Constructeur(s)
    public NomDeLaClasse(paramètres) {
        // initialisation
    }

    // 3. Méthodes (comportements)
    public typeRetour nomMethode(paramètres) {
        // corps
    }
}
```

---

## 3. Les Attributs

Les **attributs** (ou champs / fields) représentent les **données** d'un objet. Ils décrivent son état.

### Déclaration

```java
public class Personne {
    String nom;       // attribut de type String
    String prenom;    // attribut de type String
    int age;          // attribut de type int
}
```

### Types de données courants en Java

| Type | Description | Exemple |
|---|---|---|
| `int` | Entier | `21` |
| `double` | Nombre décimal | `1500.50` |
| `boolean` | Vrai ou faux | `true` |
| `String` | Chaîne de caractères | `"AGOMA"` |
| `char` | Un seul caractère | `'A'` |

### Bonne pratique : visibilité des attributs

Il est recommandé de déclarer les attributs en `private` pour protéger les données (voir section Encapsulation) :

```java
public class CompteBancaire {
    private String numeroCompte;  // privé = protégé
    private double solde;
    private String titulaire;
}
```

---

## 4. Les Constructeurs

Un **constructeur** est une méthode spéciale appelée automatiquement lors de la création d'un objet avec `new`. Il initialise les attributs de l'objet.

### Caractéristiques d'un constructeur

- Porte **exactement le même nom** que la classe
- **N'a pas de type de retour** (même pas `void`)
- Peut avoir des **paramètres** ou non

### Constructeur avec paramètres

```java
public class Personne {
    String nom;
    String prenom;
    int age;

    // Constructeur
    public Personne(String nom, String prenom, int age) {
        this.nom = nom;       // this.nom = attribut de l'objet
        this.prenom = prenom; // nom = paramètre du constructeur
        this.age = age;
    }
}
```

### Le mot-clé `this`

`this` fait référence à **l'objet courant** (l'instance en cours de création). Il permet de distinguer un attribut d'un paramètre qui portent le même nom.

```java
public Personne(String nom, String prenom, int age) {
    this.nom = nom;   // this.nom → attribut | nom → paramètre
    this.prenom = prenom;
    this.age = age;
}
```

### Appel du constructeur

```java
// Dans le main ou ailleurs
Personne p1 = new Personne("AGOMA", "Daniel", 21);
```

### ⚠️ Erreur classique : oublier un attribut dans le constructeur

Dans le code de la classe `Animal`, la `race` est déclarée mais jamais assignée dans le constructeur :

```java
public Animal(String nom, int age, String race) {
    this.nom = nom;
    this.age = age;
    // ❌ this.race = race; → OUBLI !
}
```

**Correction :**

```java
public Animal(String nom, int age, String race) {
    this.nom = nom;
    this.age = age;
    this.race = race; // ✅ Ne pas oublier d'initialiser tous les attributs
}
```

---

## 5. Les Méthodes

Les **méthodes** définissent les **comportements** d'un objet. Elles décrivent ce qu'un objet peut faire.

### Syntaxe

```java
public typeDeRetour nomMethode(paramètres) {
    // instructions
    return valeur; // si typeDeRetour ≠ void
}
```

### Méthode sans retour (`void`)

```java
public void sePresenter() {
    System.out.println("Je m'appelle " + this.prenom + " " + this.nom
                       + " et j'ai " + this.age + " ans.");
}
```

> `void` signifie que la méthode **ne retourne rien**.

### Méthode avec retour

```java
public boolean estMajeur() {
    if (this.age < 0) {
        throw new IllegalArgumentException("L'âge ne peut pas être négatif.");
    } else if (this.age < 18) {
        return false;
    } else {
        return true;
    }
}
```

> Cette méthode retourne un `boolean` : `true` si la personne est majeure, `false` sinon.

### Appel d'une méthode

```java
Personne p1 = new Personne("AGOMA", "Daniel", 21);

p1.sePresenter();           // Appel sans récupération du retour
boolean majeur = p1.estMajeur(); // Appel avec récupération du retour

System.out.println(p1.estMajeur()); // Affiche : true
```

### Les exceptions

Une **exception** signale une erreur à l'exécution. On peut en lancer avec `throw` :

```java
if (this.age < 0) {
    throw new IllegalArgumentException("L'âge ne peut pas être négatif.");
}
```

---

## 6. L'Encapsulation

L'**encapsulation** consiste à **masquer les données internes** d'un objet et à n'y autoriser l'accès qu'à travers des méthodes contrôlées.

### Niveaux de visibilité

| Modificateur | Classe | Package | Sous-classe | Partout |
|---|---|---|---|---|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (défaut) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

### Getters et Setters

Les **getters** lisent la valeur d'un attribut privé. Les **setters** la modifient avec validation.

```java
public class CompteBancaire {
    private String numeroCompte;
    private double solde;
    private String titulaire;

    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0.0; // Solde initialisé à 0
    }

    // ✅ GETTER : lire le solde
    public double getSolde() {
        return solde;
    }

    // ✅ SETTER avec validation : déposer de l'argent
    public boolean setDeposer(double montant) {
        if (montant <= 0) {
            return false; // Montant invalide
        } else {
            this.solde += montant;
            return true;
        }
    }

    // ✅ SETTER avec validation : retirer de l'argent
    public boolean setRetirer(double montant) {
        if (montant <= 0 || montant > this.solde) {
            return false; // Montant invalide ou insuffisant
        } else {
            this.solde -= montant;
            return true;
        }
    }
}
```

### Pourquoi utiliser l'encapsulation ?

```java
// ❌ SANS encapsulation : accès direct, aucun contrôle
cb1.solde = -500; // On peut mettre un solde négatif !

// ✅ AVEC encapsulation : accès contrôlé via méthode
cb1.setDeposer(-500); // Retourne false, solde inchangé
```

L'encapsulation **protège la cohérence** des données.

---

## 7. Le mot-clé `static`

Un membre `static` appartient à la **classe elle-même**, et non à une instance particulière. Il est partagé par tous les objets de la classe.

### Attribut statique

```java
public class CompteBancaire {
    private static int nombreDeComptes = 0; // Partagé par tous

    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0.0;
        nombreDeComptes++; // Incrémenté à chaque création
    }

    public static int getNombreDeComptes() {
        return nombreDeComptes;
    }
}
```

### Méthode statique

```java
// Appel sans créer d'objet
int total = CompteBancaire.getNombreDeComptes();
```

### `static` dans le `main`

```java
public class App {
    public static void main(String[] args) {
        // La méthode main est statique : elle est appelée par la JVM
        // sans créer d'instance de App
    }
}
```

### Comparaison : instance vs static

```java
public class Exemple {
    int valeurInstance = 10;       // Propre à chaque objet
    static int valeurStatique = 0; // Partagée par tous les objets

    public static void methodeStatique() {
        // ✅ Peut accéder à valeurStatique
        // ❌ Ne peut PAS accéder à valeurInstance (pas d'objet)
    }

    public void methodeInstance() {
        // ✅ Peut accéder à valeurInstance ET à valeurStatique
    }
}
```

---

## 8. La Surcharge (Overloading)

La **surcharge** consiste à définir **plusieurs méthodes avec le même nom** mais des **signatures différentes** (nombre ou types de paramètres différents).

### Surcharge de méthode

```java
public class Personne {
    String nom;
    String prenom;
    int age;

    // Méthode de base
    public void sePresenter() {
        System.out.println("Je m'appelle " + prenom + " " + nom);
    }

    // Surcharge : même nom, paramètre en plus
    public void sePresenter(String message) {
        System.out.println(message + " Je m'appelle " + prenom + " " + nom);
    }

    // Surcharge : même nom, paramètres différents
    public void sePresenter(String message, boolean avecAge) {
        if (avecAge) {
            System.out.println(message + " " + prenom + " " + nom
                               + ", " + age + " ans.");
        } else {
            sePresenter(message);
        }
    }
}
```

### Surcharge de constructeur

```java
public class Personne {
    String nom;
    String prenom;
    int age;

    // Constructeur complet
    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
    }

    // Constructeur surchargé : sans l'âge
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = 0; // Valeur par défaut
    }

    // Constructeur surchargé : sans paramètres
    public Personne() {
        this.nom = "Inconnu";
        this.prenom = "Inconnu";
        this.age = 0;
    }
}
```

### Utilisation

```java
Personne p1 = new Personne("AGOMA", "Daniel", 21); // Constructeur complet
Personne p2 = new Personne("DUPONT", "Alice");      // Constructeur sans âge
Personne p3 = new Personne();                       // Constructeur vide

p1.sePresenter();                    // "Je m'appelle Daniel AGOMA"
p1.sePresenter("Bonjour !");        // "Bonjour ! Je m'appelle Daniel AGOMA"
p1.sePresenter("Salut,", true);     // "Salut, Daniel AGOMA, 21 ans."
```

> ⚠️ La surcharge se distingue par la **signature** (nom + paramètres), **pas** par le type de retour.

---

## 9. La Composition

La **composition** consiste à inclure des **objets d'autres classes** comme attributs d'une classe. C'est la relation **"a un"** (*has-a*).

> **Composition** = une classe *possède* une ou plusieurs instances d'une autre classe.

### Exemple : une `Personne` possède un `CompteBancaire`

```java
public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private CompteBancaire compte; // Composition : Personne "a un" CompteBancaire

    public Personne(String nom, String prenom, int age, String numeroCompte) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.compte = new CompteBancaire(numeroCompte, nom + " " + prenom);
    }

    public void deposer(double montant) {
        compte.setDeposer(montant);
    }

    public void afficherSolde() {
        System.out.println("Solde de " + prenom + " : " + compte.getSolde() + " €");
    }
}
```

### Utilisation

```java
Personne p1 = new Personne("AGOMA", "Daniel", 21, "123456789");
p1.deposer(500.0);
p1.afficherSolde(); // Solde de Daniel : 500.0 €
```

### Composition dans l'App originale

```java
// Dans App.java, on crée indépendamment un CompteBancaire
CompteBancaire cb1 = new CompteBancaire("123456789", "AGOMA Daniel");
cb1.setDeposer(montantDeposer);
cb1.setRetirer(montantaRetirer);
System.out.println("Solde : " + cb1.getSolde());
```

---

## 10. L'Héritage

L'**héritage** permet à une classe (**sous-classe**) de récupérer automatiquement les attributs et méthodes d'une autre classe (**super-classe**). C'est la relation **"est un"** (*is-a*).

> **Héritage** = une classe *est une* version spécialisée d'une autre.

### Syntaxe : `extends`

```java
public class Chien extends Animal {
    // Chien hérite de tous les attributs et méthodes d'Animal
}
```

### La super-classe : `Animal`

```java
public class Animal {
    private String nom;
    private int age;
    private String race;

    // Constructeur de la super-classe
    public Animal(String nom, int age, String race) {
        this.nom = nom;
        this.age = age;
        this.race = race;
    }

    public void sePresenter() {
        System.out.println("Je suis " + nom + ", race : " + race
                           + ", âge : " + age + " ans.");
    }

    public String getNom() { return nom; }
    public int getAge()    { return age; }
    public String getRace(){ return race; }
}
```

### La sous-classe : `Chien`

```java
public class Chien extends Animal {

    // Constructeur qui appelle celui du parent via super()
    public Chien(String nom, int age, String race) {
        super(nom, age, race); // ✅ Appel obligatoire au constructeur parent
    }

    // Méthode propre à Chien (ajout de comportement)
    public void aboyer() {
        System.out.println(getNom() + " dit : Wouf !");
    }
}
```

### Le mot-clé `super`

`super` fait référence à la **classe parente**. Il est utilisé pour :

- Appeler le **constructeur parent** : `super(paramètres)` *(doit être la 1ère ligne)*
- Appeler une **méthode parent** : `super.methode()`

```java
public Chien(String nom, int age, String race) {
    super(nom, age, race); // Appel du constructeur d'Animal
}
```

### Redéfinition de méthode (Override)

Une sous-classe peut **redéfinir** une méthode héritée avec `@Override` :

```java
public class Chien extends Animal {

    public Chien(String nom, int age, String race) {
        super(nom, age, race);
    }

    @Override
    public void sePresenter() {
        // On réutilise la méthode parent ET on ajoute du comportement
        super.sePresenter();
        System.out.println("Je suis un chien et je dis Wouf !");
    }

    public void aboyer() {
        System.out.println(getNom() + " : Wouf Wouf !");
    }
}
```

### Utilisation

```java
Animal a1 = new Animal("Rex", 5, "Berger Allemand");
a1.sePresenter(); // Je suis Rex, race : Berger Allemand, âge : 5 ans.

Chien c1 = new Chien("Médor", 3, "Labrador");
c1.sePresenter(); // Je suis Médor... + "Je suis un chien et je dis Wouf !"
c1.aboyer();      // Médor : Wouf Wouf !
```

### Héritage vs Composition

| | Héritage | Composition |
|---|---|---|
| Relation | "est un" (is-a) | "a un" (has-a) |
| Exemple | `Chien` est un `Animal` | `Personne` a un `CompteBancaire` |
| Flexibilité | Moins flexible | Plus flexible |
| Couplage | Fort | Faible |

---

## 11. Exemple récapitulatif complet

Voici un exemple qui combine **tous les concepts** vus dans ce cours :

```java
// ==================== Animal.java ====================
public class Animal {
    private String nom;
    private int age;
    private String race;
    private static int nombreAnimaux = 0; // static

    public Animal(String nom, int age, String race) {
        this.nom = nom;
        this.age = age;
        this.race = race;
        nombreAnimaux++;
    }

    public void sePresenter() {
        System.out.println("Je suis " + nom + " (" + race + "), " + age + " ans.");
    }

    public static int getNombreAnimaux() {
        return nombreAnimaux;
    }

    public String getNom() { return nom; }
    public int getAge()    { return age; }
    public String getRace(){ return race; }
}

// ==================== Chien.java ====================
public class Chien extends Animal {         // Héritage

    public Chien(String nom, int age, String race) {
        super(nom, age, race);              // Appel constructeur parent
    }

    @Override
    public void sePresenter() {            // Redéfinition
        super.sePresenter();
        System.out.println("Je suis un chien fidèle !");
    }

    public void aboyer() {
        System.out.println(getNom() + " : Wouf !");
    }
}

// ==================== CompteBancaire.java ====================
public class CompteBancaire {             // Encapsulation
    private String numeroCompte;
    private double solde;
    private String titulaire;

    public CompteBancaire(String numeroCompte, String titulaire) {
        this.numeroCompte = numeroCompte;
        this.titulaire = titulaire;
        this.solde = 0.0;
    }

    public double getSolde()             { return solde; }

    public boolean setDeposer(double montant) {
        if (montant <= 0) return false;
        this.solde += montant;
        return true;
    }

    public boolean setRetirer(double montant) {
        if (montant <= 0 || montant > this.solde) return false;
        this.solde -= montant;
        return true;
    }
}

// ==================== Personne.java ====================
public class Personne {
    private String nom;
    private String prenom;
    private int age;
    private CompteBancaire compte;        // Composition

    public Personne(String nom, String prenom, int age) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.compte = new CompteBancaire("AUTO-" + nom, nom + " " + prenom);
    }

    // Surcharge du constructeur
    public Personne(String nom, String prenom) {
        this(nom, prenom, 0);             // Appel au constructeur principal
    }

    public void sePresenter() {
        System.out.println("Je m'appelle " + prenom + " " + nom
                           + " et j'ai " + age + " ans.");
    }

    // Surcharge de méthode
    public void sePresenter(String message) {
        System.out.println(message + " " + prenom + " " + nom);
    }

    public boolean estMajeur() {
        if (this.age < 0) throw new IllegalArgumentException("Âge invalide.");
        return this.age >= 18;
    }

    public void deposer(double montant) { compte.setDeposer(montant); }
    public void retirer(double montant) { compte.setRetirer(montant); }
    public double getSolde()            { return compte.getSolde(); }
}

// ==================== App.java ====================
public class App {
    public static void main(String[] args) {

        // --- Personne ---
        Personne p1 = new Personne("AGOMA", "Daniel", 21);
        p1.sePresenter();
        p1.sePresenter("Bonjour, je suis");
        System.out.println("Majeur ? " + p1.estMajeur());

        p1.deposer(1000.0);
        p1.retirer(250.0);
        System.out.println("Solde : " + p1.getSolde() + " €");

        // --- Animaux ---
        Chien c1 = new Chien("Médor", 3, "Labrador");
        c1.sePresenter();
        c1.aboyer();

        Animal a1 = new Animal("Félix", 2, "Chat Siamois");
        a1.sePresenter();

        System.out.println("Nombre d'animaux créés : "
                           + Animal.getNombreAnimaux()); // static
    }
}
```

### Sortie attendue

```
Je m'appelle Daniel AGOMA et j'ai 21 ans.
Bonjour, je suis Daniel AGOMA
Majeur ? true
Solde : 750.0 €
Je suis Médor (Labrador), 3 ans.
Je suis un chien fidèle !
Médor : Wouf !
Je suis Félix (Chat Siamois), 2 ans.
Nombre d'animaux créés : 2
```

---

## Récapitulatif des concepts

| Concept | Mot-clé | Rôle |
|---|---|---|
| **Classe** | `class` | Modèle pour créer des objets |
| **Objet** | `new` | Instance d'une classe |
| **Attribut** | — | Donnée d'un objet |
| **Constructeur** | même nom que la classe | Initialise les attributs |
| **Méthode** | — | Comportement d'un objet |
| **Encapsulation** | `private` + getters/setters | Protège les données |
| **Static** | `static` | Appartient à la classe, pas à l'instance |
| **Surcharge** | même nom, params différents | Plusieurs versions d'une méthode |
| **Composition** | attribut = objet | "a un" — réutilisation par inclusion |
| **Héritage** | `extends` | "est un" — réutilisation par spécialisation |
| **super** | `super()` / `super.m()` | Accès à la classe parente |
| **Override** | `@Override` | Redéfinition d'une méthode héritée |
| **this** | `this` | Référence à l'objet courant |

---

*Cours rédigé à partir des exemples pratiques : `Personne`, `CompteBancaire`, `Animal`, `Chien` et `App`.*