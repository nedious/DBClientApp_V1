package imhoff.dbclientappv1;

import helper.FruitsQuery;
import helper.JDBC;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.SQLException;

public class Main extends Application{

     @Override
     public void start(Stage stage) throws IOException {

     FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginView.fxml"));
     stage.initStyle(StageStyle.UNDECORATED);
     Scene scene = new Scene(fxmlLoader.load(), 500, 400);
//     stage.setTitle("Hello!");
     stage.setScene(scene);
     stage.show();
     }

    public static void main(String[] args) throws SQLException {
        JDBC.openConnection();

//        FruitsQuery.select(3);

        launch(args);

        JDBC.closeConnection();
    }
}