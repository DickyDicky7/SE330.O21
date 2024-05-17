package com.mygdx.game.chess.engine.board;

public record MoveTransition(Board latestBoard, Board previousBoard, MoveStatus moveStatus) {

}
