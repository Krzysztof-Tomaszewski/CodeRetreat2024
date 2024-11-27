package org.example;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void oneCell_shouldDie() {
        Cell cell = new Cell(0, 0);
        Game game = new Game(Set.of(cell));

        game.start(1);
        boolean result = game.isCellAlive(cell);

        assertFalse(result);
    }

    @Test
    void cellWithFourNeighbours_shouldDie() {
        Cell cell = new Cell(1, 1);
        Game game = new Game(Set.of(
                cell,
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(2, 1),
                new Cell(2, 2)
        ));

        game.start(1);
        boolean result = game.isCellAlive(cell);

        assertFalse(result);
    }

    @Test
    void cellWithExactlyTwoNeighbours_shouldBeAlive() {
        Cell cell = new Cell(1, 1);
        Game game = new Game(Set.of(
                cell,
                new Cell(0, 0),
                new Cell(0, 1)
        ));

        game.start(1);
        boolean result = game.isCellAlive(cell);

        assertTrue(result);
    }

    @Test
    void cellWithExactlyThreeNeighbours_shouldBeAlive() {
        Cell cell = new Cell(1, 1);
        Game game = new Game(Set.of(cell,
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(2, 2)
        ));

        game.start(1);
        boolean result = game.isCellAlive(cell);

        assertTrue(result);
    }

    @Test
    void emptyCellWithExactlyThreeNeighbours_shouldBeAlive() {
        Cell cell = new Cell(1, 1);
        Game game = new Game(Set.of(
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(2, 2)
        ));

        game.start(1);
        boolean result = game.isCellAlive(cell);

        assertTrue(result);
    }

    @Test
    void twoCells_shouldAllDie() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(1, 0);
        Game game = new Game(Set.of(cell1, cell2));

        game.start(1);
        int aliveCells = game.getAliveCells().size();

        assertThat(aliveCells).isZero();
    }

    @Test
    void shouldChangeToDifferentStructureAfter10Iterations() {
        Game game = new Game(Set.of(
                new Cell(0, 0),
                new Cell(0, 1),
                new Cell(-1, 0),
                new Cell(1, 0),
                new Cell(0, -1)
        ));

        game.start(10);
        Set<Cell> aliveCells = game.getAliveCells();

        assertThat(aliveCells)
                .hasSize(12)
                .containsExactlyInAnyOrder(
                        new Cell(3, -1),
                        new Cell(3, 0),
                        new Cell(3, 1),

                        new Cell(-3, -1),
                        new Cell(-3, 0),
                        new Cell(-3, 1),

                        new Cell(-1, 3),
                        new Cell(0, 3),
                        new Cell(1, 3),

                        new Cell(-1, -3),
                        new Cell(0, -3),
                        new Cell(1, -3)
                );
    }
}