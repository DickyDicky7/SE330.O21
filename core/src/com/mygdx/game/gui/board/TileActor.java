package com.mygdx.game.gui.board;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.chess.engine.board.Board;
import com.mygdx.game.chess.engine.board.BoardUtils;
import com.mygdx.game.chess.engine.board.Move;
import com.mygdx.game.chess.engine.board.MoveTransition;
import com.mygdx.game.chess.engine.pieces.Piece;
import com.mygdx.game.gui.GuiUtils;
import com.mygdx.game.gui.gamescreen.GameScreen;

public final class TileActor extends Image {

    TileActor(final GameScreen gameScreen, final TextureRegion region, final int tileID) {
        super(region);
        this.setVisible(true);
        this.addListener(new ClickListener() {
            @Override
            public void clicked(final InputEvent event, final float x, final float y) {
                try {
                    super.clicked(event, x, y);
                    if (gameScreen.getGameBoard().isGameEnd() || gameScreen.getGameBoard().getArtificialIntelligenceWorking()) {
                        return;
                    }

                    if (gameScreen.getGameBoard().getHumanPiece() == null) {
                        gameScreen.getGameBoard().drawBoard(gameScreen, gameScreen.getChessBoard(), gameScreen.getDisplayOnlyBoard());
                        if (gameScreen.getChessBoard().getTile(tileID).getPiece().getLeague() == gameScreen.getChessBoard().currentPlayer().getLeague()) {
                            gameScreen.getGameBoard().updateHumanPiece(gameScreen.getChessBoard().getTile(tileID).getPiece());
                            if (gameScreen.getGameBoard().isHighlightMove()) {
                                gameScreen.getDisplayOnlyBoard().highlightLegalMove(gameScreen.getGameBoard(), gameScreen.getChessBoard());
                            }
                        }

                    } else {
                        if (gameScreen.getGameBoard().getHumanPiece().getLeague() == gameScreen.getChessBoard().currentPlayer().getLeague()) {
                            final Move move = Move.MoveFactory.createMove(gameScreen.getChessBoard(), gameScreen.getGameBoard().getHumanPiece(), tileID);
                            final MoveTransition transition = gameScreen.getChessBoard().currentPlayer().makeMove(move);
                            if (transition.moveStatus().isFinished()) {
                                gameScreen.getGameBoard().updateHumanPiece(null);
                                gameScreen.updateChessBoard(transition.latestBoard());
                                gameScreen.getGameBoard().updateAiMove(null);
                                gameScreen.getGameBoard().updateHumanMove(move);
                                if (move.isPromotionMove()) {
                                    //display pawn promotion interface
                                    new PawnPromotionInterface().startLibGDXPromotion(gameScreen, (Move.PawnPromotion) move);
                                } else {
                                    gameScreen.getGameBoard().drawBoard(gameScreen, gameScreen.getChessBoard(), gameScreen.getDisplayOnlyBoard());
                                    gameScreen.getMoveHistory().getMoveLog().addMove(move);
                                    gameScreen.getMoveHistory().updateMoveHistory();
                                    if (gameScreen.getGameBoard().isAIPlayer(gameScreen.getChessBoard().currentPlayer())) {
                                        gameScreen.getGameBoard().fireGameSetupPropertyChangeSupport();
                                    } else {
                                        gameScreen.getGameBoard().displayEndGameMessage(gameScreen.getChessBoard(), gameScreen.getStage());
                                    }
                                }
                            } else {
                                gameScreen.getGameBoard().updateHumanPiece(getPiece(gameScreen.getChessBoard(), gameScreen.getGameBoard().getHumanPiece(), tileID));
                                gameScreen.getGameBoard().drawBoard(gameScreen, gameScreen.getChessBoard(), gameScreen.getDisplayOnlyBoard());
                                if (getPiece(gameScreen.getChessBoard(), gameScreen.getGameBoard().getHumanPiece(), tileID) != null && gameScreen.getGameBoard().isHighlightMove()) {
                                    gameScreen.getDisplayOnlyBoard().highlightLegalMove(gameScreen.getGameBoard(), gameScreen.getChessBoard());
                                }
                            }
                        } else {
                            gameScreen.getGameBoard().drawBoard(gameScreen, gameScreen.getChessBoard(), gameScreen.getDisplayOnlyBoard());
                            gameScreen.getGameBoard().updateHumanPiece(null);
                        }
                    }
                } catch (final NullPointerException ignored) {
                }
            }
        });
    }

    private Piece getPiece(final Board chessBoard, final Piece humanPiece, final int tileID) {
        final Piece piece = chessBoard.getTile(tileID).getPiece();
        if (piece == null) {
            return null;
        }
        if (piece.getPiecePosition() == tileID && humanPiece.getLeague() == piece.getLeague()) {
            return piece;
        }
        return null;
    }

    protected static final class DisplayOnlyTile extends Image {

        private final int tileID;

        DisplayOnlyTile(final int tileID) {
            super(GuiUtils.GetTiledTextureRegion("white"));
            this.tileID = tileID;
            this.setVisible(true);
        }

        private Color getTileColor(final GuiUtils.TileColor TileColor) {
            if (BoardUtils.FIRST_ROW.get(this.tileID) || BoardUtils.THIRD_ROW.get(this.tileID) || BoardUtils.FIFTH_ROW.get(this.tileID) || BoardUtils.SEVENTH_ROW.get(this.tileID)) {
                return this.tileID % 2 == 0 ? TileColor.getLightTile() : TileColor.getUnlitTile();
            }
                return this.tileID % 2 != 0 ? TileColor.getLightTile() : TileColor.getUnlitTile();
        }

        private Color getHumanMoveColor(final GameBoard gameBoard, final GameBoard.DisplayOnlyBoard displayOnlyBoard) {
            if (this.tileID == gameBoard.getHumanMove().getCurrentCoordinate()) {
                return GuiUtils.HUMAN_PREVIOUS_TILE;
            } else if (this.tileID == gameBoard.getHumanMove().getDestinationCoordinate()) {
                return GuiUtils.HUMAN_CURRENT_TILE;
            }
            return this.getTileColor(displayOnlyBoard.getTileColor());
        }

        private Color getAIMoveColor(final GameBoard gameBoard, final GameBoard.DisplayOnlyBoard displayOnlyBoard) {
            if (this.tileID == gameBoard.getAiMove().getCurrentCoordinate()) {
                return GuiUtils.AI_PREVIOUS_TILE;
            } else if (this.tileID == gameBoard.getAiMove().getDestinationCoordinate()) {
                return GuiUtils.AI_CURRENT_TILE;
            }
            return this.getTileColor(displayOnlyBoard.getTileColor());
        }

        public void repaint(final GameBoard gameBoard, final Board chessBoard, final GameBoard.DisplayOnlyBoard displayOnlyBoard) {
            if (chessBoard.currentPlayer().isInCheck() && chessBoard.currentPlayer().getPlayerKing().getPiecePosition() == this.tileID) {
                this.setColor(Color.RED);
            } else if (gameBoard.getHumanMove() != null && gameBoard.isHighlightPreviousMove()) {
                this.setColor(this.getHumanMoveColor(gameBoard, displayOnlyBoard));
            } else if (gameBoard.getAiMove() != null && gameBoard.isHighlightPreviousMove()) {
                this.setColor(this.getAIMoveColor(gameBoard, displayOnlyBoard));
            } else {
                this.setColor(this.getTileColor(displayOnlyBoard.getTileColor()));
            }
        }
    }
}