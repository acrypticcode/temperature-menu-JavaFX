/*Creates a GUI that allows the user to convert temperatures from Celsius
to Fahrenheit and back again
 */
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.geometry.Pos;


public class Project8_flanders extends Application{
    public int farToCel(int far) {
        //converts a Fahrenheit temperature to Celsius
        return (far - 32) * 5/9;
    }
    public int celToFar(int cel){
        //converts a Celsius temperature to Fahrenheit;
        return (cel * 9/5 + 32);
    }

    @Override
    public void start(Stage primaryStage){
        //creates javafx objects
        Label temp_lbl = new Label("Temperature:");
        Label result_lbl = new Label("Results:");
        TextField temp_fld = new TextField("0");
        TextField result_fld = new TextField();
        Button cToF_btn = new Button("Celsius to Fahrenheit");
        Button fToC_btn = new Button("Fahrenheit to Celsius");
        GridPane pane = new GridPane();
        Scene scene = new Scene(pane, 500,200);

        //adds correct positioning and format to objects
        temp_fld.setMaxWidth(200);
        result_fld.setMaxWidth(200);
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);
        GridPane.setHalignment(temp_lbl, HPos.CENTER);
        GridPane.setHalignment(result_lbl,HPos.CENTER);
        GridPane.setHalignment(fToC_btn,HPos.RIGHT);

        //places controls on pane
        pane.add(temp_lbl,0,0);
        pane.add(cToF_btn,0,1);
        pane.add(result_lbl,0,2);
        pane.add(temp_fld,1,0);
        pane.add(fToC_btn,1,1);
        pane.add(result_fld,1,2);

        //prevents user from changing value displayed on output text field
        result_fld.setEditable(false);

        //adds event handlers for buttons
        cToF_btn.setOnAction(event -> {
            try {
                result_fld.setText(Integer.toString(celToFar(Integer.parseInt(temp_fld.getText()))));
            }
            catch (NumberFormatException numFormEx)
            {
                result_fld.setText("Not a valid number!");
            }
        });
        fToC_btn.setOnAction(event -> {
            try {
                result_fld.setText(Integer.toString(farToCel(Integer.parseInt(temp_fld.getText()))));
            }
            catch (NumberFormatException numFormEx){
                result_fld.setText("Not a valid number!");
            }
        });

        //puts scene on stage and opens stage window
        primaryStage.setTitle("Celsius and Fahrenheit Conversion");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
