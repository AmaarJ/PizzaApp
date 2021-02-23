package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.beans.property.StringProperty;

public class PizzaController {
	
	private String size = "Small"; 		//attributes to be passed as parameters in the Pizza Constructor
    private String cheese = "Single";
    private String ham = "None";
    private String greenPepper = "None";
    private String pineapple = "None";
    private double totalOrderCost = 0.00f;
	
	@FXML
    private TextArea displayOrderTextArea;

	@FXML
    private TextField numPizzaTextField;

    @FXML
    private TextField totalPizzaCostTextField;

    @FXML
    private TextField pizzaCostTextField;
    
    @FXML
    private TextField totalOrderCostTextField;

    
    @FXML
    private Button addToOrderButton;
    
    @FXML
    private ChoiceBox<String> sizeChoice = new ChoiceBox<>();
    
    @FXML
    private ChoiceBox<String> cheeseChoice = new ChoiceBox<>();
    
    @FXML
    private ChoiceBox<String> hamChoice = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> greenPepperChoice = new ChoiceBox<>();

    @FXML
    private ChoiceBox<String> pineappleChoice = new ChoiceBox<>();
    
    @FXML 				//sizeList, cheeseList, toppingList, and noneList give items to choose from in the GUI choiceBoxes
    private ObservableList<String> sizeList = FXCollections.observableArrayList("Small", "Medium", "Large");
    
    @FXML
    private ObservableList<String> cheeseList = FXCollections.observableArrayList("Single", "Double", "Triple");

    @FXML
    private ObservableList<String> toppingList = FXCollections.observableArrayList("None", "Single");

    @FXML
    private ObservableList<String> noneList = FXCollections.observableArrayList("None");

    @FXML
    void initialize() {
    	//set the initial value of size choice box to small
        sizeChoice.setValue("Small");
        //set the drop down menu to show "small", "medium", "large"
        sizeChoice.setItems(sizeList);
        //set the initial value of cheese choice box to single
        cheeseChoice.setValue("Single");
        //set the drop down menu to show "single", "double", "triple"
        cheeseChoice.setItems(cheeseList);
        //set the initial value of ham choice box to none
        hamChoice.setValue("None");
        //set the drop down menu to show "none" and "single"
        hamChoice.setItems(toppingList);
        //set the initial value of green pepper choice box to none 
        greenPepperChoice.setValue("None");
        greenPepperChoice.setItems(noneList); //shows none at the beginning if ham is none
        //set the initial value of pineapple choice box to none
        pineappleChoice.setValue("None");
        pineappleChoice.setItems(noneList); //shows none at the beginning is ham is none
        
        pizzaCostTextField.setText("7.00");
        numPizzaTextField.setText("1");
        sizeChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
        {
        	try {
        		size = newVal; //sets the size attribute to its new value, to be used in the Pizza constructor
        		
        		Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
    			LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
            	double pizzaCost = aLine.getCost();
            	pizzaCostTextField.setText(String.valueOf(pizzaCost));
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        });
        
        cheeseChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
        {
        	try {
        		cheese = newVal;	//sets the cheese attribute to its new value, to be used in the Pizza constructor
        		
        		Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
    			LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
            	double pizzaCost = aLine.getCost();
            	pizzaCostTextField.setText(String.valueOf(pizzaCost));
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        });

        hamChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
        {	
        	try {
        		ham = newVal;		//sets the ham attribute to its new value, to be used in the Pizza constructor
        		
        		switch (newVal) {	//checks to see if ham on the pizza or not,
              	case "None" :		//if not, the peppers and pineapple are removed from the pizza
                   	greenPepperChoice.setItems(noneList);
                   	greenPepperChoice.setValue("None");
                   	pineappleChoice.setItems(noneList);
                   	pineappleChoice.setValue("None");
                   	break;
              	case "Single" :
                  	greenPepperChoice.setItems(toppingList);
                  	greenPepperChoice.setValue("None");
                  	pineappleChoice.setItems(toppingList);
              		pineappleChoice.setValue("None");	
                    break;
                }
        		Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
    			LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
            	double pizzaCost = aLine.getCost();
            	pizzaCostTextField.setText(String.valueOf(pizzaCost));
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        });
        
        greenPepperChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
        {
        	try {
        		if (newVal != null) {		//checks to see if a valid new value was given
        			greenPepper = newVal;	//sets the greenPepper attribute to its new value, to be used in the Pizza constructor
        			
        			Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
        			LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
                	double pizzaCost = aLine.getCost();
                	pizzaCostTextField.setText(String.valueOf(pizzaCost));
        		}
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        });
        
        pineappleChoice.valueProperty().addListener((observableValue, oldVal, newVal) ->
        {
        	try {
        		if (newVal != null) { 	//checks to see if a valid new value was given
        			pineapple = newVal;	//sets the pineapple attribute to its new value, to be used in the Pizza constructor
        			
        			Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
            		LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
            		double pizzaCost = aLine.getCost();
            		pizzaCostTextField.setText(String.valueOf(pizzaCost));
        		}
        	} catch (Exception e) {
        		e.printStackTrace();
        	}
        });
        
        pizzaCostTextField.textProperty().addListener((observableValue, oldText, newText) ->
        {
        	try {
        		Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
    			double totalCost = aPizza.getCost();
        		pizzaCostTextField.setText(String.valueOf(totalCost));
        	} catch (Exception e) {
        		pizzaCostTextField.setText(String.format("$%.2f", 0.00f));
        	}
        	
        });
                
        numPizzaTextField.textProperty().addListener((observableValue, oldText, newText) ->
    	{
    		if (newText != null && !newText.isEmpty()) {
	    		try {
	    			int aVal = Integer.parseInt(newText);
	    			if (aVal < 1 || aVal > 100) {
	        			((StringProperty)observableValue).setValue(oldText);
	    			}
	    			try {
	            		Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
	        			LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
	        			double totalCost = aLine.getCost();
	            		totalPizzaCostTextField.setText(String.valueOf(totalCost));
	            	} catch (Exception e) {
	            		totalPizzaCostTextField.setText(String.format("$%.2f", 0.00f));
	            	}
	    		} catch (NumberFormatException e) {
	    			((StringProperty)observableValue).setValue(oldText);
	    		}
    		}
    	});
        
        addToOrderButton.setOnAction(event -> {
            try {
				Pizza aPizza = new Pizza(size, cheese, pineapple, greenPepper, ham); 
				LineItem aLine = new LineItem(Integer.parseInt(numPizzaTextField.getText()), aPizza);
				totalOrderCost += aLine.getCost();
				displayOrderTextArea.appendText(aLine.toString() + "\n"); 
				totalOrderCostTextField.setText(String.valueOf(totalOrderCost));
			} catch (IllegalPizza e) {
				e.printStackTrace();
			}
            size = "Small";
            sizeChoice.setValue("Small");  		//resetting all pizza orders after the user has clicked the add order button
            sizeChoice.setItems(sizeList);
            cheese = "Single";
            cheeseChoice.setValue("Single");
            cheeseChoice.setItems(cheeseList);
            greenPepper = "None";
            greenPepperChoice.setValue("None");
            greenPepperChoice.setItems(noneList);
            pineapple = "None";
            pineappleChoice.setValue("None");
            pineappleChoice.setItems(noneList);
            ham = "None";
            hamChoice.setValue("None");
            hamChoice.setItems(toppingList);
            pizzaCostTextField.setText("$7.00");
            numPizzaTextField.setText("1");
        });    
    }
}