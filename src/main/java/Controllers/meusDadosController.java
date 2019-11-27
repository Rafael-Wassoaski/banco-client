package Controllers;

import java.io.IOException;

import database.AlunoDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Aluno;
import rojie.poo.ifsc.P1.App;

public class meusDadosController {

	   @FXML
	    private ListView<Aluno> listAluno;

	    @FXML
	    private Button btnApagarAlu;

	    @FXML
	    private Button btnSair;

	    @FXML
	    void ApagarAluno(ActionEvent event) {
	    	new AlunoDAO().delete((Aluno) listAluno.getSelectionModel().getSelectedItem());
	    }


	    @FXML
	    void Sair(ActionEvent event) throws IOException {
	    	FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("mainALuno.fxml"));
			Parent parent = fxmlLoader.load();
			Scene scene = new Scene(parent);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();

	    }
}
