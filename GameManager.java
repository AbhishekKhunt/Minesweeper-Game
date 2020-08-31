
public class GameManager {

	private Grid grid;
	private WinConditionRules winConditionRules;

	void initGame(int numberOfRows, int numberOfCols) {
		grid = new Grid(numberOfRows, numberOfCols);
		grid.initGrid();
		grid.setBombInGrid(numberOfRows, numberOfCols);
		grid.setValueInGrid();
		grid.printGrid();
		winConditionRules = new WinConditionRules();

	}

	void startGame() {

		int numberOfRows = Utility.getInt("Enter number of row:-");
		int numberOfCols = Utility.getInt("Enter number of col:-");
		int row, col;
		initGame(numberOfRows, numberOfCols);

		while (true) {
			System.out.println("1.set flag");
			System.out.println("2.remove flag");
			System.out.println("3.open cell");
			int choice = Utility.getInt("enter choice number:- ");

			row = Utility.getInt("Enter row index:-");
			col = Utility.getInt("Enter col index:-");

			if (isInputValid(row, col, numberOfRows, numberOfCols, choice)) {

				switch (choice) {
				case 1:
					grid.setFlag(row, col);
					break;

				case 2:
					grid.removeFlag(row, col);
					break;

				case 3:
					grid.updateGrid(row, col);
					break;
				}
				if (choice != 2 && winConditionRules.isGameOver(grid, row, col)) {
					grid.openGrid();
					grid.printGrid();
					break;
				}
			} else
				System.err.println("invalid input");
			grid.printGrid();

		}
	}

	boolean isInputValid(int row, int col, int numberOfRows, int numberOfCols, int choice) {
		if (row < numberOfRows && col < numberOfCols && choice >= 1 && choice <= 3)
			return true;
		return false;
	}

}
