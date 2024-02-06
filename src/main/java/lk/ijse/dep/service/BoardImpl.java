package lk.ijse.dep.service;

import java.sql.SQLOutput;

public class BoardImpl implements Board {
    private final BoardUI boardUI;
    private final Piece [][] pices=new Piece[NUM_OF_COLS][NUM_OF_ROWS];



    public BoardImpl(BoardUI boardUI){
        this.boardUI=boardUI;
        for(int i=0;i<NUM_OF_COLS;i++){
            for (int j=0;j<NUM_OF_ROWS;j++){
                pices[i][j]=Piece.EMPTY;
            }
        }
    }

    @Override
    public BoardUI getBoardUI() {
        return boardUI;
    }

    @Override
    public int findNextAvailableSpot(int col) {

        for (int j=0;j<NUM_OF_ROWS;j++){
            if(pices[col][j]==Piece.EMPTY){
                return j;
            }
        }
        return -1;
    }

    @Override
    public boolean isLegalMove(int col) {
        int rowNum= findNextAvailableSpot(col);
        if (rowNum==-1){
            return false;
        }
        else {
            return true;
        }
    }
    public int availableSpot;
    @Override
    public boolean existLegalMoves() {
        for(int i=0;i<NUM_OF_COLS;i++) {
            for (int j = 0; j < NUM_OF_ROWS; j++) {
                if (pices[i][j] == Piece.EMPTY) {
                    return true;
                }
            }
        }
        return false;

    }
    public void updateMove(int col, int row, Piece move) {
            pices[col][row]=move;

    }

    @Override
    public void updateMove(int col, Piece move) {
        int freeRow=findNextAvailableSpot(col);
        if(freeRow!=-1){
            pices[col][freeRow]=move;
        }
    }



    @Override
    public Winner findWinner() {
        for(int i=0;i<NUM_OF_COLS;i++){
            for(int j=0;j<=NUM_OF_ROWS-4;j++){
                Piece piece=pices[i][j];

                if((pices[i][j]==piece)&&(pices[i][j+1]==piece)&&(pices[i][j+2]==piece)&&(pices[i][j+3]==piece)&& (pices[i][j]!=Piece.EMPTY)){

                    return new Winner(piece,i,i,j,j+3);

                }
            }
        }
        for(int i=0;i<NUM_OF_ROWS;i++){
            for(int j=0;j<=NUM_OF_COLS-4;j++){
                Piece piece=pices[j][i];

                if((pices[j][i]==piece)&&(pices[j+1][i]==piece)&&(pices[j+2][i]==piece)&&(pices[j+3][i]==piece)&& (pices[j][i]!=Piece.EMPTY)){

                    return new Winner(piece,j,j+3,i,i);

                }
            }
        }
        return new Winner(Piece.EMPTY,-1,-1,-1,-1);

    }

}
