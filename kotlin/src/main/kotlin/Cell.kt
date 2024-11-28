
internal data class Cell(val x: Int, val y: Int) {

    fun calculatePossibleNeighbours(): Set<Cell> {
        val possibleNeighbours: MutableSet<Cell> = HashSet()
        for (i in y - 1..y + 1) {
            for (j in x - 1..x + 1) {
                if (i != y || j != x) {
                    possibleNeighbours.add(Cell(j, i))
                }
            }
        }
        return possibleNeighbours
    }
}
