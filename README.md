# Food Fight Game
Intermediate Java - Group Project
A top-down shooter built in Java (Swing/AWT) for CISC 191 (Fall 2020).
You play a character armed with a spork, fighting through a maze
and throwing food at enemies. **Defeat all of them to win.**



<img width="800" height="619" alt="FoodFight" src="https://github.com/user-attachments/assets/2fd4e7d1-9be5-4c9e-ae3a-888a604e48b5" />



Requirements
- JDK 14 or newer

How to Run:

Through the project folder:
    mkdir out
    javac -d out src/main/java/FoodFight/*.java
    cp src/main/resources/* out
    java -cp out FoodFight.Game

OR

Open the folder in an IDE and run 'Game.java'.
There are images involved for the sprites so make sure 'src/main/resources' is on the classpath.

## Controls
- W / A / S / D: move
- Mouse click: throw food towards the cursor
- Back button (top right): pause

## Gameplay
- Pick up ammo crates for +10 ammo.
- Pick up health boxes to restore health.
- Touching an enemy drains health. Reaching 0 ends the game.
- Defeat all 26 enemies to win. Your time is shown on the end screen.

# Team
Main character and Sprite Animation: 
Reese Bell

Game over/Lose State: 
Lauren Tomasi

Main Menu/Pause Menu: 
Kaelin Facun

Character Design and Animation: 
Esther Song

Bullet Collision: 
Dennis Lai

# Known Issues
- An IndexOutOfBoundsException can occasionally freeze game movement.
- "New Game" after winning or losing does not reload the level.
- The HUD can be overlapped by the game map.
- Collision can let the Player/enemies clip through walls.
- You can run out of ammo after spamming it
- Some drop assets (i.e health potion) cannot be picked up
