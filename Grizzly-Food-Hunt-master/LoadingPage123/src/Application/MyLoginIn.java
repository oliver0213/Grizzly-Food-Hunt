/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

/**
 *
 * @author yunfa
 */


import static java.lang.System.err;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;

public class MyLoginIn {
	static ArrayList<User> list = new ArrayList<User>();  //存放用户数据的列表

	public static void main(String[] args) {
		LoadUser(); //从文件中载入用户数据
		Application.launch(Login.class, args); //启动javafx Application程序
	}

	public static void LoadUser() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("user.txt")));
			String line = null;
			while ((line = reader.readLine()) != null) {
				String[] data = line.split("\\s+");
				list.add(new User(data[0], data[1]));

			}
			reader.close();
		} catch (IOException e) {
			err.println("用户文件数据 user.txt找不到");
			e.printStackTrace();
		}
	}

	public static boolean findUser(String account, String pwd) {
		return list.contains(new User(account, pwd));
	}

	public static User findAccount(String account) {
		for (User u : list)
			if (u.getAccount().equalsIgnoreCase(account))
				return u;
		return null;
	}

	public static User newUser() {
		User user = list.get(list.size() - 1);
		return new User(Integer.parseInt(user.getAccount()) + 1 + "", "");
	}

	public static void addNewUser(User user) {
		list.add(user);
		LoadUser();
		
	}
}
