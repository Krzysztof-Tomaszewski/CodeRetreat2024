import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GameTest {
    @Test
    fun oneCell_shouldDie() {
        val cell = Cell(0, 0)
        val game = Game(setOf(cell))

        game.start(1)
        val result = game.isCellAlive(cell)

        assertFalse(result)
    }

    @Test
    fun cellWithFourNeighbours_shouldDie() {
        val cell = Cell(1, 1)
        val game = Game(
            setOf(
                cell,
                Cell(0, 0),
                Cell(0, 1),
                Cell(2, 1),
                Cell(2, 2)
            )
        )

        game.start(1)
        val result = game.isCellAlive(cell)

        assertFalse(result)
    }

    @Test
    fun cellWithExactlyTwoNeighbours_shouldBeAlive() {
        val cell = Cell(1, 1)
        val game = Game(
            setOf(
                cell,
                Cell(0, 0),
                Cell(0, 1)
            )
        )

        game.start(1)
        val result = game.isCellAlive(cell)

        assertTrue(result)
    }

    @Test
    fun cellWithExactlyThreeNeighbours_shouldBeAlive() {
        val cell = Cell(1, 1)
        val game = Game(
            setOf(
                cell,
                Cell(0, 0),
                Cell(0, 1),
                Cell(2, 2)
            )
        )

        game.start(1)
        val result = game.isCellAlive(cell)

        assertTrue(result)
    }

    @Test
    fun emptyCellWithExactlyThreeNeighbours_shouldBeAlive() {
        val cell = Cell(1, 1)
        val game = Game(
            setOf(
                Cell(0, 0),
                Cell(0, 1),
                Cell(2, 2)
            )
        )

        game.start(1)
        val result = game.isCellAlive(cell)

        assertTrue(result)
    }

    @Test
    fun twoCells_shouldAllDie() {
        val cell1 = Cell(0, 0)
        val cell2 = Cell(1, 0)
        val game = Game(setOf(cell1, cell2))

        game.start(1)
        val aliveCellsCount: Int = game.getAliveCells().size

        assertThat(aliveCellsCount).isZero()
    }

    @Test
    fun shouldChangeToDifferentStructureAfter10Iterations() {
        val game = Game(
            setOf(
                Cell(0, 0),
                Cell(0, 1),
                Cell(-1, 0),
                Cell(1, 0),
                Cell(0, -1)
            )
        )

        game.start(10)
        val aliveCells : MutableSet<Cell> = game.getAliveCells().toMutableSet()

        assertThat(aliveCells)
            .containsExactlyInAnyOrder(
                Cell(3, -1),
                Cell(3, 0),
                Cell(3, 1),

                Cell(-3, -1),
                Cell(-3, 0),
                Cell(-3, 1),

                Cell(-1, 3),
                Cell(0, 3),
                Cell(1, 3),

                Cell(-1, -3),
                Cell(0, -3),
                Cell(1, -3)
            )
    }
}