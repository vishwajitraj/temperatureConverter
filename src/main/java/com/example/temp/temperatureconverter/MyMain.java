package com.example.temp.temperatureconverter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class MyMain extends Application {

    public static void main(String[] args) {
        System.out.println("main");
        launch(args);
    }

    @Override
    public void init() throws Exception {
        System.out.println("init");    // Initialize your Application
        super.init();
    }

    @Override
    public void start(Stage PrimaryStage) throws IOException {
        System.out.println("start");       // Start an Application
        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("TemperatureConverter.fxml"));
        VBox rootNode = loader.load();

        //    MenuBar menuBar = createMenu();  // link the createMenu class in main
        //    rootNode.getChildren().add(0,menuBar);  // add the menuBar in VBox

        Scene scene = new Scene(rootNode);

        PrimaryStage.setScene(scene);
        PrimaryStage.setTitle("Temperature Converter Tool");

        PrimaryStage.show();
    }

    private MenuBar createMenu() {
        // File Menu
        Menu fileMenu = new Menu("File");
        // Add Menu Item in file menu bar
        MenuItem newMenuItem = new MenuItem("New");

        // to add after clicking the new menu item
        newMenuItem.setOnAction(actionEvent -> {
            System.out.println("New Menu Item Clicked");
        });
        // to add separate line in menu item
        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
        MenuItem quitMenuItem = new MenuItem("Quit");

        // to add after clicking the Quit menu item
        quitMenuItem.setOnAction(event -> {
            Platform.exit();  // sutDown the app
            System.exit(0); // sutDown the Current Virtual machine
        });

        fileMenu.getItems().addAll(newMenuItem, separatorMenuItem, quitMenuItem);

        // Help Menu
        Menu helpMenu = new Menu("Help");
        // Add Menu Item in help menu bar
        MenuItem aboutApp = new MenuItem("About");

        // to clicking the about menu item
        aboutApp.setOnAction(actionEvent -> aboutApp());

        helpMenu.getItems().addAll(aboutApp);

        // Menu Bar
        MenuBar menuBar = new MenuBar();

        // Add all Menu in MenuBar
        menuBar.getMenus().addAll(fileMenu, helpMenu);

        return menuBar;
    }

    private void aboutApp() {  // aboutApp method on clicking the about menu item

        Alert alertDialog = new Alert(Alert.AlertType.INFORMATION);
        alertDialog.setTitle("My First Desktop Application");
        alertDialog.setHeaderText("Learning JavaFx");
        alertDialog.setContentText("I am just a beginner but soon i will pro and start developing awesome java games");

        ButtonType yesBtn = new ButtonType("Yes");
        ButtonType noBtn = new ButtonType("No");

        alertDialog.getButtonTypes().setAll(yesBtn, noBtn);

        Optional<ButtonType> clickBtn = alertDialog.showAndWait();

        if (clickBtn.isPresent() && clickBtn.get() == yesBtn) {
            // code...
            System.out.println("Yes Button clicked!");
        } else {
            System.out.println("No Button clicked!");
        }

    }

    @Override
    public void stop() throws Exception {
        System.out.println("stop");   // Called when Application is Stopped and is about to shut down
        super.stop();
    }

}