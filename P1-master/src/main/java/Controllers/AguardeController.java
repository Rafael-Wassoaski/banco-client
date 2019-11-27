package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Threads.BuscaCursos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import model.Curso;
import rojie.poo.ifsc.P1.App;

public class AguardeController implements Initializable {
	
	@FXML
	ProgressBar barra;
	@FXML
	Button cancelar;
	
	private Thread threadConexao;
	private List<String> listCursos = new ArrayList<>();
	
	public class ThreadBarra implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			double progesso = 0;
			while(threadConexao.isAlive()) {
				barra.setProgress(progesso);
				progesso+=0.05;
				if(barra.getProgress() >= 1.0) {
					progesso = 0;
				}
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		
		String menssagem = "Cursos@";
		ThreadBarra barraThread = new ThreadBarra();
		Thread threadBarra = new Thread(barraThread);
		threadBarra.start();
		BuscaCursos clienteThread = new BuscaCursos(menssagem);
		threadConexao = new Thread(clienteThread);
		threadConexao.start();
		
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		while(menssagem.equals(clienteThread.getMenssagem()));
			threadBarra.stop();
		
		
		try {
			
			
			String[] resposta = clienteThread.getMenssagem().split("/");
			for(String cursoString : resposta) {
				String[] cursoFormatado = cursoString.split("-");
				listCursos.add(cursoFormatado[0]+"-"+cursoFormatado[2]);
				
			}
			carregarTela();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public void carregarTela() throws IOException{	
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("cadastro.fxml"));
		Parent root = (Parent) fxmlLoader.load();
		CadastroController controller = (CadastroController)fxmlLoader.getController();
		controller.setcmbUserCurso(listCursos);
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) cancelar.getScene().getWindow();
		stage.close();
	}
	

}
