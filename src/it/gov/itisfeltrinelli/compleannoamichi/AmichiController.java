/**
 * Sample Skeleton for 'AmichiView.fxml' Controller Class
 */

package it.gov.itisfeltrinelli.compleannoamichi;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import it.gov.itisfeltrinelli.amichi.AmichiList;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AmichiController {
	private AmichiList aml;

	public void setModel(AmichiList model) {
		aml = model;
	}

	@FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtDataNascita"
    private DatePicker txtDataNascita; // Value injected by FXMLLoader

    @FXML // fx:id="btCleanDate"
    private Button btCleanDate; // Value injected by FXMLLoader
    
    @FXML // fx:id="btmAction"
    private MenuButton btmAction; // Value injected by FXMLLoader

    @FXML // fx:id="miInserisci"
    private MenuItem miInserisci; // Value injected by FXMLLoader

    @FXML // fx:id="miCancella"
    private MenuItem miCancella; // Value injected by FXMLLoader

    @FXML // fx:id="btProssimo"
    private Button btProssimo; // Value injected by FXMLLoader

    @FXML // fx:id="txtAreaLog"
    private TextArea txtAreaLog; // Value injected by FXMLLoader

    @FXML
    void onAction(ActionEvent event) {
    	System.out.println("Azione");
    }
     
    @FXML
    void onCancella(ActionEvent event) {
    	System.out.println("Cancella");
    }

    @FXML
    void onInserisci(ActionEvent event) {
    	aml.AddAmico(txtNome.getText(), txtCognome.getText(), txtDataNascita.getValue());
    	aml.stampa();  //Debug
    }

    @FXML
    void onCleanDate(ActionEvent event) {
        txtDataNascita.setValue(null);
    }
    
    @FXML
    void onProsimo(ActionEvent event) {
    	System.out.println(txtDataNascita.getValue());
    }


    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'AmichiView.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'AmichiView.fxml'.";
        assert txtDataNascita != null : "fx:id=\"txtDataNascita\" was not injected: check your FXML file 'AmichiView.fxml'.";
        assert btmAction != null : "fx:id=\"btmAction\" was not injected: check your FXML file 'AmichiView.fxml'.";
        assert btProssimo != null : "fx:id=\"btProssimo\" was not injected: check your FXML file 'AmichiView.fxml'.";
        assert txtAreaLog != null : "fx:id=\"txtAreaLog\" was not injected: check your FXML file 'AmichiView.fxml'.";
        
        Image warningIcon = new Image(getClass().getResourceAsStream("icons/warning.png"));
        ImageView warningView = new ImageView(warningIcon);
        warningView.setFitWidth(15);
        warningView.setFitHeight(15);
        miCancella.setGraphic(warningView);
        
        txtDataNascita.setValue(null);
        
        //Bindings
        BooleanBinding txtNomeValid = Bindings.createBooleanBinding(() -> {
            return !txtNome.getText().isEmpty();}, txtNome.textProperty());
        BooleanBinding txtCognomeValid = Bindings.createBooleanBinding(() -> {
            return !txtCognome.getText().isEmpty();}, txtCognome.textProperty());
        BooleanBinding txtDataNascitaValid = Bindings.createBooleanBinding(() -> {
            return (txtDataNascita.getValue()!=null);}, txtDataNascita.valueProperty());
        btmAction.disableProperty().bind(txtNomeValid.not().or(txtCognomeValid.not()));
        //miInserisci.disableProperty().bind(txtNomeValid.not().or(txtCognomeValid.not()));
        miInserisci.disableProperty().bind(txtNomeValid.not().or(txtCognomeValid.not().or(txtDataNascitaValid.not())));
        btCleanDate.disableProperty().bind(txtDataNascitaValid.not());
    }
}
