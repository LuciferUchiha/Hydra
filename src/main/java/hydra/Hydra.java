package hydra;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Hydra extends Application {

    private Stage stage;
    private final double WINDOW_WIDTH = 350;
    private final double WINDOW_HEIGHT = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        this.stage.setTitle("Hail Hydra");
        placeNewHeadRandomly();
        this.stage.setScene(growHead());
        this.stage.setOnCloseRequest(e -> {
            cutOffHead();
        });
        this.stage.show();
    }

    private void placeNewHeadRandomly() {
        //Get primary screen bounds
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        // So that its never cut off
        this.stage.setX(Math.random() * (screenBounds.getWidth() - WINDOW_WIDTH));
        this.stage.setY(Math.random() * (screenBounds.getHeight() - WINDOW_HEIGHT));
    }

    private Scene growHead() {
        VBox vbox = new VBox();
        vbox.setPrefWidth(WINDOW_WIDTH);
        vbox.setPrefHeight(WINDOW_HEIGHT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        Label warning = new Label("Cut off one hydra head, two more will grow back in its place.");
        Button sword = new Button("close");
        sword.setOnAction(e -> cutOffHead());
        vbox.getChildren().addAll(warning, sword);
        return new Scene(vbox);
    }

    private void cutOffHead() {
        this.stage.close();
        try {
            start(new Stage());
            start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
