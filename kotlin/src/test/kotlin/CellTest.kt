import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CellTest {

    @Test
    fun shouldReturnAllPossibleNeighboursForCell() {
        val cell = Cell(1, 1)
        val possibleNeighbours = setOf(
            Cell(0, 0),
            Cell(1, 0),
            Cell(2, 0),
            Cell(0, 1),
            Cell(2, 1),
            Cell(0, 2),
            Cell(1, 2),
            Cell(2, 2)
        )

        val result = cell.calculatePossibleNeighbours()

        assertThat(result)
            .containsExactlyInAnyOrderElementsOf(possibleNeighbours)
    }
}