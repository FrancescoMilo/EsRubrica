package it.polito.tdp.rubrica;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rubrica.model.RubricaModel;
import it.polito.tdp.rubrica.model.VoceRubrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RubricaController {
	
	//devo fare in modo che il model abbia un riferimento al modello
	// devo creare il modello e farlo conoscere al controller
	// lo creo nel main
	
	private RubricaModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtMail;

    @FXML
    private TextField txtTelefono;

    //@FXML
    //private Button bttCerca;

    @FXML
    private Button bttInserisci;
    
    @FXML
    private Label lblStato;
    
    @FXML
    private ComboBox cbxCerca;
    /*
    @FXML
    void doCerca(ActionEvent event) {
    	
    	String nome = txtNome.getText();
    	if(nome.length()==0){
    		lblStato.setText("Spacifica un nome!");
    	}
    	else{
    		VoceRubrica v = model.finVoceByNome(nome); //riga importante
    		if(v==null){
    			txtMail.clear();
    			txtTelefono.clear();
    			lblStato.setText("Nessun contatto trovato");
    		}
    		else{
    			txtMail.setText(v.getMail());
    			txtTelefono.setText(v.getTelefono());
    			lblStato.setText("Contatto trovato");
    		}
    	}

    }*/

    @FXML
    void doInserisci(ActionEvent event) {
    	// estrazione dai interfaccia
    	String nome = txtNome.getText();
    	String mail = txtMail.getText();
    	String telefono = txtTelefono.getText();
    	//validare i dati inseriti dall'utente
    	if(nome.length()==0 || (mail.length()==0 && telefono.length()==0)){
    		//errore
    		lblStato.setText("Dati Mancanti");
    	}
    	else{
    		//validi
    		boolean r1 = model.addVoce(new VoceRubrica(nome,mail,telefono));
    		
    		//aggiorna la vista. Il vero lavoro del modello
    		if(r1==false){
    			lblStato.setText("Voce già in elenco");
    		}
    		else{
    			cbxCerca.getItems().clear();
    			cbxCerca.getItems().addAll(model.getNomi());
    			lblStato.setText("Dati Aggiunti");
    		}
    	}
    }
    
    @FXML
    void doResearch(ActionEvent event) {
    	if(cbxCerca.getItems().size()>0){
    		String nome = (String) cbxCerca.getValue();
    		VoceRubrica v = model.finVoceByNome(nome); //riga importante
    		if(v==null){
    			txtMail.clear();
    			txtTelefono.clear();
    			lblStato.setText("Nessun contatto trovato");
    		}
    		else{
    			txtMail.setText(v.getMail());
    			txtTelefono.setText(v.getTelefono());
    			lblStato.setText("Contatto trovato");
    		}
    	}

    }
    
    public void setModel(RubricaModel model){
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtMail != null : "fx:id=\"txtMail\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";
        //assert bttCerca != null : "fx:id=\"bttCerca\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert bttInserisci != null : "fx:id=\"bttInserisci\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert cbxCerca != null : "fx:id=\"cbxCerca\" was not injected: check your FXML file 'Rubrica.fxml'.";
        
        
        
    }
}
