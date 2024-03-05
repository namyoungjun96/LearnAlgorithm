package programmers.level2;

import java.util.*;

class Tictacto {
    public int solution(String[] board) {
        int answer = 0;

        int[][] win = {
                {0, 0, 1, 0, 2, 0},
                {0, 0, 0, 1, 0, 2},
                {0, 0, 1, 1, 2, 2},
                {0, 2, 1, 2, 2, 2},
                {2, 0, 2, 1, 2, 2},
                {0, 1, 1, 1, 2, 1},
                {1, 0, 1, 1, 1, 2},
                {0, 2, 1, 1, 2, 0}};

        char[][] boardSituation = new char[3][3];
        int oCount = 0;
        int xCount = 0;

        int oWinner = 0;
        int xWinner = 0;

        for (int i = 0; i < board.length; i++)
            boardSituation[i] = board[i].toCharArray();

        for (char[] chars : boardSituation) {
            for (char aChar : chars) {
                if (aChar == 'O') {
                    oCount += 1;
                } else if (aChar == 'X') {
                    xCount += 1;
                }
            }
        }

        for (int[] ints : win) {
            char temp = boardSituation[ints[0]][ints[1]];

            if (temp != '.' && (temp == boardSituation[ints[2]][ints[3]] && boardSituation[ints[2]][ints[3]] == boardSituation[ints[4]][ints[5]])) {
                if (temp == 'O')
                    oWinner += 1;
                else
                    xWinner += 1;

            }
        }

        if (oCount == xCount && (oWinner == 0 && ( xWinner == 0 || xWinner == 1)))
            return 1;
        else if (oCount - xCount == 1 && (oWinner >= xWinner && xWinner == 0))
            return 1;

        return answer;
    }
}
