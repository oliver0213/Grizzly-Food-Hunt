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
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.text.Text;

/**
 *
 * @author yunfa
 */
public class Window2 extends Application{
    @Override
    public void start(Stage primaryStage){
        
        
        Button button1 = new Button("    breakfast");
        button1.setLayoutX(150);
        button1.setLayoutY(200);
        Button button2 = new Button("       lunch");
        button2.setLayoutX(250);
        button2.setLayoutY(200);
        Button button3 = new Button("       dinner");
        button3.setLayoutX(350);
        button3.setLayoutY(200);
        button1.setOnAction((ActionEvent event) -> {
            Window3 open = new Window3();
            open.start(new Stage());          
        });  //click event, open window 2
        button2.setOnAction((ActionEvent event) -> {
            Window3 open = new Window3();
            open.start(new Stage());          
        });  //click event, open window 2
        button3.setOnAction((ActionEvent event) -> {
            Window3 open = new Window3();
            open.start(new Stage());          
        });  //click event, open window 2
        Pane root = new Pane();
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
     
               
        Scene scene = new Scene(root,600,500);
        primaryStage.setTitle("Vandenberg");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}