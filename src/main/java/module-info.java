module edu.srjc.gonzalez.michael.final_gonzalez_michael {
    requires javafx.controls;
    requires javafx.fxml;


    opens edu.srjc.gonzalez.michael.final_gonzalez_michael to javafx.fxml;
    exports edu.srjc.gonzalez.michael.final_gonzalez_michael;
}