module com.ricomuh.perpustakaan {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.ricomuh.perpustakaan to javafx.fxml;
    exports com.ricomuh.perpustakaan;
}
