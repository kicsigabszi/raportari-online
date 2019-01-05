package application;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import automationFramework.Document;
import automationFramework.SeleniumCommands;
import wordDoc.WordDoc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.Node;


public class Controller {
	protected SeleniumCommands selenium = SeleniumCommands.getInstance();
	
	@FXML protected GridPane gridPane2;
	@FXML protected ChoiceBox<String> crTipDocument;
	@FXML protected TextField crNrDocument;
	@FXML protected TextField crNrFoaie;
	@FXML protected TextField crCirc1;
	@FXML protected TextField crCirc2;
	@FXML protected TextField crCirc3;
	@FXML protected ChoiceBox<Bus> crBus;
	@FXML protected TextField crNrLocuri;
	@FXML protected TextField crNumeSofer1;
	@FXML protected TextField crCnpSofer1;
	@FXML protected ChoiceBox<Driver> crSofer1;
	@FXML protected TextField crNumeSofer2;
	@FXML protected TextField crCnpSofer2;
	@FXML protected ChoiceBox<Driver> crSofer2;
	@FXML protected DatePicker crDataCompletarii;
	@FXML protected DatePicker crDataTransport;
	@FXML protected DatePicker crDataEndTransport;
	@FXML protected TextField crLocPlecare;
	@FXML protected TextField crLocSosire;
	@FXML protected FileChooser fileChooser;
	@FXML protected Text message;
	@FXML protected Button completarePasageriBtn;
	protected Document document;
	
	@FXML
	private void initialize()
	{
		StringConverter<Bus> converter = new StringConverter<Bus>() {
            @Override
            public String toString(Bus object) {
                return object.getValue();
            }

            @Override
            public Bus fromString(String string) {
                return null;
            }
        };
        crBus.setConverter(converter);
        
        
        StringConverter<Driver> converter2 = new StringConverter<Driver>() {
            @Override
            public String toString(Driver object) {
                return object.getValue();
            }

            @Override
            public Driver fromString(String string) {
                return null;
            }
        };
        crSofer1.setConverter(converter2);
        crSofer2.setConverter(converter2);

	}
	
	@FXML protected void busSelection(ActionEvent event) {
		String[] nrInmatriculare = crBus.getValue().getNrInmatriculare();
		int nrLocuri = crBus.getValue().getNrLocuri(); 
		crCirc1.setText(nrInmatriculare[0]);
		crCirc2.setText(nrInmatriculare[1]);
		crCirc3.setText(nrInmatriculare[2]);
		crNrLocuri.setText(Integer.toString(nrLocuri));
	}
	
	@FXML protected void sofer1Selection(ActionEvent event) {
		String name = crSofer1.getValue().getValue();
		String cnp = crSofer1.getValue().getCnp(); 
		crNumeSofer1.setText(name);
		crCnpSofer1.setText(cnp);
	}
	
	@FXML protected void sofer2Selection(ActionEvent event) {
		String name = crSofer2.getValue().getValue();
		String cnp = crSofer2.getValue().getCnp(); 
		crNumeSofer2.setText(name);
		crCnpSofer2.setText(cnp);
	}
	
	
	@FXML protected void handleShowPassengerScene(ActionEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("PassengerScene.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            //stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
            Scene scene = new Scene(root1, primScreenBounds.getWidth(), primScreenBounds.getHeight() - 50);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setTitle("Completare Pasageri");
            stage.setScene(scene);  
            stage.show();
		}
		catch(Exception e) {
	           e.printStackTrace();
	    }
	}

	
	@FXML protected void handleCompletareRegistruSalvareButtonAction(ActionEvent event) {
		 
		 boolean validationFlag = true;
		 String val = crTipDocument.getValue(); 
		 Map<String, String> inpMap = new HashMap<String, String>(); 
		 
		 if( val == null || val.isEmpty()) {
			 crTipDocument.getStyleClass().add("invalidValue");
			 //validationFlag = false;
		 }
		 else
		 {
			 crTipDocument.getStyleClass().remove("invalidValue");
			 inpMap.put("tip_doc_ctr", val);
		 }
		 
		 val = crNrDocument.getText();
		 if( val == null || val.isEmpty()) {
			 crNrDocument.getStyleClass().add("invalidValue");
			 //validationFlag = false;
		 }
		 else
		 {
			 crNrDocument.getStyleClass().remove("invalidValue");
			 inpMap.put("nr_doc_ctr", val);
		 }
		 
		 val = crNrFoaie.getText();
		 if( val == null || val.isEmpty()) {
			 crNrFoaie.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crNrFoaie.getStyleClass().remove("invalidValue");
			 inpMap.put("nr_foaie", val);
		 }
		 
		 val = crCirc1.getText();
		 if( val == null || val.isEmpty()) {
			 crCirc1.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crCirc1.getStyleClass().remove("invalidValue");
			 inpMap.put("nr_circ1", val);
		 }
		 
		 val = crCirc2.getText();
		 if( val == null || val.isEmpty()) {
			 crCirc2.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crCirc2.getStyleClass().remove("invalidValue");
			 inpMap.put("nr_circ2", val);
		 }
		 
		 val = crCirc3.getText();
		 if( val == null || val.isEmpty()) {
			 crCirc3.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crCirc3.getStyleClass().remove("invalidValue");
			 inpMap.put("nr_circ3", val);
		 }
		 
		 val = crNrLocuri.getText();
		 if( val == null || val.isEmpty()) {
			 crNrLocuri.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crNrLocuri.getStyleClass().remove("invalidValue");
			 inpMap.put("locuri", val);
		 }
		 
		 val = crNumeSofer1.getText();
		 if( val == null || val.isEmpty()) {
			 crNumeSofer1.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crNumeSofer1.getStyleClass().remove("invalidValue");
			 inpMap.put("nume1", val);
		 }
		 
		 val = crCnpSofer1.getText();
		 if( val == null || val.isEmpty()) {
			 crCnpSofer1.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crCnpSofer1.getStyleClass().remove("invalidValue");
			 inpMap.put("cnp1", val);
		 }
		 
		 val = crNumeSofer2.getText();
		 if( val != null && !val.isEmpty()) {
			 inpMap.put("nume2", val);
		 }
		 else
		 {
			 inpMap.put("nume2", "");
		 }
		 
		 val = crCnpSofer2.getText();
		 if( val != null && !val.isEmpty()) {
			 inpMap.put("cnp2", val);
		 }
		 else
		 {
			 inpMap.put("cnp2", "");
		 }
		 
		 LocalDate val2 = crDataTransport.getValue();
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 if(val2 == null) {
			 crDataTransport.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crDataTransport.getStyleClass().remove("invalidValue");
			 inpMap.put("data_t", val2.format(formatter));
		 }
		 
		 
		 val2 = crDataEndTransport.getValue();
		 if( val2 == null) {
			 crDataEndTransport.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crDataEndTransport.getStyleClass().remove("invalidValue");
			 inpMap.put("data_t2", val2.format(formatter));
		 }
		 
		 val = crLocPlecare.getText();
		 if( val == null || val.isEmpty()) {
			 crLocPlecare.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crLocPlecare.getStyleClass().remove("invalidValue");
			 inpMap.put("loc_p", val);
		 }
		 
		 val = crLocSosire.getText();
		 if( val == null || val.isEmpty()) {
			 crLocSosire.getStyleClass().add("invalidValue");
			 validationFlag = false;
		 }
		 else
		 {
			 crLocSosire.getStyleClass().remove("invalidValue");
			 inpMap.put("loc_s", val);
		 }
		
		 //Validation problem
		 if(!validationFlag) return;
		 
		 
		 String currentTime = getCurrentTimeStamp();
		 inpMap.put("data_c", currentTime);
		 
		 //Init Document
		 String nrCirc = crCirc1.getText().concat("-").concat(crCirc2.getText()).concat("-").concat(crCirc3.getText());
		 LocalDate dataTransp = crDataTransport.getValue();
		 formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 String strDataTransport = dataTransp.format(formatter).concat(" 00:00:00");
		 document = new Document(crNrDocument.getText(),crNrFoaie.getText(),nrCirc, strDataTransport);
		 
		 boolean success = selenium.saveDocumentControl(inpMap);
		 
		 if(success == true)
		 {
			 message.setVisible(true);
			 completarePasageriBtn.setVisible(true);
		 }
	 }
	 
	 @FXML protected void handleLoginButtonAction(ActionEvent event) throws IOException {
		
		//Login
		selenium.login();
		 
		//Show "Completare Registru" screen
		Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml"));
			
		Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
		Scene scene = new Scene(root, primScreenBounds.getWidth() - 50, primScreenBounds.getHeight());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		Stage appStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		appStage.setTitle("Raportãri Online");
		appStage.setScene(scene);
		appStage.show(); 
	 }
	 
	 public static String getCurrentTimeStamp() {
		    SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		    return strDate;
		}
}
