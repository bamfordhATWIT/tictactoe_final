package application;

import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class WinCondition {


	public boolean win(ArrayList<ImageView> cover, ArrayList<ImageView> list) {
//checks horizontals
		if (test3Spots(0, 1, 2, cover, list)) {
			return true;
		} else if (test3Spots(3, 4, 5, cover, list)) {
			return true;
		} else if (test3Spots(6, 7, 8, cover, list)) {
			return true;
		}

// checks verticals
		else if (test3Spots(0, 3, 6, cover, list)) {
			return true;
		} else if (test3Spots(1, 4, 7, cover, list)) {
			return true;
		} else if (test3Spots(2, 5, 8, cover, list)) {
			return true;
		}

// checks diagonals
		else if (test3Spots(0, 4, 8, cover, list)) {
			return true;
		} else if (test3Spots(2, 4, 6, cover, list)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean test3Spots(int a, int b, int c, ArrayList<ImageView> cover, ArrayList<ImageView> list) {
		if (!cover.get(a).isVisible() && !cover.get(b).isVisible() && !cover.get(c).isVisible()) { //if the right cover images are gone
			if (list.get(a).isVisible() && list.get(b).isVisible() && list.get(c).isVisible()) { //if the right pieces are visible
				return true;
			}
		}
		return false;
	}
}
