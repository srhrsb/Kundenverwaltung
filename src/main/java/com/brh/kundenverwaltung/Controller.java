package com.brh.kundenverwaltung;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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

    private CustomerDAO dao;

    @FXML
    private void initialize(){
        dao = new TempDAO();
        dao.addCustomer("","","","", "", null,"");
    }

    @FXML
    private void onClickAddData(ActionEvent event) {






    }

    @FXML
    private void onClickSearch(ActionEvent event) {


    }
    @FXML
    private void onClickChangeData(ActionEvent event) {


    }
}
