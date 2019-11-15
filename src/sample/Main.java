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

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("loadingscreen.fxml"));

        primaryStage.setScene(new Scene(root, 550, 700));
        primaryStage.show();


        Socket socket = new Socket("localhost", 5989);

        ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream serverReader = new ObjectInputStream(socket.getInputStream());

        try {

            String fromServer;
            fromServer = (String) serverReader.readObject();
            System.out.println(fromServer);
            if (fromServer.equalsIgnoreCase("connected")) {
                System.out.println("Connection completed");
                Parent connec = FXMLLoader.load(getClass().getResource("connectedscreen.fxml"));
                primaryStage.setScene(new Scene(connec, 550, 700));
                primaryStage.show();
            }


        }catch (Exception e){
            System.out.println("Oh no:(");
            e.printStackTrace();
        }


    }


            public static void main (String[]args){
                launch(args);
            }
        }
