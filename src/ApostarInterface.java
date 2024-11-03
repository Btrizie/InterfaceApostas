import java.io.IOException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

//interface conectada com a classe Apostar e a interface ApostarInface
public class ApostarInterface {
    private Stage stage;
    private Scene scene;
    private Random r = new Random();
    private int n1, n2, n3, n4, n5;
    private boolean erro;

        @FXML
        private TextArea taN1, taN2, taN3, taN4, taN5;

        @FXML
        private TextField tfCPF, tfNome;

        //realiza a nova aposta, adiciona à lista de apostas
        @FXML
        void btnApostar2(ActionEvent event) throws IOException {
            erro = false;
            tratamentodeErros();
            if(erro == false){
                NovaAposta na = new NovaAposta(tfNome.getText(), tfCPF.getText(), n1, n2, n3, n4, n5, Apostar.apostar.getId());
                Apostar.apostar.add(na);  
            }
        }
    
        //gera uma nova aposta randômica
        @FXML
        void btnSurpresinha(ActionEvent event) {
            taN1.setText(String.valueOf(r.nextInt(1,50)));
            taN2.setText(String.valueOf(r.nextInt(1,50)));
            taN3.setText(String.valueOf(r.nextInt(1,50)));
            taN4.setText(String.valueOf(r.nextInt(1,50)));
            taN5.setText(String.valueOf(r.nextInt(1,50)));
        }
    
        //volta para o menu inicial
        @FXML
        void btnVoltar(ActionEvent event) throws IOException {
            Parent root = FXMLLoader.load(getClass().getResource("AppGInterface.fxml"));
            scene = new Scene(root);
            stage = (Stage)(((Node) event.getSource()).getScene().getWindow());
            stage.setTitle("Menu");
            stage.setScene(scene);
            stage.show();
        }

        //trata erros de input como: input > 50, input < 1 ou input = null
        public void tratamentodeErros(){
            if(taN1.getText() == null || taN1.getText().trim().isEmpty() || taN2.getText() == null || taN2.getText().trim().isEmpty() 
            || taN3.getText() == null || taN3.getText().trim().isEmpty() || taN4.getText() == null || taN4.getText().trim().isEmpty()
            || taN5.getText() == null || taN5.getText().trim().isEmpty()){
                taN1.setText("0");
                taN2.setText("0");
                taN3.setText("0");
                taN4.setText("0");
                taN5.setText("0");
            }

            n1 = Integer.parseInt(taN1.getText());
            n2 = Integer.parseInt(taN2.getText());
            n3 = Integer.parseInt(taN3.getText());
            n4 = Integer.parseInt(taN4.getText());
            n5 = Integer.parseInt(taN5.getText());

            if (n1 > 50 || n1 == 0 ) {
                taN1.setPromptText("ERRO");
                taN1.setText("");
                erro = true;
            }
            else if (n2 > 50 || n2 == 0) {
                taN2.setPromptText("ERRO");
                taN2.setText("");
                erro = true;
            }
            else if (n3 > 50 || n3 == 0) {
                taN3.setPromptText("ERRO");
                taN3.setText("");
                erro = true;
            }
            else if (n4 > 50 || n4 == 0) {
                taN4.setPromptText("ERRO");
                taN4.setText("");
                erro = true;
            }
            else if (n5 > 50 || n5 == 0) {
                taN5.setPromptText("ERRO");
                taN5.setText("");
                erro = true;
            }
            else if(tfNome.getText() == null || tfNome.getText().trim().isEmpty()){
                tfNome.setPromptText("Preenchimento obrigatório!");
                erro = true;
            } 
            else if(tfCPF.getText() == null || tfCPF.getText().trim().isEmpty()){
                tfCPF.setPromptText("Preenchiento obrigatório!");
                erro = true;
            }
        }

    }