
public class Cell {

	private int value;
	private char bomb;
	private boolean isOpen;
	private boolean isBombInPosition;
	private boolean isFlag;

	public boolean isBombInPosition() {
		return isBombInPosition;
	}

	public void setBombInPosition(boolean isBombInPosition) {
		this.isBombInPosition = isBombInPosition;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public char getBomb() {
		return bomb;
	}

	public void setBomb() {
		this.bomb = 'X';
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isFlag() {
		return isFlag;
	}

	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}
}
