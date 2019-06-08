/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.ImageIcon;





/**
 *
 * @author yunfa
 */
public class loadingpage extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        

        Application.setUserAgentStylesheet(getClass().getResource("css.css").toExternalForm());    
        
        Button button1 = new Button("  go for menu"); 
        button1.setLayoutX(200);
        button1.setLayoutY(240);
        button1.setOnAction((ActionEvent event) -> {
            Window2 open = new Window2();
            open.start(new Stage());          
        });  //click event, open window 2
        
        
        Text text1 = new Text(10,220,"Monday-Thurday:7am-11pm");
        Text text2 = new Text(10,240,"Friday:7am-7pm");
        Text text3 = new Text(10,260,"Saturday:10am-7pm");
        Text text4 = new Text(10,280,"Sunday:10am-11pm");
        Text text5 = new Text(10,200,"Welcome to Vandenberg:");
        text5.setFill(Color.BLACK);
        text5.setFont(Font.font("Verdana" , 20));
        
        
        
        
        
        
        
        
        
        Image image1 = new Image("Application/picture1.png");        
        ImageView iv1 = new ImageView(image1);        
        iv1.setLayoutX(0);
        iv1.setLayoutY(0);
        
        
        Image image2 = new Image("Application/picture2.jpg",80,65,true,false);       
        ImageView iv2 = new ImageView(image2);
        iv2.setLayoutX(200);
        iv2.setLayoutY(200);
        
        
        
        

        

        Pane root = new Pane();
        root.getChildren().add(button1);
        root.getChildren().add(text1);
        root.getChildren().add(text2);
        root.getChildren().add(text3);
        root.getChildren().add(text4);
        root.getChildren().add(text5);
        root.getChildren().add(iv1);
        //root.getChildren().add(iv2);
        
  
 
          
        Scene scene = new Scene(root,290,280,Color.WHITE);  
        primaryStage.setTitle("Grizz Hunt");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
        
        
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    

}
