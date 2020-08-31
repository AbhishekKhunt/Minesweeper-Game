
public class Grid {

	private Cell[][] cells;
	private int numberOfBomb;

	public Grid(int numberOfRow, int numberOfCol) {
		cells = new Cell[numberOfRow][numberOfCol];
		numberOfBomb = (numberOfRow * numberOfCol) / 4;
	}

	public Cell[][] getCells() {
		return cells;
	}

	public int getNumberOfBomb() {
		return numberOfBomb;
	}

	void initGrid() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				cells[i][j] = new Cell();
			}

		}
	}

	public void updateGrid(int row, int col) {
		if (!cells[row][col].isFlag()) {
			if (isEmptyCell(row, col))
				openSurroundCells(row, col);
			else
				cells[row][col].setOpen(true);
		} else {
			System.err.println("This is flag cell");
		}

	}

	void setBombInGrid(int row, int col) {
		int positionOfRow, positionOfCol;

		System.out.println("There are " + numberOfBomb + " bomb in grid...");

		for (int i = 0; i < numberOfBomb; i++) {
			positionOfRow = Utility.generateRandomNumber(row);
			positionOfCol = Utility.generateRandomNumber(col);
			if (!isBombCell(positionOfRow, positionOfCol)) {
				cells[positionOfRow][positionOfCol].setBomb();
				cells[positionOfRow][positionOfCol].setBombInPosition(true);
			} else
				i--;

		}

	}

	void setValueInGrid() {

		for (int i = 0; i < cells.length; i++) {

			for (int j = 0; j < cells[0].length; j++) {
				if (!isBombCell(i, j))
					setValueInCell(i, j);
			}
		}
	}

	void setValueInCell(int row, int col) {

		int counter = 0;
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i >= 0 && j >= 0 && i < cells.length && j < cells[0].length) {
					if (isBombCell(i, j))
						counter++;

				}
			}
		}
		cells[row][col].setValue(counter);
	}

	void openSurroundCells(int row, int col) {

		cells[row][col].setOpen(true);

		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				if (i >= 0 && j >= 0 && i < cells.length && j < cells[0].length) {
					if (isEmptyCell(i, j) && !isBombCell(i, j) && !cells[i][j].isOpen())
						openSurroundCells(i, j);
					cells[i][j].setOpen(true);
				}
			}
		}
	}

	void setFlag(int row, int col) {
		if (!cells[row][col].isOpen()) {
			cells[row][col].setFlag(true);
			cells[row][col].setOpen(true);
		} else
			System.err.println("This is open cell");
	}

	void removeFlag(int row, int col) {
		if (cells[row][col].isFlag()) {
			cells[row][col].setFlag(false);
			cells[row][col].setOpen(false);
		} else
			System.err.println("This is not flag cell");
	}

	int countOpenCells() {
		int counter = 0;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j].isOpen())
					counter++;
			}
		}
		return counter;
	}

	int countFlagCells() {
		int counter = 0;
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				if (cells[i][j].isFlag())
					counter++;
			}
		}
		return counter;
	}

	boolean isBombCell(int row, int col) {

		return (cells[row][col].getBomb() == 'X');

	}

	boolean isEmptyCell(int row, int col) {

		return cells[row][col].getValue() == 0;

	}

	void openGrid() {

		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[0].length; j++) {
				cells[i][j].setOpen(true);
			}
		}
	}

	void printGrid() {
		System.out.println();
		System.out.print("     ");
		for (int i = 0; i < cells[0].length; i++) {
			System.out.print(i + "  ");
		}
		System.out.println();
		System.out.println();

		for (int i = 0; i < cells.length; i++) {
			System.out.print(i + "    ");
			for (int j = 0; j < cells[i].length; j++) {
				if (cells[i][j].isOpen()) {
					if (cells[i][j].isFlag())
						System.out.print("F  ");
					else if (cells[i][j].getBomb() == 'X')
						System.out.print(cells[i][j].getBomb() + "  ");
					else
						System.out.print(cells[i][j].getValue() + "  ");
				} else
					System.out.print("*  ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
