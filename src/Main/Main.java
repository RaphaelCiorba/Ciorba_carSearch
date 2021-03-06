package Main;
/************************
 * Autor: Raphael Ciorba
 * Datum: 14.01.2021
 ***********************/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../carSearch/sample.fxml"));
        primaryStage.setTitle("Car Searcher");
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
