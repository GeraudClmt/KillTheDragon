# KillTheDragon

KillTheDragon est un jeu Java en ligne de commande où le joueur incarne un héros (Guerrier ou Mage) chargé de vaincre un dragon. Vous pouvez choisir votre type de personnage, personnaliser son nom, et découvrir son inventaire au début de la partie.

## Fonctionnalités
- Choix du type de personnage (Warrior ou Mage)
- Personnalisation du nom du joueur
- Lancement d’une partie ou quitter le jeu
- Affichage de l’inventaire du personnage
- Utilisation de dés (Dice) pour avancer dans le jeu

## Organisation du code
```
.
├── KillTheDragon.iml
├── README.md
├── out
│   └── production
│       └── KillTheDragon
│           ├── Main.class
│           └── fr
│               └── campus
│                   └── killthedragon
│                       ├── character
│                       │   ├── Character.class
│                       │   └── Inventory.class
│                       ├── equipement
│                       │   ├── DefensiveEquipment.class
│                       │   └── OffensiveEquipment.class
│                       └── game
│                           ├── Board.class
│                           ├── Dice.class
│                           ├── Game.class
│                           └── Menu.class
└── src
    ├── Main.java
    └── fr
        └── campus
            └── killthedragon
                ├── character
                │   ├── Character.java
                │   └── Inventory.java
                ├── equipement
                │   ├── DefensiveEquipment.java
                │   └── OffensiveEquipment.java
                └── game
                    ├── Board.java
                    ├── Dice.java
                    ├── Game.java
                    └── Menu.java`
```
## Prérequis
- Java 17 ou ultérieur
- Un IDE comme IntelliJ IDEA, Eclipse, ou simplement le JDK + terminal

## Installation et démarrage

1. Cloner ce dépôt :
   ```bash
   git clone <url>/KillTheDragon
   cd KillTheDragon/src
   ```
2. Compiler le script:
   ```bash
   javac Main.java
   ```
3. Démarrer le script :
   ```bash
   java Main
   ```