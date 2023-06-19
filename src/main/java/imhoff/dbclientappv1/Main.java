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

        int rowsAffected = FruitsQuery.insert("cherries", 1);
        // try the insert
        // when it gets called, it will return the insert and it will return the number of rows that was affected by the insert
        // we can confirm if our insert was successful

        if(rowsAffected > 0){
            System.out.println("Insert Successful");
        }
        else{
            System.out.println("Insert FAILED");
        }

        //launch();
        JDBC.closeConnection();
    }
}






/**
 * ----------------------------------------------------------------
 * import javafx.application.Application;
 * import javafx.fxml.FXMLLoader;
 * import javafx.scene.Scene;
 * import javafx.stage.Stage;
 *
 * import java.io.IOException;
 *
 * public class MainTest {
 *
 *     public static void main(String[] args) {
 *         System.out.println("Hello World from VM");
 *         JDBC.openConnection();
 *         JDBC.closeConnection();
 *     }
 * }
 */