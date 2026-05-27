package com.brh.kundenverwaltung;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

public class DialogUtils {


    /**
     * Zeigt Infomeldung als Dialog
     * @param text angezeigter Text
     */
    public static void showInfoDialog( String text ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText( text );
        alert.showAndWait();
    }

    /**
     * Zeigt Fehlermeldung als Dialog
     * @param text angezeigter Text
     */
    public static void showErrorDialog( String text ){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Fehler");
        alert.setContentText( text );
        alert.showAndWait();
    }

    /**
     * Zeigt Bestätigungsdialog
     * @param text angezeigter Text
     * @return true wenn ok gedrückt wurde
     */
    public static boolean showConfirmDialog( String text ){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Bitte bestätigen");
        alert.setContentText( text );

        Optional<ButtonType> result = alert.showAndWait();
        return result.filter(
                        buttonType -> buttonType == ButtonType.OK)
                .isPresent();
    }


}
