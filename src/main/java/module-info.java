module com.mycompany.imageproject {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.imageproject to javafx.fxml;
    exports com.mycompany.imageproject;
}
