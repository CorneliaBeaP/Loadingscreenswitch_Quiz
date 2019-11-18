package sample;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Test implements Runnable{


    @Override
    public void run() {
        Socket socket = null;

        try {
            socket = new Socket("localhost", 5989);
            ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream serverReader = new ObjectInputStream(socket.getInputStream());


            String fromServer;
            fromServer = (String) serverReader.readObject();
            System.out.println(fromServer);
            if (fromServer.equalsIgnoreCase("connected")) {
                System.out.println("Connection completed");
                Platform.runLater(()-> {
                    Parent connec = null;
                    try {
                        connec = FXMLLoader.load(getClass().getResource("connectedscreen.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Main.stage2.setScene(new Scene(connec, 550, 700));
                    Main.stage2.show();
                });
            }


        }catch (Exception e){
            System.out.println("Oh no:(");
            e.printStackTrace();
        }
    }
}
