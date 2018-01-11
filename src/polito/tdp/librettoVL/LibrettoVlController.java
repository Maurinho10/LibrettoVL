/**
 * Sample Skeleton for 'LibrettoVL.fxml' Controller Class
 */

package polito.tdp.librettoVL;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import polito.tdp.librettoVL.model.Esame;
import polito.tdp.librettoVL.model.LibrettoModel;

public class LibrettoVlController {
	
	LibrettoModel librettoModel;
	
    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtCodice"
    private TextField txtCodice; // Value injected by FXMLLoader

    @FXML // fx:id="txtTitolo"
    private TextField txtTitolo; // Value injected by FXMLLoader

    @FXML // fx:id="txtDocente"
    private TextField txtDocente; // Value injected by FXMLLoader

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="btnCerca"
    private Button btnCerca; // Value injected by FXMLLoader

    @FXML // fx:id="txtMessage"
    private TextArea txtMessage; // Value injected by FXMLLoader

    @FXML
    void HandleInserisci(ActionEvent event) {
    	//txtMessage.clear();
    	// recupera i dati dall'interfaccia
    	String codice = txtCodice.getText();
    	String titolo = txtTitolo.getText();
    	String docente = txtTitolo.getText();
    	
    	// verifica la validità dei dati 
    	if( codice.length()<5 || titolo.length() == 0 || docente.length()== 0 ) {
    		txtMessage.appendText("Dati esame insufficienti\n");
    		return; 
    	}
    	// chiedi al Model di effettuare l'operazione 
    	Esame e = new Esame(codice, titolo, docente);
    	boolean result = librettoModel.addEsame(e);
    	
    	// aggiorna la vista con il risultato dell'operazione
    	if(result) {
    		txtMessage.appendText("Esame aggiunto correttamente\n");
    	} else {
    		txtMessage.appendText("Esame NON AGGIUNTO(codice duplicato)\n");
    	}
    }

    @FXML
    void handleCerca(ActionEvent event) {
    	String codice = txtCodice.getText();
    	
    	if(codice.length()<5) {
    		txtMessage.appendText("Dati esame insufficienti\n");
    		return; 
    	}
    	
    	Esame e = librettoModel.trovaEsame(codice);
    	
    	if(e==null) {
    		txtMessage.appendText("Codice "+codice+" non trovato\n");
    	} else {
    		txtMessage.appendText("Codice "+codice+" trovato\n");
    		
    		txtCodice.setText(e.getCodice());
    		txtTitolo.setText(e.getTitolo());
    		txtDocente.setText(e.getDocente());
    	}

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtCodice != null : "fx:id=\"txtCodice\" was not injected: check your FXML file 'LibrettoVL.fxml'.";
        assert txtTitolo != null : "fx:id=\"txtTitolo\" was not injected: check your FXML file 'LibrettoVL.fxml'.";
        assert txtDocente != null : "fx:id=\"txtDocente\" was not injected: check your FXML file 'LibrettoVL.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'LibrettoVL.fxml'.";
        assert btnCerca != null : "fx:id=\"btnCerca\" was not injected: check your FXML file 'LibrettoVL.fxml'.";
        assert txtMessage != null : "fx:id=\"txtMessage\" was not injected: check your FXML file 'LibrettoVL.fxml'.";

    }

	/**
	 * @param librettoModel the librettoModel to set
	 */
	public void setLibrettoModel(LibrettoModel librettoModel) {
		this.librettoModel = librettoModel;
	}
}
