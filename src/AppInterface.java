import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

//interface conectada com a classe App e a interface AppInterface
public class AppInterface {

    private Stage stage;
    private Scene scene;

    //acessa a interface para realizar apostas
    @FXML
    void btnApostar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ApostarGInterface.fxml"));
        scene = new Scene(root);
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("Apostar");
        stage.setScene(scene);
        stage.show();
    }

    //acessa a interface final que gera o rresultado
    @FXML
    void btnFinalizar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ResultadoGInterface.fxml"));
        scene = new Scene(root);
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("Finalizar");
        stage.setScene(scene);
        stage.show();
    }

    //acessa a interface que mostra a lista de apostas
    @FXML
    void btnLista(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListaGInterface.fxml"));
        Parent root = loader.load();
        ListaInterface listaInterface = loader.getController();
        listaInterface.setApostar(new Apostar());
        scene = new Scene(root);
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("Lista");
        stage.setScene(scene);
        stage.show();
    }

}