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
import javafx.scene.control.Label;
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
        button1.setLayoutX(50);
        button1.setLayoutY(140);
        Button button2 = new Button("       lunch");
        button2.setLayoutX(150);
        button2.setLayoutY(140);
        Button button3 = new Button("       dinner");
        button3.setLayoutX(250);
        button3.setLayoutY(140);
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
        Label label = new Label("Menu from JSON");
        label.setLayoutX(50);
        label.setLayoutY(200);
        Button button11 = new Button("    breakfast");
        button11.setLayoutX(50);
        button11.setLayoutY(240);
        Button button12 = new Button("       lunch");
        button12.setLayoutX(150);
        button12.setLayoutY(240);
        Button button13 = new Button("       dinner");
        button13.setLayoutX(250);
        button13.setLayoutY(240);
        button11.setOnAction((ActionEvent event) -> {
            Window11 open = new Window11();
            open.start(new Stage());          
        });  //click event, open window 2
        button12.setOnAction((ActionEvent event) -> {
            Window12 open = new Window12();
            open.start(new Stage());          
        });  //click event, open window 2
        button13.setOnAction((ActionEvent event) -> {
            Window13 open = new Window13();
            open.start(new Stage());          
        });  //click event, open window 2
        Pane root = new Pane();
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
        root.getChildren().add(button11);
        root.getChildren().add(button12);
        root.getChildren().add(button13);
        root.getChildren().add(label);
        
               
        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Vandenberg");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}