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

public class GamePiece {

	private int tileSize = 100;
	ArrayList<ImageView> xArray = new ArrayList<>(9); //list of o and x images
	ArrayList<ImageView> oArray = new ArrayList<>(9);//
	ArrayList<ImageView> coverArray = new ArrayList<>(9); //list of the images that cover the x and os ()
	WinCondition whoWon = new WinCondition(); //to tell when the game ends
	
	int clickCount = 0; // tracks # of clicks

	int turn = 1; // who's turn it is

	public GamePiece(int tileSize) { // can set size of images in constructor
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

		ArrayList<ImageView> imgArray = new ArrayList<ImageView>(9); //creating list of imageviews
		imgArray.add(imageView1);//adding each imageview
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

	public void setImgSize(ArrayList<ImageView> imgArray, Group root) {
		for (int i = 0; i < imgArray.size(); i++) { // goes through each grid space and puts an image there
			int x = i % 3;
			int y = i / 3;

			imgArray.get(i).setX(x * tileSize);
			imgArray.get(i).setY(y * tileSize);

			imgArray.get(i).setFitHeight(tileSize);
			imgArray.get(i).setFitWidth(tileSize);

			root.getChildren().add(imgArray.get(i)); //adds images to group
		}

	}
	
	public ArrayList<Boolean> gridSpotTracker(double mX, double mY) { // takes mouse coordinates, tracks which grid spots have been clicked
		
		ArrayList<Boolean> spots = new ArrayList<>(9); // creates list

		boolean spot1 = false; // creates booleans for each spot
		boolean spot2 = false;
		boolean spot3 = false;
		boolean spot4 = false;
		boolean spot5 = false;
		boolean spot6 = false;
		boolean spot7 = false;
		boolean spot8 = false;
		boolean spot9 = false;

		spots.add(spot1); //adds each boolean to the list
		spots.add(spot2);
		spots.add(spot3);
		spots.add(spot4);
		spots.add(spot5);
		spots.add(spot6);
		spots.add(spot7);
		spots.add(spot8);
		spots.add(spot9);

		for (int i = 0; i < spots.size(); i++) { //goes through each spot in the grid
			int x = i % 3;
			int y = i / 3;

			if (mX >= x * tileSize && mX <= (x + 1) * tileSize && mY >= y * tileSize && mY <= (y + 1) * tileSize) { // if mouse coordinates are in a particular square
				spots.set(i, true); //sets that spot to "true"
			} 
		}
		return spots;
	}



	public Group placeImgs() throws FileNotFoundException {
		String xFileName = "/Users/Henry/Desktop/please sort this/sunset pic.png";
		String oFileName = "/Users/Henry/Desktop/please sort this/a04.png";
		String coverFileName = "/Users/Henry/Desktop/cover.png"; // file names for each of the images

		oArray = imgSetup(oFileName);
		xArray = imgSetup(xFileName);
		coverArray = imgSetup(coverFileName);

		Group root = new Group();
		
		setImgSize(oArray, root);
		setImgSize(xArray, root);
		setImgSize(coverArray, root);

		root.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {//called when mouse is clicked

			@Override
			public void handle(MouseEvent mouseEvent) {
				double mouseX = mouseEvent.getX(); //keeps track of mouse coordinates
				double mouseY = mouseEvent.getY();
				if (clickCount % 2 == 0) { //turn is determined by number of clicks
					turn = 2;
				}
				if (clickCount % 2 == 1) {
					turn = 1;
				}
				for (int i = 0; i < gridSpotTracker(mouseX, mouseY).size(); i++) { // loops through each spot in the grid

					if (gridSpotTracker(mouseX, mouseY).get(i) == true) { // if spot "i" has been clicked
						if (coverArray.get(i).isVisible()) { // if the cover image is still visible
							clickCount++; //updates player turn, turn only updates if there isn't an x or o on that spot
							coverArray.get(i).setVisible(false); //gets rid of cover image in that spot
						}

						if (turn == 1) { // if player 1s turn
							if (oArray.get(i).isVisible()) { // if the O piece is still visible
								xArray.get(i).setVisible(false);// set the x piece to invisible
							}
						} else {// if its player 2s turn
							if (xArray.get(i).isVisible()) {  // if the x piece is still visible
								oArray.get(i).setVisible(false);// set the o piece to invisible
							}
						}
					}
				}
				if (whoWon.win(coverArray, xArray)) { //checks if the right spots are filled
					System.out.println("xWins");
				}
				if (whoWon.win(coverArray, oArray)) {
					System.out.println("oWins");
				}
				
			}

		});

		return root;
	}

	}
