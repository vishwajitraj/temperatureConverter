module com.example.temp.temperatureconverter {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.temp.temperatureconverter to javafx.fxml;
    exports com.example.temp.temperatureconverter;
}