/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author yunfa
 */
public class Window3 extends Application{
    @Override
    public void start(Stage primaryStage){
        StackPane root = new StackPane();
        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Hillcrest Dining Hall");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}