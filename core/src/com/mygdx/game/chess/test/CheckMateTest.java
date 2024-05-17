package com.mygdx.game.chess.test;

import static com.mygdx.game.chess.engine.board.Move.MoveFactory;
import static org.testng.Assert.assertTrue;

import com.mygdx.game.chess.engine.board.Board;
import com.mygdx.game.chess.engine.board.BoardUtils;
import com.mygdx.game.chess.engine.board.MoveTransition;

import org.junit.Test;

public final class CheckMateTest {

    @Test
    public void testFoolsMate() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "f2"), BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "g2"), BoardUtils.getCoordinateAtPosition("g4")));

        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d8"), BoardUtils.getCoordinateAtPosition("h4")));

        assertTrue(t4.moveStatus().isFinished());

        assertTrue(t4.latestBoard().currentPlayer().isInCheckmate());

    }

    @Test
    public void testScholarsMate() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "a7"), BoardUtils.getCoordinateAtPosition("a6")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "d1"), BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t3.moveStatus().isFinished());
        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "a6"), BoardUtils.getCoordinateAtPosition("a5")));

        assertTrue(t4.moveStatus().isFinished());

        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("c4")));

        assertTrue(t5.moveStatus().isFinished());

        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "a5"), BoardUtils.getCoordinateAtPosition("a4")));

        assertTrue(t6.moveStatus().isFinished());

        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "f3"), BoardUtils.getCoordinateAtPosition("f7")));

        assertTrue(t7.moveStatus().isFinished());
        assertTrue(t7.latestBoard().currentPlayer().isInCheckmate());

    }

    @Test
    public void testLegalsMate() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("c4")));

        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t4.moveStatus().isFinished());

        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "g1"), BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t5.moveStatus().isFinished());

        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "c8"), BoardUtils.getCoordinateAtPosition("g4")));

        assertTrue(t6.moveStatus().isFinished());

        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "b1"), BoardUtils.getCoordinateAtPosition("c3")));

        assertTrue(t7.moveStatus().isFinished());

        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "g7"), BoardUtils.getCoordinateAtPosition("g6")));

        assertTrue(t8.moveStatus().isFinished());

        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "f3"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t9.moveStatus().isFinished());

        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "g4"), BoardUtils.getCoordinateAtPosition("d1")));

        assertTrue(t10.moveStatus().isFinished());

        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "c4"), BoardUtils.getCoordinateAtPosition("f7")));

        assertTrue(t11.moveStatus().isFinished());

        final MoveTransition t12 = t11.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t11.latestBoard(), BoardUtils.getPieceAtPosition(t11.latestBoard(), "e8"), BoardUtils.getCoordinateAtPosition("e7")));

        assertTrue(t12.moveStatus().isFinished());

        final MoveTransition t13 = t12.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t12.latestBoard(), BoardUtils.getPieceAtPosition(t12.latestBoard(), "c3"), BoardUtils.getCoordinateAtPosition("d5")));

        assertTrue(t13.moveStatus().isFinished());
        assertTrue(t13.latestBoard().currentPlayer().isInCheckmate());
    }

    @Test
    public void testSevenMoveMate() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "d2"), BoardUtils.getCoordinateAtPosition("d4")));

        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t4.moveStatus().isFinished());

        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "d4"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t5.moveStatus().isFinished());

        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "d8"), BoardUtils.getCoordinateAtPosition("e7")));

        assertTrue(t6.moveStatus().isFinished());

        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "e5"), BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t7.moveStatus().isFinished());

        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t8.moveStatus().isFinished());

        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("e2")));

        assertTrue(t9.moveStatus().isFinished());

        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "e4"), BoardUtils.getCoordinateAtPosition("g2")));

        assertTrue(t10.moveStatus().isFinished());

        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "d6"), BoardUtils.getCoordinateAtPosition("c7")));

        assertTrue(t11.moveStatus().isFinished());

        final MoveTransition t12 = t11.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t11.latestBoard(), BoardUtils.getPieceAtPosition(t11.latestBoard(), "g2"), BoardUtils.getCoordinateAtPosition("h1")));

        assertTrue(t12.moveStatus().isFinished());

        final MoveTransition t13 = t12.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t12.latestBoard(), BoardUtils.getPieceAtPosition(t12.latestBoard(), "d1"), BoardUtils.getCoordinateAtPosition("d8")));

        assertTrue(t13.moveStatus().isFinished());
        assertTrue(t13.latestBoard().currentPlayer().isInCheckmate());

    }

    @Test
    public void testGrecoGame() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "d2"), BoardUtils.getCoordinateAtPosition("d4")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "g8"), BoardUtils.getCoordinateAtPosition("f6")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "b1"), BoardUtils.getCoordinateAtPosition("d2")));

        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t4.moveStatus().isFinished());

        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "d4"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t5.moveStatus().isFinished());

        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "f6"), BoardUtils.getCoordinateAtPosition("g4")));

        assertTrue(t6.moveStatus().isFinished());

        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "h2"), BoardUtils.getCoordinateAtPosition("h3")));

        assertTrue(t7.moveStatus().isFinished());

        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "g4"), BoardUtils.getCoordinateAtPosition("e3")));

        assertTrue(t8.moveStatus().isFinished());

        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "f2"), BoardUtils.getCoordinateAtPosition("e3")));

        assertTrue(t9.moveStatus().isFinished());

        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "d8"), BoardUtils.getCoordinateAtPosition("h4")));

        assertTrue(t10.moveStatus().isFinished());

        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "g2"), BoardUtils.getCoordinateAtPosition("g3")));

        assertTrue(t11.moveStatus().isFinished());

        final MoveTransition t12 = t11.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t11.latestBoard(), BoardUtils.getPieceAtPosition(t11.latestBoard(), "h4"), BoardUtils.getCoordinateAtPosition("g3")));

        assertTrue(t12.moveStatus().isFinished());
        assertTrue(t12.latestBoard().currentPlayer().isInCheckmate());

    }

    @Test
    public void testOlympicGame() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "c7"), BoardUtils.getCoordinateAtPosition("c6")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "g1"), BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "d7"), BoardUtils.getCoordinateAtPosition("d5")));

        assertTrue(t4.moveStatus().isFinished());

        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "b1"), BoardUtils.getCoordinateAtPosition("c3")));

        assertTrue(t5.moveStatus().isFinished());

        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "d5"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t6.moveStatus().isFinished());

        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "c3"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t7.moveStatus().isFinished());

        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "b8"), BoardUtils.getCoordinateAtPosition("d7")));

        assertTrue(t8.moveStatus().isFinished());

        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "d1"), BoardUtils.getCoordinateAtPosition("e2")));

        assertTrue(t9.moveStatus().isFinished());

        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "g8"), BoardUtils.getCoordinateAtPosition("f6")));

        assertTrue(t10.moveStatus().isFinished());

        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "e4"), BoardUtils.getCoordinateAtPosition("d6")));

        assertTrue(t11.moveStatus().isFinished());
        assertTrue(t11.latestBoard().currentPlayer().isInCheckmate());

    }

    @Test
    public void testAnotherGame() {

        final Board board = Board.createStandardBoard(BoardUtils.DEFAULT_TIMER_MINUTE, BoardUtils.DEFAULT_TIMER_SECOND, BoardUtils.DEFAULT_TIMER_MILLISECOND);
        final MoveTransition t1 = board.currentPlayer().makeMove(MoveFactory.createMove(board, BoardUtils.getPieceAtPosition(board, "e2"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t1.moveStatus().isFinished());

        final MoveTransition t2 = t1.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t1.latestBoard(), BoardUtils.getPieceAtPosition(t1.latestBoard(), "e7"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t2.moveStatus().isFinished());

        final MoveTransition t3 = t2.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t2.latestBoard(), BoardUtils.getPieceAtPosition(t2.latestBoard(), "g1"), BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t3.moveStatus().isFinished());

        final MoveTransition t4 = t3.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t3.latestBoard(), BoardUtils.getPieceAtPosition(t3.latestBoard(), "b8"), BoardUtils.getCoordinateAtPosition("c6")));

        assertTrue(t4.moveStatus().isFinished());

        final MoveTransition t5 = t4.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t4.latestBoard(), BoardUtils.getPieceAtPosition(t4.latestBoard(), "f1"), BoardUtils.getCoordinateAtPosition("c4")));

        assertTrue(t5.moveStatus().isFinished());

        final MoveTransition t6 = t5.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t5.latestBoard(), BoardUtils.getPieceAtPosition(t5.latestBoard(), "c6"), BoardUtils.getCoordinateAtPosition("d4")));

        assertTrue(t6.moveStatus().isFinished());

        final MoveTransition t7 = t6.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t6.latestBoard(), BoardUtils.getPieceAtPosition(t6.latestBoard(), "f3"), BoardUtils.getCoordinateAtPosition("e5")));

        assertTrue(t7.moveStatus().isFinished());

        final MoveTransition t8 = t7.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t7.latestBoard(), BoardUtils.getPieceAtPosition(t7.latestBoard(), "d8"), BoardUtils.getCoordinateAtPosition("g5")));

        assertTrue(t8.moveStatus().isFinished());

        final MoveTransition t9 = t8.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t8.latestBoard(), BoardUtils.getPieceAtPosition(t8.latestBoard(), "e5"), BoardUtils.getCoordinateAtPosition("f7")));

        assertTrue(t9.moveStatus().isFinished());

        final MoveTransition t10 = t9.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t9.latestBoard(), BoardUtils.getPieceAtPosition(t9.latestBoard(), "g5"), BoardUtils.getCoordinateAtPosition("g2")));

        assertTrue(t10.moveStatus().isFinished());

        final MoveTransition t11 = t10.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t10.latestBoard(), BoardUtils.getPieceAtPosition(t10.latestBoard(), "h1"), BoardUtils.getCoordinateAtPosition("f1")));

        assertTrue(t11.moveStatus().isFinished());

        final MoveTransition t12 = t11.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t11.latestBoard(), BoardUtils.getPieceAtPosition(t11.latestBoard(), "g2"), BoardUtils.getCoordinateAtPosition("e4")));

        assertTrue(t12.moveStatus().isFinished());

        final MoveTransition t13 = t12.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t12.latestBoard(), BoardUtils.getPieceAtPosition(t12.latestBoard(), "c4"), BoardUtils.getCoordinateAtPosition("e2")));

        assertTrue(t13.moveStatus().isFinished());

        final MoveTransition t14 = t13.latestBoard().currentPlayer().makeMove(MoveFactory.createMove(t13.latestBoard(), BoardUtils.getPieceAtPosition(t13.latestBoard(), "d4"), BoardUtils.getCoordinateAtPosition("f3")));

        assertTrue(t14.moveStatus().isFinished());
        assertTrue(t14.latestBoard().currentPlayer().isInCheckmate());

    }
}