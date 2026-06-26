package FPGame;


public class GameLogic {
    private char[][] board;
    public GameLogic(){

        board = new char[3][3];

        reset();

    }

    public void reset(){

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                board[i][j] = ' ';

            }

        }

    }

    public boolean makeMove(
            int row,
            int col,
            char player
    ){

        if(board[row][col]==' '){

            board[row][col]=player;

            return true;

        }


        return false;

    }

    public boolean checkWin(char p){
        // baris
        for(int i=0;i<3;i++){

            if(board[i][0]==p &&
                    board[i][1]==p &&
                    board[i][2]==p)

                return true;

        }
        // kolom
        for(int i=0;i<3;i++){

            if(board[0][i]==p &&
                    board[1][i]==p &&
                    board[2][i]==p)

                return true;

        }
        // diagonal

        if(board[0][0]==p &&
                board[1][1]==p &&
                board[2][2]==p)

            return true;

        if(board[0][2]==p &&
                board[1][1]==p &&
                board[2][0]==p)

            return true;

        return false;

    }

    public boolean isDraw(){

        for(int i=0;i<3;i++){

            for(int j=0;j<3;j++){

                if(board[i][j]==' ')

                    return false;

            }

        }

        return true;

    }

    public char[][] getBoard(){
        return board;
    }

}