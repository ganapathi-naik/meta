import java.util.*;
public class Solution348 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter grid size:");
        int n = sc.nextInt();
        TicTacToe ttt = new TicTacToe(n);
        int winner;
        int row ;
        int col;
        int player;
        do {
            System.out.println("Enter row(0 to n-1), col(0 to n-1) and player(1 to 2):");
            row = sc.nextInt();
            col = sc.nextInt();
            player = sc.nextInt();
        } while((winner = ttt.move(row, col, player)) == 0);
        sc.close();

        System.out.println("Player " + winner + " won the match");
    }
}

class TicTacToe {
    int[] rows;
    int[] cols;
    int diagonal;
    int antiDiagonal;
    int n;
    public TicTacToe(int n) {
        this.rows = new int[n];
        this.cols = new int[n];
        this.n = n;
        this.diagonal = 0;
        this.antiDiagonal = 0;
    }

    public int move(int row, int col, int player) {
        if(player == 1) {
            this.rows[row]++;
            this.cols[col]++;
            if(row == col) {
                diagonal++;
            }
            if(n - 1 + col == row) {
                antiDiagonal++;
            }
            if(rows[row] == n || cols[col] == n || diagonal == n || antiDiagonal == n) {
                return 1;
            }
        } else {
            this.rows[row]--;
            this.cols[col]--;
            if(row == col) {
                diagonal--;
            }
            if(n - 1 + col == row) {
                antiDiagonal--;
            }
            if(rows[row] == -n || cols[col] == -n || diagonal == -n || antiDiagonal == -n) {
                return 2;
            }
        }
        return 0;
    }
}
