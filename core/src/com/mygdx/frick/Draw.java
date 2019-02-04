package com.mygdx.frick;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Draw {

    public static void BoardDraw(Board board, SpriteBatch batch) {


        for (int i = 0; i < board.getWidth; i++) {
            for ( int j = 0; j < board.getHeight; j++) {

                Tile tile=board.get(i,j);
               if (!tile.isEmpty())



            }

        }


    }
}
