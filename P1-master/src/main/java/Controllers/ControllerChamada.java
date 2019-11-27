package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import database.AlunoDAO;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Aluno;
import rojie.poo.ifsc.P1.App;

public class ControllerChamada implements Initializable {
    @FXML
    private ListView<Aluno> listChamada;

    @FXML
    private Button btnVoltar;
    
    @FXML
    private CheckBox chcP1;

    @FXML
    private CheckBox chcP2;

    @FXML
    private CheckBox chcP3;

    @FXML
    void Voltar(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainAluno.fxml"));
		Parent parent = fxmlLoader.load();
		Scene scene = new Scene(parent);
		Stage stage = new Stage();
		stage.setScene(scene);
		stage.show();
		stage = (Stage) btnVoltar.getScene().getWindow();
		stage.close();
		
    
    }
    public void updateListAluno() {
 		AlunoDAO dao = new AlunoDAO();
 		listChamada.setItems(null);
 		listChamada.setItems((ObservableList<Aluno>) dao.getAll());

 		
 	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateListAluno();
		
	}

}
