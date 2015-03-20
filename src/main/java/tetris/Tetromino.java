// Copyright (c) 2008-2015  Esko Luontola <www.orfjackal.net>
// You may use and modify this source code freely for personal non-commercial use.
// This source code may NOT be used as course material without prior written agreement.

package tetris;

public class Tetromino implements RotatableGrid {

    public static final Tetromino T_SHAPE = new Tetromino(4, "" +
            ".T.\n" +
            "TTT\n" +
            "...\n");
    public static final Tetromino L_SHAPE = new Tetromino(4, "" +
            "...\n" +
            "LLL\n" +
            "L..\n");
    public static final Tetromino J_SHAPE = new Tetromino(4, "" +
            "...\n" +
            "JJJ\n" +
            "..J\n");
    public static final Tetromino I_SHAPE = new Tetromino(2, "" +
            ".....\n" +
            ".....\n" +
            "IIII.\n" +
            ".....\n" +
            ".....\n");
    public static final Tetromino S_SHAPE = new Tetromino(2, "" +
            "...\n" +
            ".SS\n" +
            "SS.\n");
    public static final Tetromino Z_SHAPE = new Tetromino(2, "" +
            "...\n" +
            "ZZ.\n" +
            ".ZZ\n");
    public static final Tetromino O_SHAPE = new Tetromino(1, "" +
            ".OO\n" +
            ".OO\n" +
            "...\n");

    private final int currentOrientation;
    private final Piece[] orientations;

    public Tetromino(int orientationCount, String shape) {
        this.currentOrientation = 0;
        this.orientations = new Piece[orientationCount];
        Piece orientation = new Piece(shape);
        for (int i = 0; i < this.orientations.length; i++) {
            this.orientations[i] = orientation;
            orientation = orientation.rotateCW();
        }
    }

    private Tetromino(int currentOrientation, Piece[] orientations) {
        this.currentOrientation = (currentOrientation + orientations.length) % orientations.length;
        this.orientations = orientations;
    }

    @Override
    public Tetromino rotateCW() {
        return new Tetromino(currentOrientation + 1, orientations);
    }

    @Override
    public Tetromino rotateCCW() {
        return new Tetromino(currentOrientation - 1, orientations);
    }

    @Override
    public int rows() {
        return current().rows();
    }

    @Override
    public int columns() {
        return current().columns();
    }

    @Override
    public char cellAt(int row, int col) {
        return current().cellAt(row, col);
    }

    @Override
    public String toString() {
        return current().toString();
    }

    private Piece current() {
        return orientations[currentOrientation];
    }
}
