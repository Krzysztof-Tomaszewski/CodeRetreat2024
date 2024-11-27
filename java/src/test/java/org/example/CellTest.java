package org.example;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void shouldTellThatCellIsNeighourToAnother() {
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,1);

        boolean result = cell1.isNeighbour(cell2);

        assertTrue(result);
    }

    @Test
    void shouldTellThatCellIsNotNeighourToAnother() {
        Cell cell1 = new Cell(0,0);
        Cell cell2 = new Cell(0,2);

        boolean result = cell1.isNeighbour(cell2);

        assertFalse(result);
    }

    @Test
    void shouldReturnAllPossibleNeighoursForCell() {
        Cell cell = new Cell(1,1);

        Set<Cell> possibleNeighbours = Set.of(
                new Cell(0, 0),
                new Cell(1, 0),
                new Cell(2, 0),
                new Cell(0, 1),
                new Cell(2, 1),
                new Cell(0, 2),
                new Cell(1, 2),
                new Cell(2, 2)
        );

        Set<Cell> result = cell.calculatePossibleNeighbours();

        Assertions.assertThat(result)
                .containsExactlyInAnyOrderElementsOf(possibleNeighbours);
    }
}