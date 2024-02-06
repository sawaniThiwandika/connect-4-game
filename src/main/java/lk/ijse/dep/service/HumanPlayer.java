package lk.ijse.dep.service;

import lk.ijse.dep.controller.BoardController;

public class HumanPlayer extends Player {
    public HumanPlayer(Board newBoard) {
        super(newBoard);

    }

    @Override
    public void movePiece(int col) {
        boolean isLegal = board.isLegalMove(col);
        if (isLegal == true) {
            board.updateMove(col, Piece.BLUE);
            board.getBoardUI().update(col, true);
            Winner winner = board.findWinner();
            if (winner.getCol1() != -1) {
                board.getBoardUI().notifyWinner(winner);
            } else {
                if (!board.existLegalMoves()) {
                    board.getBoardUI().notifyWinner(new Winner(Piece.EMPTY));
                }
            }
        }

    }
}




