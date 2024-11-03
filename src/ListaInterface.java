import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

//interface conectada com a classe Apostar e a interface ListaGInterface
public class ListaInterface {
    private Stage stage;
    private Scene scene;

    @FXML
    private ListView<String> listView;

    public void setApostar(Apostar apostar) {
        updateListView();
    }

    //faz o update da lista na interface
    private void updateListView() {
        List<NovaAposta> listaApostas = Apostar.apostar.getListaApostas();
        ObservableList<String> items = FXCollections.observableArrayList();
        for (NovaAposta aposta : listaApostas) {
            items.add(aposta.toString());
        }
        listView.setItems(items);
    }

    //volta para o menu de inicio
    @FXML
    void btnVoltar(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("AppGInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
    }

}