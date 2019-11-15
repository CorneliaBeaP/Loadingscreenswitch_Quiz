package sample;

import com.jfoenix.controls.JFXProgressBar;
import com.jfoenix.controls.JFXSpinner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private Label waitingLabel;

//    Socket socket = new Socket("localhost", 5989);
//
//    ObjectOutputStream writer = new ObjectOutputStream(socket.getOutputStream());
//    ObjectInputStream serverReader = new ObjectInputStream(socket.getInputStream());

    public Controller() throws IOException {
    }

    @FXML
    private void handleEvent(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getClassLoader().getResource("sample/connectedscreen.fxml"));
        rootAnchorPane.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
