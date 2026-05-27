package com.brh.kundenverwaltung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller {

    //add data tab-----------------------------
    @FXML
    private TextField idTf;
    @FXML
    private TextField nameTf;
    @FXML
    private TextField firstnameTf;
    @FXML
    private TextField streetTf;
    @FXML
    private TextField numberTf;
    @FXML
    private TextField placeTf;
    @FXML
    private TextField postcodeTf;

    //change data tab--------------------------------------
    @FXML
    private TextField idChangeTf;
    @FXML
    private TextField nameChangeTf;
    @FXML
    private TextField firstnameChangeTf;
    @FXML
    private TextField streetChangeTf;
    @FXML
    private TextField numberChangeTf;
    @FXML
    private TextField placeChangeTf;
    @FXML
    private TextField postcodeChangeTf;
    @FXML
    private Button changeButton;

    private CustomerDAO dao;
    private static final Logger LOGGER = Logger.
            getLogger(Controller.class.getName());

    @FXML
    private void initialize(){
        dao = new TempDAO();
        LOGGER.addHandler(App.getLogFileHandler());

        setControlsActive(false, nameChangeTf,
                                 firstnameChangeTf,
                                 streetChangeTf,
                                 numberChangeTf,
                                 placeChangeTf,
                                 postcodeChangeTf,
                                 changeButton
                          );
    }

    @FXML
    private void onClickAddData(ActionEvent event) {
        LOGGER.log(Level.INFO, "Add Data clicked");

        if(!validateTextFields(idTf, nameTf, firstnameTf,
                            streetTf, numberTf, placeTf, postcodeTf)){
            LOGGER.log(Level.SEVERE, "Kunde konnte nicht hinzugefügt werden, " +
                       "ungültige Eingabedaten");

            return;
        }

        boolean success = dao.addCustomer(
              idTf.getText(),
              nameTf.getText(),
              firstnameTf.getText(),
              streetTf.getText(),
              numberTf.getText(),
              placeTf.getText(),
              postcodeTf.getText()
        );

        if(success){
            //ToDo: Feedback in Info Dialog
        }
        else{
            //ToDo: Feedback in Error Dialog
        }
    }

    @FXML
    private void onClickSearch(ActionEvent event) {
        LOGGER.log(Level.INFO, "Search clicked");

        if (!validateTextFields(idChangeTf)) {
            LOGGER.log(Level.WARNING, "Kunde konnte nicht gesucht werden, " +
                    "ungültige id eingegeben");
            //ToDo: Fehler an Nutzerausgaben
            return;
        }

        Optional<Customer> customerOptional = dao.getCustomerById(idChangeTf.getText());

        if (customerOptional.isEmpty()) {
            LOGGER.log(Level.WARNING, "Ungültiges Kundenobjekt, Optional ist leer");
            //ToDo: Infomeldung als Dialog
            return;
        }

//        customerOptional.ifPresent( customer -> {
//            nameChangeTf.setText(customer.getName());
//            firstnameChangeTf.setText(customer.getFirstname());
//            streetChangeTf.setText(customer.getStreet());
//            numberChangeTf.setText(customer.getNumber());
//            placeChangeTf.setText(customer.getPlace());
//            postcodeChangeTf.setText(customer.getPostcode());
//            LOGGER.log(Level.INFO, "Kundendaten eingetragen");
//
//        });

        setControlsActive(true, nameChangeTf,
                firstnameChangeTf,
                streetChangeTf,
                numberChangeTf,
                placeChangeTf,
                postcodeChangeTf,
                changeButton
        );

            Customer customer = customerOptional.get();
            nameChangeTf.setText(customer.getName());
            firstnameChangeTf.setText(customer.getFirstname());
            streetChangeTf.setText(customer.getStreet());
            numberChangeTf.setText(customer.getNumber());
            placeChangeTf.setText(customer.getPlace());
            postcodeChangeTf.setText(customer.getPostcode());
            LOGGER.log(Level.INFO, "Kundendaten eingetragen");





    }

    @FXML
    private void onClickChangeData(ActionEvent event) {
        LOGGER.log(Level.INFO, "Change Data clicked");

        if(!validateTextFields(idChangeTf, nameChangeTf, firstnameChangeTf,
                streetChangeTf, numberChangeTf, placeChangeTf, postcodeChangeTf)){
            LOGGER.log(Level.SEVERE, "Kunde konnte nicht verändert werden, " +
                    "ungültige Eingabedaten");

            return;
        }

        boolean success = dao.changeCustomerById(
                idChangeTf.getText(),
                nameChangeTf.getText(),
                firstnameChangeTf.getText(),
                streetChangeTf.getText(),
                numberChangeTf.getText(),
                placeChangeTf.getText(),
                postcodeChangeTf.getText()
        );

        if(success){
            //ToDo: Feedback in Info Dialog
        }
        else{
            //ToDo: Feedback in Error Dialog
        }
    }

    private boolean validateTextFields( TextField... textFields){
        boolean isValid = true;
        for( var textField : textFields ){
            if(textField.getText().trim().length() < 2 ){
               isValid  = false;
               LOGGER.log( Level.WARNING,
                       "Texteingabe ungültig Textfeld:" + textField);
            }
        }
        return isValid;
    }

    private void setControlsActive(boolean active, Control... elements){
        for( Control e : elements)
            e.setDisable(!active);
    }
}
