package com.mygdx.game.chess.engine.board;

public enum MoveStatus {

    DONE {
        @Override
        public boolean isFinished() {
            return true;
        }
    },
    ILLEGAL_MOVE {
        @Override
        public boolean isFinished() {
            return false;
        }
    },
    LEAVING_PLAYER_IN_CHECK {
        @Override
        public boolean isFinished() {
            return false;
        }
    };

    public abstract boolean isFinished();
}
