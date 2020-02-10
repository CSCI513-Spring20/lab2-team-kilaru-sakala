import java.awt.Point;

public class Ship {
	int xCell;
	int yCell;

	public Ship(int x, int y) {

		xCell = x;
		yCell = y;
	}

	public void goEast() {
		if (xCell != 9) {
			xCell++;
		}
	}

	public void goWest() {
		if (xCell != 0) {
			xCell--;
		}
	}

	public void goNorth() {
		if (yCell != 0) {
			yCell--;
		}
	}

	public void goSouth() {
		if (yCell != 9) {
			yCell++;
		}
	}
	public Point getShipLocation() {
		return new Point(xCell, yCell);
	}

}