/*
Name: Michael Gonzalez
Email: michael.t.gonza@gmail.com
Date: 12/19/2022
Project Name: Final_Gonzalez_Michael
Course: CS17.11
Description: The public class Final_Gonzalez_Michael_Application extends the class Application
and serves as the main application for the "Twenty One" card game GUI.
*/


package edu.srjc.gonzalez.michael.final_gonzalez_michael;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Final_Gonzalez_Michael_Application extends Application
{
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Final_Gonzalez_Michael_Application.class.getResource("Final_Gonzalez_Michael_UI_Layout.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Welcome to 21!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch();
    }
}