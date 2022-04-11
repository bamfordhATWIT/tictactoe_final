package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class LineGrid {
	int w = 600;
	int h = 600;

	public LineGrid(int w, int h) {
		super();
		this.w = w;
		this.h = h;
	}

	public ArrayList<Line> grid() {

		ArrayList<Line> ls = new ArrayList<Line>(4);

		// vertical lines, startX, startY, endX, endY
		Line line1 = new Line(w / 3, 0, w / 3, h);
		Line line2 = new Line(2 * w / 3, 0, 2 * w / 3, h);

		// horizontal lines
		Line line3 = new Line(0, h / 3, w, h / 3);
		Line line4 = new Line(0, 2 * h / 3, w, 2 * h / 3);

		ls.add(line1);
		ls.add(line2);
		ls.add(line3);
		ls.add(line4);

		return ls;
	}

}