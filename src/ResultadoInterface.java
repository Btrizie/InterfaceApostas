import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//interface conectada com a classe Apostar e as interfaces PremioGinterface, ResultadoGInterface 
//e ResultadoWGInterface
public class ResultadoInterface {
    private Stage stage;
    private Scene scene;

    @FXML
    private Label resultadoSorteio;

    @FXML
    private Label ganhadores;

    //acessa a interface para sortear o resultado das apostas
    @FXML
    void btnSortear(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ResultadoWGInterface.fxml"));
        scene = new Scene(root);
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
        
    }

    //realiza as 25 apostas
    @FXML
    void btnSortear2(ActionEvent event) {
        if(Apostar.apostar.getCountResultado() < 25){
            resultadoSorteio.setText(Apostar.apostar.geraResultado().toString());
            if (Apostar.apostar.getGanhou() == false) {
                ganhadores.setText("Não houve ganhadores...");
            }
            else{
                ganhadores.setText("Ganhou!!");
            }
        }
    }

    //acessa a interface com a interface da apuração
    @FXML
    void btnapuracao(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("PremioGInterface.fxml"));
        scene = new Scene(root);
        stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

}
