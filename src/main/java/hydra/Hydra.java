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

    private final double WINDOW_WIDTH = 350;
    private final double WINDOW_HEIGHT = 100;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Hail Hydra");
        placeStageRandomly(stage);
        stage.setScene(getScene(stage));
        stage.setOnCloseRequest(e -> cutOffHead(stage));
        stage.show();
    }

    private void placeStageRandomly(Stage stage) {
        //Get primary screen bounds
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        // So that its never cut off
        stage.setX(Math.random() * (screenBounds.getWidth() - WINDOW_WIDTH));
        stage.setY(Math.random() * (screenBounds.getHeight() - WINDOW_HEIGHT));
    }

    private Scene getScene(Stage stage) {
        VBox vbox = new VBox();
        vbox.setPrefWidth(WINDOW_WIDTH);
        vbox.setPrefHeight(WINDOW_HEIGHT);
        vbox.setAlignment(Pos.CENTER);
        vbox.setSpacing(10);
        Label warning = new Label("Cut off one hydra head, two more will grow back in its place.");
        Button sword = new Button("close");
        sword.setOnAction(e -> cutOffHead(stage));
        vbox.getChildren().addAll(warning, sword);
        return new Scene(vbox);
    }

    private void cutOffHead(Stage stage) {
        stage.close();
        growTwoNewHeads();
    }

    private void growTwoNewHeads() {
        try {
            start(new Stage());
            start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
