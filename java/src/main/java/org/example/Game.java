package org.example;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Game {

    private Set<Cell> aliveCells;

    public Game(Set<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

    public Set<Cell> getAliveCells() {
        return aliveCells;
    }

    public void start(int numberOfIterations) {
        for (int i = 0; i < numberOfIterations; i++) {
            nextIteration();
        }
    }

    private void nextIteration() {
        Set<Cell> cellsToReborn = aliveCells.stream()
                .flatMap(cell -> cell.calculatePossibleNeighbours().stream())
                .distinct()
                .filter(cell -> !aliveCells.contains(cell))
                .filter(cell -> calculateAliveNeighboursCount(cell) == 3)
                .collect(Collectors.toSet());


        Set<Cell> newAliveCells = aliveCells.stream()
                .filter(cell -> {
                    int count = calculateAliveNeighboursCount(cell);
                    return count == 2 || count == 3;
                })
                .collect(Collectors.toSet());

        aliveCells = Stream.concat(cellsToReborn.stream(), newAliveCells.stream()).collect(Collectors.toSet());
    }

    private int calculateAliveNeighboursCount(Cell cell) {
        Set<Cell> possibleNeighbours = cell.calculatePossibleNeighbours();
        possibleNeighbours.retainAll(aliveCells);
        return possibleNeighbours.size();
    }


    public boolean isCellAlive(Cell cell) {
        return aliveCells.contains(cell);
    }
}
