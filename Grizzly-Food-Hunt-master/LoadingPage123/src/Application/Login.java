/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;


import java.io.File;
import java.io.FileInputStream;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Login extends Application {

	@Override
	public void start(Stage primaryStage) {

		
		primaryStage.setTitle("Login");
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));// 设置填充, Insets实例设置矩形区域的四边的一组内偏移量

		Text title = new Text("Login");
		title.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		Label Account = new Label("Username:");
		TextField userAccount = new TextField();
		Label pwd = new Label("Password:");
		PasswordField userPwd = new PasswordField();
		Label no = new Label("No Username?->");
		no.setTextFill(Color.BLUE);
		Button confirm = new Button("login");
		Button register = new Button("sign in");
		Button forget = new Button("forget password");

		confirm.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {

				if (MyLoginIn.findUser(userAccount.getText(), userPwd.getText())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Success message");
					alert.setHeaderText(null);
					alert.setContentText("login successful");
					alert.showAndWait();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error message");
					alert.setHeaderText(null);
					alert.setContentText("Username or password is incorrect, please re-enter");
					alert.showAndWait();
					userAccount.clear();
					userPwd.clear();
				}
			}

		});

		register.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				Stage dialog = new Stage();
				dialog.initModality(Modality.APPLICATION_MODAL);
				dialog.initOwner(primaryStage);
				User user = MyLoginIn.newUser();
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Success message");
				alert.setHeaderText(null);
				alert.setContentText("Your account is: " + user.getAccount());
				alert.showAndWait();
				dialog.setTitle("set password");
				PasswordField newPwd = new PasswordField();
				Label label = new Label("password");
				Button confirm = new Button("confirm");
				confirm.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						
						alert.setTitle("Success message");
						alert.setHeaderText(null);
						alert.setContentText("Registration is successful, please return to login");
						user.setPwd(newPwd.getText());
						MyLoginIn.addNewUser(user);
						alert.showAndWait();
						dialog.close();
						userAccount.setText(user.getAccount());
						userPwd.clear();
					}
			});
				GridPane grid = new GridPane();
				grid.setAlignment(Pos.CENTER);
				grid.setHgap(10);
				grid.setVgap(10);
				grid.setPadding(new Insets(25, 25, 25, 25));// 设置填充, Insets实例设置矩形区域的四边的一组内偏移量
				grid.add(label, 0, 1);
				grid.add(newPwd, 1, 1);
				grid.add(confirm, 1, 2);
				dialog.setScene(new Scene(grid, 300, 100));
				dialog.show();
		}	
	});

		forget.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				User user = MyLoginIn.findAccount(userAccount.getText());
				if (user != null) {
					Stage dialog = new Stage();
					dialog.setTitle("reset Password");
					dialog.initModality(Modality.APPLICATION_MODAL);
					dialog.initOwner(primaryStage);
					PasswordField newPwd = new PasswordField();
					Label label = new Label("new password");
					Button confirm = new Button("confirm");
					confirm.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event) {
							user.setPwd(newPwd.getText());
							Alert alert = new Alert(AlertType.INFORMATION);
							alert.setTitle("Success message");
							alert.setHeaderText(null);
							alert.setContentText("Change password successfully, please return to login");
							alert.showAndWait();
							dialog.close();
							userPwd.clear();
						}
					});
					GridPane grid = new GridPane();
					grid.setAlignment(Pos.CENTER);
					grid.setHgap(10);
					grid.setVgap(10);
					grid.setPadding(new Insets(25, 25, 25, 25));// 设置填充, Insets实例设置矩形区域的四边的一组内偏移量
					grid.add(label, 0, 1);
					grid.add(newPwd, 1, 1);
					grid.add(confirm, 1, 2);
					dialog.setScene(new Scene(grid, 300, 100));
					dialog.show();
				} else {
					Alert alert = new Alert(AlertType.ERROR);
					alert.setTitle("Error message");
					alert.setHeaderText(null);
					alert.setContentText("The account you entered does not exist, please re-enter");
					alert.showAndWait();
					userAccount.clear();
					userPwd.clear();
				}
			}
		});
		grid.add(title, 0, 0, 2, 1);
		grid.add(Account, 0, 1);
		grid.add(userAccount, 1, 1);
		grid.add(pwd, 0, 2);
		grid.add(userPwd, 1, 2);

		HBox panel = new HBox(40);
		panel.setAlignment(Pos.BOTTOM_RIGHT);
		panel.getChildren().add(confirm);

		HBox panel2 = new HBox(40);
		panel2.setAlignment(Pos.BOTTOM_RIGHT);
		panel2.getChildren().add(no);
		panel2.getChildren().add(register);
		grid.add(panel, 1, 4);
		grid.add(panel2, 1, 5);

		HBox panel3 = new HBox(20);
		panel3.setAlignment(Pos.BOTTOM_RIGHT);
		panel3.getChildren().add(forget);
		grid.add(panel3, 1, 6);
		primaryStage.setScene(new Scene(grid, 350, 300));

		primaryStage.show();
	}
}


