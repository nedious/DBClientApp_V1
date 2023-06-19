package imhoff.dbclientappv1;

import helper.FruitsQuery;
import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

//public class MainTest extends Application {
public class Main {

    /**
     @Override
     public void start(Stage stage) throws IOException {

     System.out.println("Hello World");

     FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
     Scene scene = new Scene(fxmlLoader.load(), 320, 240);
     stage.setTitle("Hello!");
     stage.setScene(scene);
     stage.show();
     }
     */
    public static void main(String[] args) throws SQLException {
        JDBC.openConnection();

        int rowsAffected = FruitsQuery.update(7, "Pear");
        // FruitsQuery.insert and FruitsQuery.insert
        // the FruitsQuery.insert takes (fruitName, colorId)
        // when it gets called, it will return the insert and it will return the number of rows that was affected by the insert
        // we can confirm if our insert was successful
        // the FruitsQuery.update takes (fruitId, fruitName)
        // FruitsQuery.update will call the update method


        if(rowsAffected > 0){
            System.out.println("Update Successful");
            // when performing INSERT: "Insert Successful"
            // when performing UPDATE: "Update Successful"
        }
        else{
            System.out.println("Insert FAILED");
            // when performing INSERT: "Insert FAILED"
            // when performing UPDATE: "Update FAILED"
        }

        //launch();
        JDBC.closeConnection();
    }
}