package ua.com.me.tiktaktoe;

import java.util.Scanner;

import static ua.com.me.tiktaktoe.Board.*;


public class App {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Board board = new Board();
        System.out.println("Enter box number to select. Enjoy!\n");

        boolean firstMove = true;
        byte winner = 0;

        while (true) {
            board.print();

            if (firstMove) {
                board.clear();
                firstMove = false;
            }

            if (board.finishGame(winner)) {
                break;
            }

            board.makeMove(scan, X);
            if (board.isWinner(X)) {
                winner = PLAYER_WIN;
                continue;
            }

            if (!board.isCellAvailable()) {
                winner = DRAW;
                continue;
            }

            board.botMove();
            if (board.isWinner(O)) {
                winner = BOOT_WIN;
            }
        }
    }

}