package com.TicTacToe.Model;

import com.TicTacToe.Exceptions.*;

public class TicTacToeFacade {

    private final Board board;
    private final GameRules gameRules;
    private final InputHandler inputHandler;
    private final DisplayManager displayManager;
    private GameStatus status;

    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToeFacade() {
        this.board = new Board();
        this.gameRules = new GameRules();
        this.inputHandler = new InputHandler();
        this.displayManager = new DisplayManager();
        this.status = GameStatus.ONGOING;
    }

    public void startGame() {
        boolean exit = false;
        while (!exit) {
            displayManager.printMessage("\n===== TIC TAC TOE =====");
            displayManager.printMessage("1. Human vs Human");
            displayManager.printMessage("2. Human vs Computer");
            displayManager.printMessage("3. Exit");

            int choice = inputHandler.readInt("Enter choice: ");

            if (choice == 3) {
                exit = true;
                displayManager.printMessage("Goodbye!");
                break;
            }

            if (choice == 1 || choice == 2) {
                setupPlayers(choice);
                resetGame();
                gameLoop();
            } else {
                displayManager.printError("Invalid choice.");
            }
        }
    }

    private void setupPlayers(int mode) {
        String player1Name = inputHandler.readValidPlayerName("Enter Player 1 Name: ");
        player1 = new HumanPlayer(player1Name, 'X');

        if (mode == 1) {
            String player2Name = inputHandler.readValidPlayerName("Enter Player 2 Name: ");
            player2 = new HumanPlayer(player2Name, 'O');
        } else {
            player2 = new ComputerPlayer("Computer", 'O');
        }
        currentPlayer = player1;
    }

    public void resetGame() {
        board.resetBoard();
        status = GameStatus.ONGOING;
        currentPlayer = player1;
    }

    private void gameLoop() {
        while (status == GameStatus.ONGOING) {
            displayManager.printBoard(board);
            displayManager.printMessage(currentPlayer.getName() + "'s turn (" + currentPlayer.getSymbol() + ")");

            try {
                if (currentPlayer instanceof ComputerPlayer) {
                    String[] m = currentPlayer.getMove();
                    makeMove(currentPlayer, Integer.parseInt(m[0]), Integer.parseInt(m[1]));
                } else {
                    int[] parsedMove = inputHandler.readAndValidateMove();
                    makeMove(currentPlayer, parsedMove[0], parsedMove[1]);
                }

                status = checkGameStatus();

                if (status == GameStatus.WIN) {
                    displayManager.printBoard(board);
                    displayManager.printMessage("Congratulations " + currentPlayer.getName() + "! You win!");
                } else if (status == GameStatus.DRAW) {
                    displayManager.printBoard(board);
                    displayManager.printMessage("It's a draw!");
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
                }

            } catch (InvalidInputException | InvalidMoveException | OutOfBoundsException | GameAlreadyOverException e) {
                if (!(currentPlayer instanceof ComputerPlayer)) {
                    displayManager.printError(e.getMessage());
                }
            }
        }
    }

    public void makeMove(Player player, int row, int col) throws InvalidMoveException, OutOfBoundsException, GameAlreadyOverException {
        if (status != GameStatus.ONGOING) {
            throw new GameAlreadyOverException("The game has already ended.");
        }
        board.setCell(row, col, player.getSymbol());
    }

    public GameStatus checkGameStatus() {
        return gameRules.checkStatus(board, currentPlayer);
    }
}
