package org.example;

import java.util.HashSet;
import java.util.Set;

record Cell(
        int x,
        int y
) {

    boolean isNeighbour(Cell anotherCell) {
        return Math.abs(x - anotherCell.x) == 1 || Math.abs(y - anotherCell.y) == 1;
    }

    Set<Cell> calculatePossibleNeighbours() {
        Set<Cell> possibleNeighbours = new HashSet<>();
        for (int i = y-1; i <= y+1; i++) {
            for (int j = x-1; j <= x+1; j++) {
                if (i != y || j != x) {
                    possibleNeighbours.add(new Cell(j, i));
                }
            }
        }
        return possibleNeighbours;
    }
}
