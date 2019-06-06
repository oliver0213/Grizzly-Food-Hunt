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
        button1.setLayoutX(0);
        button1.setLayoutY(10);
        Button button2 = new Button("       lauch");
        button2.setLayoutX(0);
        button2.setLayoutY(40);
        Button button3 = new Button("       dinner");
        button3.setLayoutX(0);
        button3.setLayoutY(70);
        
     //   Text text1 = new Text(10,20,"breakfast");
     //   Text text2 = new Text(10,40,"This is a text sample");
    //  Text text3 = new Text(10,60,"This is a text sample");
        
        Pane root = new Pane();
        root.getChildren().add(button1);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
     //   root.getChildren().add(text1);
     //   root.getChildren().add(text2);
      //  root.getChildren().add(text3);
               
        Scene scene = new Scene(root,400,400);
        primaryStage.setTitle("Vandenberg");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}