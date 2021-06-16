package com.internshala.connect4;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    public static void main (String [] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
        GridPane rootGridPane = loader.load();

        controller =loader.getController();
        controller.createPlayground();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);

        MenuBar menuBar = createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty()); // INCREASES WIDTH OF MENU BAR
        menuPane.getChildren().addAll(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect 4");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private MenuBar createMenu() {

        /* FILE MENU */
        Menu fileMenu = new Menu("File");

        // NEW GAME
        MenuItem newGame = new MenuItem("New");
        newGame.setOnAction(event -> controller.resetGame());

        // RESET GAME
        MenuItem resetGame = new MenuItem("Reset");
        resetGame.setOnAction(event -> controller.resetGame());

        // EXIT GAME
        MenuItem exitGame = new MenuItem("Exit");
        exitGame.setOnAction(event -> exitGame());

        // SEPARATOR
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

        fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

        /* HELP MENU */
        Menu helpMenu = new Menu("Help");

        // ABOUT CONNECT4 GAME
        MenuItem aboutConnect4 = new MenuItem("About Connect 4");
        aboutConnect4.setOnAction(event -> aboutConnect4());

        // ABOUT ME
        MenuItem aboutMe = new MenuItem("About Me");
        aboutMe.setOnAction(event -> aboutMe());

        SeparatorMenuItem separator = new SeparatorMenuItem();

        helpMenu.getItems().addAll(aboutConnect4, separator, aboutMe);

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutMe() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About The Developer");
        alertDialog.setHeaderText("Kartavya Pandey");
        alertDialog.setContentText("I'm a developer, currently pursuing my B.Tech. " +
                                   "from GGSIPU, Delhi.");
        alertDialog.show();

    }

    private void aboutConnect4() {

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("About Connect4 Game");
        alertDialog.setHeaderText("How To Play ??");
        alertDialog.setContentText("Connect Four is a two-player connection game in which " +
                                   "the players first choose a color and then take turns dropping colored discs " +
                                   "from the top into a seven-column, six-row vertically suspended grid. " +
                                   "The pieces fall straight down, occupying the next available space within the column. " +
                                   "The objective of the game is to be the first to form a horizontal, vertical, " +
                                   "or diagonal line of four of one's own discs. Connect Four is a solved game. " +
                                   "The first player can always win by playing the right moves.");
        alertDialog.show();
    }

    private void exitGame() {

        Platform.exit();
        System.exit(0); // CLOSE APP AND SHUTDOWN OTHER RESOURCES SUCHAS THE THREADS OF APP.
    }


}
