package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ConversionMachine {

    public GridPane spielStart () {

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10.0);
        gridPane.setVgap(10.0);

        Text text = new Text("Conversion Machine");
        text.setFont(Font.font("Arial", 35));
        gridPane.add(text, 0, 0, 2, 1);

        TextField mTextField = new TextField();
        mTextField.setTextFormatter(new TextFormatter<>(c -> {
            if (!c.getControlNewText().matches("\\d*"))
                return null;
            else
                return c;
        }
        ));
        gridPane.add(mTextField, 0, 4);

        Button btn = new Button("Calculate");
        gridPane.add(btn, 0, 9);

        Text input = new Text("From");
        gridPane.add(input, 0, 1);

        ComboBox comboBox = new ComboBox();

        comboBox.getItems().add("Meter");
        comboBox.getItems().add("Decimeter");
        comboBox.getItems().add("Cantimeter");
        gridPane.add(comboBox, 1, 2);

        Text output = new Text("To");
        gridPane.add(output, 1, 1);

        ComboBox comboBox1 = new ComboBox();

        comboBox1.getItems().add("Meter");
        comboBox1.getItems().add("Decimeter");
        comboBox1.getItems().add("Cantimeter");

        gridPane.add(comboBox1, 0, 2);
        Text result = new Text("Result: ");
        result.setFont(Font.font("Arial", 20));
        gridPane.add(result, 0, 7);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int input = comboBox1.getSelectionModel().getSelectedIndex();
                System.out.println("Selection made for input: " + input);
                int output = comboBox.getSelectionModel().getSelectedIndex();
                System.out.println("Selection made for output: " + output);

                if (input == 0 && output == 0) {
                    result.setText("Result: " + mTextField.getText() + " meter");
                } else if (input == 0 && output == 1) {
                    Double m = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + m * 10 + " decimeter");
                } else if (input == 0 && output == 2) {
                    Double m = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + m * 100 + " cantimeter");
                } else if (input == 1 && output == 0) {
                    Double dm = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + dm / 10 + " meter");
                } else if (input == 1 && output == 1) {
                    Double dm = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + dm + " decimeter");
                } else if (input == 1 && output == 2) {
                    Double dm = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + dm / 100 + " cantimeter");
                } else if (input == 2 && output == 0) {
                    Double cm = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + cm / 100 + " meter");
                } else if (input == 2 && output == 1) {
                    Double cm = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + cm / 10 + " decimeter");
                } else if (input == 2 && output == 2) {
                    Double cm = Double.parseDouble(mTextField.getText());
                    result.setText("Result: " + cm + " cantimeter");
                } else if (input == -1 && output == -1) {
                    Alert a = new Alert(Alert.AlertType.WARNING);
                    a.setHeaderText("Bitte wählen Sie input und output aus");
                    a.showAndWait();
                }
            }
        });

        gridPane.setStyle(
                "-fx-background-image: url(" +
                        "'/images/rechner.jpg'" + "); "
                        + "-fx-background-position: center;"
                        + "-fx-background-size:100% 100%;");
        gridPane.setAlignment(Pos.CENTER);

        return gridPane;
    }

}
