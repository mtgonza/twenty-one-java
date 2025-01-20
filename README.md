# twenty-one-java
Java-based implementation of the card game Twenty-One with a GUI built using SceneBuilder.

## Features
- Playable Twenty-One card game with standard rules.
- Graphical User Interface (GUI) built with Scene Builder.
- Player vs Dealer gameplay.
- Player starts with $20 in wallet.
- Each game requires a minimum bet of $5.
- Option to increase bet in increments of $5.
- Option to hit or stand during the game.
- Tracks the player's score and automatically ends the game when the player or dealer exceeds 21 points.

## How to Play
1. Player and Dealer are both dealt two cards, one face-up and one face-down.
2. The goal of the player is to get a hand value as close to 21 as possible, without going over.
3. The value of a numbered card is equal to its numerical value.  Face cards have a value of 10.  Ace has a value of 11, unless the total card values exceed 21, then Ace has a value of 1.
4. The player can choose to Bet (increment bet by $5), Hit (draw a card), or Stand (no further action).
5. In the case of a draw, the player loses.

## Screenshots
![Image](https://github.com/user-attachments/assets/97765f96-bdca-46ed-ad8c-e67e28b701af)

## Future Improvements
- Add multiplayer support.
- Implement Dealer AI (dealer currently plays with predefined rules and will simply hit until it reaches a value of at least 17).
- Enhance the user interface with animations or more graphical features.
- Implement a scoreboard system to track wins/losses.
