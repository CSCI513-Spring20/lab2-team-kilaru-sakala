import java.awt.Point;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class OceanExplorer extends Application {
	final static int dimension = 10; 
	final int scale = 50; 
	Image shipImage;
	ImageView shipImageView;
	OceanMap oceanMap;
	Pane root;
	Scene scene;
	Ship ship;
	Point startPosition;

	public static void main(String[] args) {
		launch(args);
		// TODO Auto-generated method stub

	}

	@Override
	public void start(Stage oceanStage) throws Exception {
		root = new AnchorPane();
		drawMap();

		startPosition = OceanMap.getShipLocation();
		ship = new Ship(startPosition.x, startPosition.y);
															
		loadShipImage();

		scene = new Scene(root, 500, 500);
		oceanStage.setTitle("Christopher columbus Sails The Blue Ocean");
		oceanStage.setScene(scene);
		oceanStage.show();
		startSailing();

	}

	private void startSailing() {
		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				switch (ke.getCode()) {
				case RIGHT:
					ship.goEast();
					break;
				case LEFT:
					ship.goWest();
					break;
				case UP:
					ship.goNorth();
					break;
				case DOWN:
					ship.goSouth();
					break;
				default:
					break;
				}
				shipImageView.setX(ship.getShipLocation().x * scale);
				shipImageView.setY(ship.getShipLocation().y * scale);
			}
		});

	}
 
	public void drawMap() {
		for (int x = 0; x < dimension; x++) {
			for (int y = 0; y < dimension; y++) {
				Rectangle rect = new Rectangle(x * scale, y * scale, scale, scale);
				rect.setStroke(Color.BLACK); 
				rect.setFill(Color.PALETURQUOISE);
				root.getChildren().add(rect); 

			}
		}
	}

	private void loadShipImage() {
		Image shipImage = new Image("\\ship.png", 50, 50, true, true);
		shipImageView = new ImageView(shipImage);
		shipImageView.setX(OceanMap.getShipLocation().x * scale);
		shipImageView.setY(OceanMap.getShipLocation().y * scale);
		root.getChildren().add(shipImageView);
	}

}
