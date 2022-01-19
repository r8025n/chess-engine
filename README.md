# chess-engine
This repository contains a simple chess engine built from scratch in Java programming language. A GUI using Java Swing was created and linked to the chess engine so that human player can play against the chess engine. Following the object oriented paradigm properly was another main focus of this project.

# Project Description:
**Minimax algorithm** was used to build the chess engine. Mini-max is a recursion based decision making algorithm. What this algorithm does is, it simulates all possible moves by itself as well as the human player till a certain number of moves in advance, creating a recursive tree in process and return the best possible move. To differentiate between moves, a rating system is accumulated with the engine which rates moves using multiple chess rules and strategies.

As this algorithm creates a recursive game tree, it has a exponential complexity so it takes too much time to calculate the best move. Time complexity increases exponentially with the number of moves it has to simulate. So to improve the chess engine performance, **Alpha-beta pruning algorithm** was used over minimax algorithm. Alpha-beta pruning eliminates the unnecessary branches of the game tree in advance, as a result saves time.

Tried to follow the OOP paradigm as much as possible. The class diagram is as below:

![chess engine class diagram](/resources/class-diagram.jpeg)

