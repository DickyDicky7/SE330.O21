package com.mygdx.game.chess.test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.mygdx.game.chess.engine.board.Board;
import com.mygdx.game.chess.engine.board.BoardUtils;
import com.mygdx.game.chess.engine.board.Move;
import com.mygdx.game.chess.engine.board.MoveTransition;
import com.mygdx.game.chess.engine.fen.FenUtilities;

import org.junit.Test;

public final class CastlingTest {

    @Test
    public void testWhiteKingSideCastle() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(Move.MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));
        assertTrue(t1.moveStatus().isFinished());
        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t2.moveStatus().isFinished());
        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "g1"), BoardUtils.getCoordinateAtPosition("f3")));
        assertTrue(t3.moveStatus().isFinished());
        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d6")));
        assertTrue(t4.moveStatus().isFinished());
        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("e2")));
        assertTrue(t5.moveStatus().isFinished());
        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "d6"), BoardUtils.getCoordinateAtPosition("d5")));
        assertTrue(t6.moveStatus().isFinished());
        final Move move = Move.MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "e1"), BoardUtils.getCoordinateAtPosition("g1"));
        assertTrue(t6.latestBoard().currentPlayer().getLegalMoves().contains(move));
        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(move);
        assertTrue(t7.moveStatus().isFinished());
        assertTrue(t7.latestBoard().whitePlayer().isCastled());
        assertFalse(t7.latestBoard().whitePlayer().isKingSideCastleCapable());
        assertFalse(t7.latestBoard().whitePlayer().isQueenSideCastleCapable());
    }

    @Test
    public void testWhiteQueenSideCastle() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(Move.MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));
        assertTrue(t1.moveStatus().isFinished());
        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t2.moveStatus().isFinished());
        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "d2"), BoardUtils.getCoordinateAtPosition("d3")));
        assertTrue(t3.moveStatus().isFinished());
        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d6")));
        assertTrue(t4.moveStatus().isFinished());
        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "c1"), BoardUtils.getCoordinateAtPosition("d2")));
        assertTrue(t5.moveStatus().isFinished());
        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "d6"), BoardUtils.getCoordinateAtPosition("d5")));
        assertTrue(t6.moveStatus().isFinished());
        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "d1"), BoardUtils.getCoordinateAtPosition("e2")));
        assertTrue(t7.moveStatus().isFinished());
        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "h7"), BoardUtils.getCoordinateAtPosition("h6")));
        assertTrue(t8.moveStatus().isFinished());
        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "b1"), BoardUtils.getCoordinateAtPosition("c3")));
        assertTrue(t9.moveStatus().isFinished());
        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "h6"), BoardUtils.getCoordinateAtPosition("h5")));
        assertTrue(t10.moveStatus().isFinished());
        final Move move = Move.MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "e1"), BoardUtils.getCoordinateAtPosition("c1"));
        assertTrue(t10.latestBoard().currentPlayer().getLegalMoves().contains(move));
        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(move);
        assertTrue(t11.moveStatus().isFinished());
        assertTrue(t11.latestBoard().whitePlayer().isCastled());
        assertFalse(t11.latestBoard().whitePlayer().isKingSideCastleCapable());
        assertFalse(t11.latestBoard().whitePlayer().isQueenSideCastleCapable());
    }

    @Test
    public void testBlackKingSideCastle() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(Move.MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));
        assertTrue(t1.moveStatus().isFinished());
        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t2.moveStatus().isFinished());
        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "d2"), BoardUtils.getCoordinateAtPosition("d3")));
        assertTrue(t3.moveStatus().isFinished());
        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "g8"), BoardUtils.getCoordinateAtPosition("f6")));
        assertTrue(t4.moveStatus().isFinished());
        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "d3"), BoardUtils.getCoordinateAtPosition("d4")));
        assertTrue(t5.moveStatus().isFinished());
        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "f8"), BoardUtils.getCoordinateAtPosition("e7")));
        assertTrue(t6.moveStatus().isFinished());
        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "d4"), BoardUtils.getCoordinateAtPosition("d5")));
        assertTrue(t7.moveStatus().isFinished());
        final Move move = Move.MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "e8"), BoardUtils.getCoordinateAtPosition("g8"));
        assertTrue(t7.latestBoard().currentPlayer().getLegalMoves().contains(move));
        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(move);
        assertTrue(t8.moveStatus().isFinished());
        assertTrue(t8.latestBoard().blackPlayer().isCastled());
        assertFalse(t8.latestBoard().blackPlayer().isKingSideCastleCapable());
        assertFalse(t8.latestBoard().blackPlayer().isQueenSideCastleCapable());
    }

    @Test
    public void testBlackQueenSideCastle() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(Move.MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));
        assertTrue(t1.moveStatus().isFinished());
        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t2.moveStatus().isFinished());
        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "d2"), BoardUtils.getCoordinateAtPosition("d3")));
        assertTrue(t3.moveStatus().isFinished());
        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d8"), BoardUtils.getCoordinateAtPosition("e7")));
        assertTrue(t4.moveStatus().isFinished());
        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "b1"), BoardUtils.getCoordinateAtPosition("c3")));
        assertTrue(t5.moveStatus().isFinished());
        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "b8"), BoardUtils.getCoordinateAtPosition("c6")));
        assertTrue(t6.moveStatus().isFinished());
        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "c1"), BoardUtils.getCoordinateAtPosition("d2")));
        assertTrue(t7.moveStatus().isFinished());
        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d6")));
        assertTrue(t8.moveStatus().isFinished());
        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("e2")));
        assertTrue(t9.moveStatus().isFinished());
        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "c8"), BoardUtils.getCoordinateAtPosition("d7")));
        assertTrue(t10.moveStatus().isFinished());
        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "g1"), BoardUtils.getCoordinateAtPosition("f3")));
        assertTrue(t11.moveStatus().isFinished());
        final Move move = Move.MoveFactory.createMove(t11.latestBoard(), BoardUtils.getPieceAtPosition(t11.latestBoard(), "e8"), BoardUtils.getCoordinateAtPosition("c8"));
        assertTrue(t11.latestBoard().currentPlayer().getLegalMoves().contains(move));
        final MoveTransition t12 = t11.latestBoard().currentPlayer().makeMove(move);
        assertTrue(t12.moveStatus().isFinished());
        assertTrue(t12.latestBoard().blackPlayer().isCastled());
        assertFalse(t12.latestBoard().blackPlayer().isKingSideCastleCapable());
        assertFalse(t12.latestBoard().blackPlayer().isQueenSideCastleCapable());
    }

    @Test
    public void testCastleBugOne() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(Move.MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));
        assertTrue(t1.moveStatus().isFinished());
        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d5")));
        assertTrue(t2.moveStatus().isFinished());
        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "e4"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t3.moveStatus().isFinished());
        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "c8"), BoardUtils.getCoordinateAtPosition("f5")));
        assertTrue(t4.moveStatus().isFinished());
        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("d3")));
        assertTrue(t5.moveStatus().isFinished());
        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "f5"), BoardUtils.getCoordinateAtPosition("d3")));
        assertTrue(t6.moveStatus().isFinished());
        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "c2"), BoardUtils.getCoordinateAtPosition("d3")));
        assertTrue(t7.moveStatus().isFinished());
        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e6")));
        assertTrue(t8.moveStatus().isFinished());
        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "d1"), BoardUtils.getCoordinateAtPosition("a4")));
        assertTrue(t9.moveStatus().isFinished());
        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "d8"), BoardUtils.getCoordinateAtPosition("d7")));
        assertTrue(t10.moveStatus().isFinished());
        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(Move.MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "b1"), BoardUtils.getCoordinateAtPosition("c3")));
        assertTrue(t11.moveStatus().isFinished());
    }

    @Test
    public void testNoCastlingOutOfCheck() {
        final Board board = FenUtilities.createGameFromFEN("r3k2r/1pN1nppp/p3p3/3p4/8/8/PPPK1PPP/R6R b kq - 1 18");
        final Move illegalCastleMove = Move.MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e8"), BoardUtils.getCoordinateAtPosition("c8"));
        final MoveTransition t1 = board.currentPlayer().makeMove(illegalCastleMove);
        assertFalse(t1.moveStatus().isFinished());
    }
}