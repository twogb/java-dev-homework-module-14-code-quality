package ua.com.me.tiktaktoe;

import java.util.Scanner;

class Board {
    private final char[] cells;
    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY_CELL = ' ';
    public static final int PLAYER_WIN = 1;
    public static final int BOOT_WIN = 2;
    public static final int DRAW = 3;


    public Board() {
        cells = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    }

    public void print() {
        System.out.println("\n\n " + cells[0] + " | " + cells[1] + " | " + cells[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + cells[3] + " | " + cells[4] + " | " + cells[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + cells[6] + " | " + cells[7] + " | " + cells[8] + " \n");
    }

    public void clear() {
        for (int i = 0; i < 9; i++) {
            cells[i] = EMPTY_CELL;
        }
    }

    public boolean finishGame(int winner) {
        if (winner == PLAYER_WIN) {
            System.out.println("You won the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == BOOT_WIN) {
            System.out.println("You lost the game!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        } else if (winner == DRAW) {
            System.out.println("It's a draw!\nCreated by Shreyas Saha. Thanks for playing!");
            return true;
        }
        return false;
    }

    public boolean isCellAvailable() {
        for (char cell : cells) {
            if (cell != X && cell != O) {
                return true;
            }
        }
        return false;
    }

    public void makeMove(Scanner scan, char player) {
        while (true) {
            int input = scan.nextInt();
            if (input > 0 && input < 10) {
                if (cells[input - 1] == X || cells[input - 1] == O) {
                    System.out.println("That one is already in use. Enter another.");
                } else {
                    cells[input - 1] = player;
                    break;
                }
            } else {
                System.out.println("Invalid input. Enter again.");
            }
        }
    }

    public void botMove() {
        while (true) {
            int rand = (int) (Math.random() * 9);
            if (cells[rand] != X && cells[rand] != O) {
                cells[rand] = O;
                break;
            }
        }
    }

    public boolean isWinner(char player) {
        return ((cells[0] == player && cells[1] == player && cells[2] == player) ||
                (cells[3] == player && cells[4] == player && cells[5] == player) ||
                (cells[6] == player && cells[7] == player && cells[8] == player) ||
                (cells[0] == player && cells[3] == player && cells[6] == player) ||
                (cells[1] == player && cells[4] == player && cells[7] == player) ||
                (cells[2] == player && cells[5] == player && cells[8] == player) ||
                (cells[0] == player && cells[4] == player && cells[8] == player) ||
                (cells[2] == player && cells[4] == player && cells[6] == player));
    }
}
