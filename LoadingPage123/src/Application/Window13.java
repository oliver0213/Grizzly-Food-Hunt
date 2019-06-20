/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author munja
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Application.models.Category;
import Application.models.Item;
import Application.models.MenuResponse;
import Application.models.Period;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javafx.scene.layout.StackPane;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 *
 * @author yunfa
 */
public class Window13 extends Application{
    
    private ObservableList<ObservableList> data;
    
    private TableView tableview;
    @Override
    public void start(Stage primaryStage){
        StackPane root = new StackPane();
        
        tableview = new TableView();
        //buildData();
        try {
            String response = fetchMenuForDate("2019-6-18");
            Gson g = new Gson();
            MenuResponse p = g.fromJson(response, MenuResponse.class);
            
            fillTable(p);
            System.out.println(""+p);
        } catch (Exception ex) {
            Logger.getLogger(Window3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(tableview,400,400);
        primaryStage.setTitle("Vanderberg");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void fillTable(MenuResponse response){
        
        data = FXCollections.observableArrayList();
          
        TableColumn col1 = new TableColumn("Name");
                col1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(0).toString());                        
                    }                    
                });
        TableColumn col2 = new TableColumn("Category");
                col2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(1).toString());                        
                    }                    
                });
        TableColumn col3 = new TableColumn("Calories");
                col3.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(2).toString());                        
                    }                    
                });
        
        tableview.getColumns().addAll(col1,col2,col3);

            
        for (Period period:response.menu.periods){
            if(period.name.equals("Dinner")){
                for (Category category:period.categories){
                    //row.add(category.name);
                    for (Item item:category.items){
                        ObservableList<String> row = FXCollections.observableArrayList();
                        row.add(item.name);
                        row.add(category.name);
                        row.add(item.nutrients[0].value+"");
                        data.add(row);
                    }
                }
            }
        }
        tableview.setItems(data);
        
        
                
        
    }
    
    public String fetchMenuForDate(String date) throws Exception{
   

String url = "https://api.dineoncampus.com/v1/location/menu?site_id=5751fd3090975b60e048932a&platform=0&location_id=586fd0d93191a2088ec6388f&date="+date;
URL obj = new URL(url);
HttpURLConnection con = (HttpURLConnection) obj.openConnection();

// optional default is GET
con.setRequestMethod("GET");

//add request header
//con.setRequestProperty("User-Agent", USER_AGENT);

int responseCode = con.getResponseCode();
System.out.println("\nSending 'GET' request to URL : " + url);
System.out.println("Response Code : " + responseCode);

BufferedReader in = new BufferedReader(
       new InputStreamReader(con.getInputStream()));
String inputLine;
StringBuffer response = new StringBuffer();

while ((inputLine = in.readLine()) != null) {
response.append(inputLine);
}
in.close();

//print result
//System.out.println(response.toString());
                return response.toString();

    }
}
