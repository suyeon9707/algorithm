/* 프로그래머스 안전지대 */
public class SafeZone {
    int[][] newBoard;

    private void change(int i, int j) {
        change_left_down(i, j);
        change_left(i, j);
        change_left_up(i,j);
        change_up(i,j);
        change_down(i,j);
        change_right_down(i,j);
        change_right(i,j);
        change_right_up(i,j);
    }

    private void change_left_down(int i, int j) {
        if(i != 0 && j != 0)
            if(newBoard[i-1][j-1] != 1)
                newBoard[i-1][j-1] = 2;
    }
    private void change_left(int i, int j) {
        if(j !=0) {
            if(newBoard[i][j-1] != 1)
                newBoard[i][j-1] = 2;
        }
    }
    private void change_left_up(int i, int j) {
        if(j != 0 && i != newBoard.length -1) {
            if(newBoard[i+1][j-1] != 1)
                newBoard[i+1][j-1] = 2;
        }
    }
    private void change_up(int i, int j) {
        if(i != newBoard.length -1) {
            if(newBoard[i+1][j] != 1)
                newBoard[i+1][j] = 2;
        }
    }
    private void change_down(int i, int j) {
        if(i != 0) {
            if(newBoard[i-1][j] != 1)
                newBoard[i-1][j] = 2;
        }
    }
    private void change_right_up(int i, int j) {
        if(i != newBoard.length -1 && j != newBoard[i].length -1) {
            if(newBoard[i+1][j+1] != 1)
                newBoard[i+1][j+1] = 2;
        }
    }
    private void change_right(int i, int j) {
        if(j != newBoard[i].length - 1) {
            if(newBoard[i][j+1] != 1)
                newBoard[i][j+1] = 2;
        }

    }
    private void change_right_down(int i, int j) {
        if(i != 0 && j != newBoard[i].length -1) {
            if(newBoard[i-1][j+1] != 1)
                newBoard[i-1][j+1] = 2;
        }
    }
    public int solution(int[][] board) {

        newBoard = board;

        int answer = 0;
        for(int i=0; i< newBoard.length; i++) {
            for(int j=0; j< newBoard[i].length; j++) {
                if(newBoard[i][j] == 1) {
                    try {
                        change(i,j);
                    } catch (Exception e) {
                        System.out.println(i + ", " + j);
                    }

                }
                else continue;
            }
        }
        for(int i=0; i < newBoard.length; i++) {
            for(int j=0; j<newBoard[i].length; j++) {
                if(newBoard[i][j] == 0)
                    answer ++;
            }
        }
        return answer;
    }
}