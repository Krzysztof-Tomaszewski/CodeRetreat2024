import java.util.stream.Collectors
import java.util.stream.Stream

internal class Game(private var aliveCells: Set<Cell>) {

    fun getAliveCells(): Set<Cell> {
        return aliveCells
    }

    fun start(numberOfIterations: Int) {
        for (i in 0..<numberOfIterations) {
            nextIteration()
        }
    }

    private fun nextIteration() {
        val cellsToReborn: Set<Cell> = aliveCells.stream()
            .flatMap { cell: Cell ->
                cell.calculatePossibleNeighbours().stream()
            }
            .distinct()
            .filter { cell: Cell -> !aliveCells.contains(cell) }
            .filter { cell: Cell -> calculateAliveNeighboursCount(cell) == 3 }
            .collect(Collectors.toSet())

        val newAliveCells: Set<Cell> = aliveCells.stream()
            .filter { cell: Cell ->
                val count = calculateAliveNeighboursCount(cell)
                count == 2 || count == 3
            }
            .collect(Collectors.toSet())
        
        aliveCells = Stream.concat(cellsToReborn.stream(), newAliveCells.stream())
            .collect(Collectors.toSet())
    }

    private fun calculateAliveNeighboursCount(cell: Cell): Int {
        val possibleNeighbours: MutableSet<Cell> = cell.calculatePossibleNeighbours().toMutableSet()
        possibleNeighbours.retainAll(aliveCells)
        return possibleNeighbours.size
    }

    fun isCellAlive(cell: Cell): Boolean {
        return aliveCells.contains(cell)
    }


    fun main(args: Array<String>) {}
}
