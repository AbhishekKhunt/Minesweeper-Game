
public class WinConditionRules {
	private Cell cells[][];
	private int numberOfBomb;

	public boolean isGameOver(Grid grid, int row, int col) {
		cells = grid.getCells();
		numberOfBomb = grid.getNumberOfBomb();
		int numberOfCellInGrid = (cells.length * cells[0].length);

		if (!cells[row][col].isFlag() && grid.isBombCell(row, col)) {
			System.err.println("Boom....GAME OVER....");
			return true;
		}
		if (isWinGame(grid,numberOfCellInGrid)) {
			System.err.println("Wohoo....You are winner!! Congratulations...");
			return true;
		}

		return false;
	}

	boolean isWinGame(Grid grid,int numberOfCellInGrid) {
		return ((numberOfBomb == grid.countFlagCells() && grid.countOpenCells() == numberOfCellInGrid)
				|| (numberOfBomb == numberOfCellInGrid - grid.countOpenCells()));
	}

	

	

}
