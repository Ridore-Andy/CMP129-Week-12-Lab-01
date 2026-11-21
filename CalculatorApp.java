import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
public class CalculatorApp extends Application 
{
    String selectedOperator = "+";
    @Override
    public void start(Stage primaryStage)
    {
        // TextFields for input and output
        TextField numText1 = new TextField();
        numText1.setPromptText("Enter first number");

        TextField numText2 = new TextField();
        numText2.setPromptText("Enter second number");

        TextField numResult = new TextField();
        numResult.setEditable(false);
        numResult.setPromptText("Result");

        // Buttons for addition, subtraction, multiplication, and division
        Button addButton = new Button("+");
        Button subButton = new Button("-");
        Button mulButton = new Button("*");
        Button divButton = new Button("/");
        Button clearButton = new Button("C");
        Button sumButton = new Button("Calculate");

        // Operator button event handlers
        addButton.setOnAction(event -> {
            selectedOperator = "+";
            numResult.setText("Selected: +");
        });

        subButton.setOnAction(event -> {
            selectedOperator = "-";
            numResult.setText("Selected: -");
        });

        mulButton.setOnAction(event -> {
            selectedOperator = "*";
            numResult.setText("Selected: *");
        });

        divButton.setOnAction(event -> {
            selectedOperator = "/";
            numResult.setText("Selected: /");
        });

        // Clear button event handler
        clearButton.setOnAction(event -> {
            numText1.clear();
            numText2.clear();
            numResult.clear();
            selectedOperator = "+";
        });

        // Calculate button mechanics
        sumButton.setOnAction(event -> {
            try {
                double num1 = Double.parseDouble(numText1.getText());
                double num2 = Double.parseDouble(numText2.getText());
                double result = 0;

                if (selectedOperator.equals("+")) 
                {result = num1 + num2;} 
                else if (selectedOperator.equals("-")) 
                {result = num1 - num2;} 
                else if (selectedOperator.equals("*")) 
                {result = num1 * num2;} 
                else if (selectedOperator.equals("/")) 
                {
                    
                    if (num2 == 0) 
                    {
                        numResult.setText("Cannot divide by zero!");
                        return;
                    }
                    result = num1 / num2;
                }
                numResult.setText(String.valueOf(result));
            } 
            
            catch (NumberFormatException e) 
            {numResult.setText("Invalid input!");}
        });

        VBox vbox = new VBox(15, numText1, numText2, addButton, subButton, mulButton, divButton, clearButton, sumButton, numResult);

        Scene scene = new Scene(vbox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CalculatorApp");
        primaryStage.show();
    }

    public static void main(String[] args) 
    {launch(args);}
}