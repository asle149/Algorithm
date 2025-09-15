import java.io.*;
import java.util.*;

public class Main {
    static char[][] board = new char[3][3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            int cntX = 0, cntO = 0;
            for (int i = 0; i < 9; i++) {
                char ch = s.charAt(i);
                board[i / 3][i % 3] = ch;
                if (ch == 'X') cntX++;
                else if (ch == 'O') cntO++;
            }

            boolean xWin = win('X');
            boolean oWin = win('O');
            
            boolean valid = false;

            if (cntX == cntO || cntX == cntO + 1) {
                if (xWin && oWin){
                    valid = false;
                }else if (xWin){
                    valid = (cntX == cntO + 1);
                }else if (oWin){
                    valid = (cntX == cntO);
                }else{
                    valid = (cntX + cntO == 9) && (cntX == cntO + 1);
                }
            }

            sb.append(valid ? "valid" : "invalid").append('\n');
        }
        System.out.print(sb);
    }

    static boolean win(char t) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == t && board[i][1] == t && board[i][2] == t) return true;
            if (board[0][i] == t && board[1][i] == t && board[2][i] == t) return true;
        }
        
        if (board[0][0] == t && board[1][1] == t && board[2][2] == t) return true;
        if (board[2][0] == t && board[1][1] == t && board[0][2] == t) return true;
        return false;
    }
}