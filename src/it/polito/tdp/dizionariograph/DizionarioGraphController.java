package it.polito.tdp.dizionariograph;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.dizionariograph.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class DizionarioGraphController {
	
	Model model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNumeroLettere;

    @FXML
    private TextField txtParolaCercare;

    @FXML
    private Button btnGenera;

    @FXML
    private Button btnVicini;

    @FXML
    private Button btnGradoMax;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnReset;

    @FXML
    void doGeneraGrafo(ActionEvent event) {
    	
    	try {
    	
    		int num = Integer.parseInt(this.txtNumeroLettere.getText());
    		
    		model.creaGrafo(num);
    		
    		this.txtArea.appendText("CREATI VERTICI "+model.getVertexSize()+" E ARCHI "+model.getEdgeSize()+"\n");
    		
    	}catch(NumberFormatException e) {
    		this.txtArea.appendText("Attenzione non hai inserito un numero!\n");
    	}

    }

    @FXML
    void doReset(ActionEvent event) {
    	this.txtArea.clear();
    	this.txtNumeroLettere.clear();
    	this.txtParolaCercare.clear();
    }

    @FXML
    void doTrovaGradoMax(ActionEvent event) {
    	
    	this.txtArea.appendText("Il nodo seguente ha il numero massimo di archi collegati: "+model.findMaxDegree()+"\n");

    }

    @FXML
    void doTrovaVicini(ActionEvent event) {
    	
    	if(this.txtParolaCercare.getText().length()==Integer.parseInt(this.txtNumeroLettere.getText())) {
    	
    	List<String> lista = model.displayNeighbours(this.txtParolaCercare.getText().toLowerCase());
    	
    	if(lista!=null) {
    		txtArea.appendText("I nodi contingenti alla parola inserita "+this.txtParolaCercare.getText()+" sono i seguenti "+lista+"\n");
    	}else {
    		txtArea.appendText("Attenzione! La parola inserita non è presente nel dizionario.\n");
    	}
    	}else {
    		txtArea.appendText("Attenzione! Hai inserito un njumero di lettere superiore.\n");
    	}

    }

    @FXML
    void initialize() {
        assert txtNumeroLettere != null : "fx:id=\"txtNumeroLettere\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtParolaCercare != null : "fx:id=\"txtParolaCercare\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGenera != null : "fx:id=\"btnGenera\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnVicini != null : "fx:id=\"btnVicini\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnGradoMax != null : "fx:id=\"btnGradoMax\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'DizionarioGraph.fxml'.";

    }

	public void setModel(Model model) {
		this.model=model;		
	}
}
