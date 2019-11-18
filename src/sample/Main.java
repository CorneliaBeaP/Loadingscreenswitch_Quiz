package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class Main extends Application {

    public static Stage stage2;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage2 = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("loadingscreen.fxml"));

        stage2.setScene(new Scene(root, 550, 700));
        stage2.show();
        Thread t = new Thread(new Test());
        t.start();




    }


            public static void main (String[]args){
                launch(args);
            }
        }
