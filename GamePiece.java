package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GamePiece /* implements EventHandler<MouseEvent> */ {

	private int tileSize = 100;
	ArrayList<ImageView> xArray = new ArrayList<>(9);
	ArrayList<ImageView> oArray = new ArrayList<>(9);
	int clickCount = 0;
	boolean hideImgs = false;

	public GamePiece(int tileSize) {
		super();
		this.tileSize = tileSize;
	}

	public ArrayList<ImageView> imgSetup(String s) throws FileNotFoundException {
		// Creating an image
		Image x1 = new Image(new FileInputStream(s));
		Image x2 = new Image(new FileInputStream(s));
		Image x3 = new Image(new FileInputStream(s));

		Image x4 = new Image(new FileInputStream(s));
		Image x5 = new Image(new FileInputStream(s));
		Image x6 = new Image(new FileInputStream(s));

		Image x7 = new Image(new FileInputStream(s));
		Image x8 = new Image(new FileInputStream(s));
		Image x9 = new Image(new FileInputStream(s));

		// Setting the image view
		ImageView imageView1 = new ImageView(x1);
		ImageView imageView2 = new ImageView(x2);
		ImageView imageView3 = new ImageView(x3);

		ImageView imageView4 = new ImageView(x4);
		ImageView imageView5 = new ImageView(x5);
		ImageView imageView6 = new ImageView(x6);

		ImageView imageView7 = new ImageView(x7);
		ImageView imageView8 = new ImageView(x8);
		ImageView imageView9 = new ImageView(x9);

		ArrayList<ImageView> imgArray = new ArrayList<ImageView>(9);
		imgArray.add(imageView1);
		imgArray.add(imageView2);
		imgArray.add(imageView3);

		imgArray.add(imageView4);
		imgArray.add(imageView5);
		imgArray.add(imageView6);

		imgArray.add(imageView7);
		imgArray.add(imageView8);
		imgArray.add(imageView9);

		return imgArray;
	}

	public Group placeImgs() throws FileNotFoundException {
		String xFileName = "/Users/Henry/Desktop/please sort this/sunset pic.png";
		String oFileName = "/Users/Henry/Desktop/please sort this/a04.png";

		/*
		 * if (clicks == 0) { xFileName = oFileName; }
		 */
		// oArray = imgSetup(oFileName);
		xArray = imgSetup(xFileName);

//		if (hideImgs == false) {
//			for (int i = 0; i < xArray.size(); i++) {
//				xArray.get(i).setVisible(false);
//			}
//			hideImgs = true;
//		}

		Group root = new Group();

		int x = 0;
		int y = 0;
		for (int i = 0; i < xArray.size(); i++) {
			x = i % 3;
			y = i / 3;

			/*
			 * if (clicks % 2 == 0) { xArray.get(i).setVisible(false); } else {
			 * xArray.get(i).setVisible(true); }
			 */

			xArray.get(i).setX(x * tileSize);
			xArray.get(i).setY(y * tileSize);

			xArray.get(i).setFitHeight(tileSize);
			xArray.get(i).setFitWidth(tileSize);

			root.getChildren().add(xArray.get(i));
		}

		root.addEventHandler(MouseEvent.ANY, new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent mouseEvent) {
				double mouseX = mouseEvent.getX();
				double mouseY = mouseEvent.getY();
				
				System.out.println(hideImgs);
				
				for (int i = 0; i < gridSpotTracker(mouseX, mouseY).size(); i++) {
					if (mouseEvent.getClickCount() != 0) {
						if (gridSpotTracker(mouseX, mouseY).get(i) == true) {
							xArray.get(i).setVisible(false);
						}
					}
				}
			}

		});

		return root;
	}

	public ArrayList<Boolean> gridSpotTracker(double mX, double mY) {
		int x = 0;
		int y = 0;
		ArrayList<Boolean> spots = new ArrayList<>(9);
		
		boolean spot1 = false;
		boolean spot2 = false;
		boolean spot3 = false;
		boolean spot4 = false;
		boolean spot5 = false;
		boolean spot6 = false;
		boolean spot7 = false;
		boolean spot8 = false;
		boolean spot9 = false;

		spots.add(spot1);
		spots.add(spot2);
		spots.add(spot3);
		spots.add(spot4);
		spots.add(spot5);
		spots.add(spot6);
		spots.add(spot7);
		spots.add(spot8);
		spots.add(spot9);

		for (int i = 0; i < spots.size(); i++) {
			x = i % 3;
			y = i / 3;

			if (mX >= x * tileSize && mX <= (x + 1) * tileSize && mY >= y * tileSize && mY <= (y + 1) * tileSize) {
				spots.set(i, true);
			} else {
				spots.set(i, false);
			}
		}
		return spots;
	}

}
