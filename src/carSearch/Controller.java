package carSearch;
/************************
 * Autor: Raphael Ciorba
 * Datum: 14.01.2021
 ***********************/

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import carSearch.CarDatabase;
import javafx.stage.Stage;
import model.Car;
import java.util.LinkedList;

public class Controller {

    @FXML private TextField searchField;

    @FXML private ListView listField;

    private CarDatabase cars = new CarDatabase();

    private void licensplates(LinkedList<Car> list){

        if(list != null) {

            LinkedList<String> licenseplateList = new LinkedList<String>();

            for (Car v : list) { licenseplateList.add(v.getLicensePlate()); }

            listField.setItems(FXCollections.observableArrayList(licenseplateList));
        }
        else
            listField.setItems(null);
    }

    @FXML private void searchExact(){ licensplates(cars.search(searchField.getText(), true)); }

    @FXML private void searchFor(){
        licensplates(cars.search(searchField.getText(), false));
    }
}
