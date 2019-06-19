/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package menu;

import java.sql.Connection;
import java.sql.ResultSet;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author yunfa
 */
public class Meal extends Menu{
   
    @Override
    public void start(Stage primaryStage){
        
    
   

        
        Pane root = new Pane();
        Button button = new Button();
        Button button2 = new Button();
        Button button3 = new Button();
        Button button4 = new Button();
        Button button5 = new Button();
        Button button6 = new Button();
        button.setLayoutX(15);
        button.setLayoutY(50);
        button.setText("Breakfast");
        button2.setLayoutX(15);
        button2.setLayoutY(90);
        button2.setText("Lunch");
        button3.setLayoutX(15);
        button3.setLayoutY(130);
        button3.setText("Dinner");
        button4.setLayoutX(105);
        button4.setLayoutY(50);
        button4.setText("Breakfast for Vegetarian");
        button5.setLayoutX(105);
        button5.setLayoutY(90);
        button5.setText("Lunch for Vegetarian");
        button6.setLayoutX(105);
        button6.setLayoutY(130);
        button6.setText("Dinner for Vegetarian");
        
       
      
        button.setOnAction((ActionEvent event) -> {
            breakfast open = new breakfast();
            open.start(new Stage());
        });
         button2.setOnAction((ActionEvent event) -> {
             lunch open = new lunch();
             open.start(new Stage());
        });
          button3.setOnAction((ActionEvent event) -> {
              dinner open = new dinner();
              open.start(new Stage());
        });
          button4.setOnAction((ActionEvent event) -> {
            breakfastV open = new breakfastV();
            open.start(new Stage());
        });
         button5.setOnAction((ActionEvent event) -> {
             lunchV open = new lunchV();
             open.start(new Stage());
        });
          button6.setOnAction((ActionEvent event) -> {
              dinnerV open = new dinnerV();
              open.start(new Stage());
        });
        String image = Meal.class.getResource("background.jpg").toExternalForm();
        root.setStyle("-fx-background-image: url('" + image + "'); " );

        root.getChildren().add(button);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
        root.getChildren().add(button4);
        root.getChildren().add(button5);
        root.getChildren().add(button6);
        Scene scene = new Scene(root,600,500);
        primaryStage.setTitle("Vandenberg");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
  
}
