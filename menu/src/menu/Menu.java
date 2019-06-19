/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author yunfa
 */
public class Menu extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Menu");
        btn.setLayoutX(500);
        btn.setLayoutY(400);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                Meal open = new Meal();
            open.start(new Stage());   
            }
        });
        
        
        Text text1 = new Text(200,420,"Monday-Thurday:7am-11pm");
        Text text2 = new Text(200,440,"Friday:7am-7pm");
        Text text3 = new Text(200,460,"Saturday:10am-7pm");
        Text text4 = new Text(200,480,"Sunday:10am-11pm");
        Text text5 = new Text(200,400,"Welcome to Vandenberg:");
        text5.setFill(Color.BLACK);
        text5.setFont(Font.font("Verdana" , 20));
        
        Image image1 = new Image("menu/picture1.png",500,300,false,false);        
        ImageView iv1 = new ImageView(image1);        
        iv1.setLayoutX(55);
        iv1.setLayoutY(50);
        
        Pane root = new Pane();
        root.getChildren().add(btn);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(iv1);
        
        Scene scene = new Scene(root, 600, 500);
        String image = Meal.class.getResource("background.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " );
        primaryStage.setTitle("Grizz Food Hunt!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
