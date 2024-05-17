package com.mygdx.game.chess.test;

import static com.mygdx.game.chess.engine.board.Board.Builder;
import static com.mygdx.game.chess.engine.board.Move.MoveFactory;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import com.mygdx.game.chess.engine.League;
import com.mygdx.game.chess.engine.board.Board;
import com.mygdx.game.chess.engine.board.BoardUtils;
import com.mygdx.game.chess.engine.board.Move;
import com.mygdx.game.chess.engine.board.MoveTransition;
import com.mygdx.game.chess.engine.pieces.Bishop;
import com.mygdx.game.chess.engine.pieces.King;
import com.mygdx.game.chess.engine.pieces.Rook;
import com.mygdx.game.chess.engine.player.artificialintelligence.StandardBoardEvaluation;

import org.junit.Test;

public final class PlayerTest {
    final StandardBoardEvaluation standardBoardEvaluation = new StandardBoardEvaluation();

    @Test
    public void testSimpleEvaluation() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));
        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t2.moveStatus().isFinished());

        assertEquals(this.standardBoardEvaluation.evaluate(t2.latestBoard(), 0), 0);
    }

    @Test
    public void testBug() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "c2"), BoardUtils.getCoordinateAtPosition("c3")));
        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "b8"), BoardUtils.getCoordinateAtPosition("a6")));
        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "d1"), BoardUtils.getCoordinateAtPosition("a4")));
        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d6")));
        assertFalse(t4.moveStatus().isFinished());
    }

    @Test
    public void testDiscoveredCheck() {
        final Builder builder = new Builder(0, League.WHITE, null);
        // Black Layout
        builder.setPiece(new King(League.BLACK, 4, false, false));
        builder.setPiece(new Rook(League.BLACK, 24));
        // White Layout
        builder.setPiece(new Bishop(League.WHITE, 44));
        builder.setPiece(new Rook(League.WHITE, 52));
        builder.setPiece(new King(League.WHITE, 58, false, false));
        final Board board = builder.build();
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e3"), BoardUtils.getCoordinateAtPosition("b6")));
        assertTrue(t1.moveStatus().isFinished());
        assertTrue(t1.latestBoard().currentPlayer().isInCheck());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "a5"), BoardUtils.getCoordinateAtPosition("b5")));
        assertFalse(t2.moveStatus().isFinished());

        final MoveTransition t3 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "a5"), BoardUtils.getCoordinateAtPosition("e5")));
        assertTrue(t3.moveStatus().isFinished());
    }

    @Test
    public void testUnmakeMove() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final Move m1 = MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4"));
        final MoveTransition t1 = board.currentPlayer().makeMove(m1);
        assertTrue(t1.moveStatus().isFinished());
        t1.latestBoard().currentPlayer().getOpponent().undoMove(m1);
    }

    @Test
    public void testIllegalMove() {
        final Board board = Board.createStandardBoardWithDefaultTimer();
        final Move m1 = MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e6"));
        final MoveTransition t1 = board.currentPlayer().makeMove(m1);
        assertFalse(t1.moveStatus().isFinished());
    }
}
