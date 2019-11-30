package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Threads.ConexaoServer;
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
import model.InterfaceTherad;
import rojie.poo.ifsc.P1.App;

public class AguardeController implements Initializable {
	
	@FXML
	ProgressBar barra;
	@FXML
	Button cancelar;
	
	private String proxTela;
	
	public void setProxTela(String proxTela) {
		this.proxTela = proxTela;
	}

	private Thread threadConexao;
	private ConexaoServer clienteThread;
	
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
				try {
					Thread.currentThread().sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void conectar(String menssagemFora) {
		
		
		
		String menssagem = menssagemFora;
		ThreadBarra barraThread = new ThreadBarra();
		Thread threadBarra = new Thread(barraThread);
		threadBarra.start();
		clienteThread = new ConexaoServer(menssagem);
		threadConexao = new Thread(clienteThread);
		threadConexao.start();	
		
		while(menssagem.equals(clienteThread.getMenssagem())) {
			
			System.out.println(clienteThread.getMenssagem());
		}
			threadBarra.stop();
		try {
			
			carregarTela();			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void carregarTela() throws IOException{	
		
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(proxTela+".fxml"));
		Parent root = (Parent) fxmlLoader.load();
		InterfaceTherad controller = (InterfaceTherad)fxmlLoader.getController();
		controller.setResposta(clienteThread.getMenssagem());
		Stage stage = new Stage();
		stage.setScene(new Scene(root));
		stage.show();
		stage = (Stage) cancelar.getScene().getWindow();
		stage.close();
	}
	

}
