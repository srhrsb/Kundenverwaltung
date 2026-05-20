module com.brh.kundenverwaltung {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.brh.kundenverwaltung to javafx.fxml;
    exports com.brh.kundenverwaltung;
}