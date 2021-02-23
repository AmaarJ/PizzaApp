package application;
import java.io.Serializable;

public class Pizza implements Serializable {
	
	/**
	 * This class implements a simple pizza with specific attributes namely:
	 * size, cheese type, pineapple, green pepper and ham. 
	 * @author Amaar Jivanji 
	 * Student ID: 17amj6
	 */
	private static final long serialVersionUID = -1183733532878987657L;
	private String size;
	private String cheese;
	private String pineapple;
	private String greenPepper;
	private String ham;
	/**
	 * This constructs a pizza with given attributes
	 * @param size the specified size; single or none
	 * @param cheese the specified cheese; single or none
	 * @param pineapple the specified pineapple; single or none
	 * @param greenPepper the specified green pepper; single or none
	 * @param ham the specified ham; single or none
	 * @throws IllegalPizza makes an exception if pizza attributes are not acceptable
	 */
	Pizza(String size, String cheese, String pineapple, String greenPepper, String ham) throws IllegalPizza{

		try {
			this.size = size.toLowerCase();
			this.cheese = cheese.toLowerCase();
			this.pineapple = pineapple.toLowerCase();
			this.greenPepper = greenPepper.toLowerCase();
			this.ham = ham.toLowerCase(); //make attribute value to lower case
			
		} catch(NullPointerException e) { //catching null exception
			throw new IllegalPizza("Null pointer exception caught");
		} 
		// if size is not small, medium or large
		if ((!this.size.equals("small")) && (!this.size.equals("medium")) && (!this.size.equals("large"))) {
			throw new IllegalPizza("pizza has to be small, medium or large");
		}
		// if ham is not none or single
		if (this.ham.equals("none") && (this.pineapple.equals("single") || greenPepper.contentEquals("single"))) {
			throw new IllegalPizza("cannot have green pepper or pineapple without ham"); 
		}

		if (!this.ham.equals("none") && !this.ham.equals("single")) {
			throw new IllegalPizza("ham has to be single or none");
		}
		
		if (!this.pineapple.equals("none") && !this.pineapple.equals("single")) {
			throw new IllegalPizza("pineapple has to be single or none");
		}
		
		if (!this.greenPepper.equals("none") && !this.greenPepper.equals("single")) {
			throw new IllegalPizza("green pepper has to be single or none");
		}
		
		if (!this.cheese.equals("single") && !this.cheese.equals("double") && !this.cheese.equals("triple")) {
			throw new IllegalPizza("cheese has to be single, double or triple");
		}
		

	}
	/**
	 * This is the default constructor for a pizza with 0 given attributes
	 */
	Pizza (){ // default constructor
		this.size = "small";
		this.cheese = "single"; 
		this.ham = "single";
		this.greenPepper = "none";
		this.pineapple = "none";
	}
	
	/**
	 * method calculates the cost of the pizza
	 * @return price of the pizza depending on the toppings and size of pizza
	 */
	public double getCost(){
		double price = 0;
		if (this.size.equals("small" )) {
			price = 7; //price = 7 if pizza is small
		}
		else if (this.size.equals("medium")){
			price = 9; //price = 9 if pizza is medium
		}
		else {
			price = 11;	 //price = 11 if pizza is large
		}
		
		if (this.cheese.equals("double")) {
			price += 1.5; //$1.5 for every additional topping
		}
		
		else if (this.cheese.equals("triple")) {
			price += 3.0;
		}
		
		if (this.pineapple.equals("single")) {
			price += 1.5;
		}
		
		if (this.greenPepper.equals("single")) {
			price += 1.5;
		}
		
		if (this.ham.equals("single")) {
			price += 1.5;
		}
		
		return price; //returning price of pizza
	
	}
	
	/** 
	 * method takes the given attributes of the pizza and returns a string
	 * @return pizza order in a string format
	 */
	public String toString() {
		String order = "";
		
		order += this.size + " pizza, ";
		
		order += this.cheese + " cheese";
		
		if (!this.pineapple.equals("none")) {
			order += ", pineapple";
		}

		
		if (!this.greenPepper.equals("none")) {
			order += ", green pepper"; // adds greenpepper if green pepper attribute is not none
		}
		
		
		if (!this.ham.equals("none")) {
			order += ", ham";
		}
		
		//Double cost = Double.valueOf(this.getCost());
		String cost = String.format("%.2f", this.getCost());
		
		order += ". Cost: $" + cost + " each."; 
		
		return order; //returns order as a string
		
	}
	/** 
	 * method compares two objects depending on whether two objects are equal in contents
	 * @return false or true 
	 */
    public boolean equals(Object object) {
        if (object instanceof Pizza) {
            Pizza pizza2 = (Pizza) object;
            if (this.toString().equals(pizza2.toString())) {
                return true; //if each attribute in both objects are the same, method returns true
            }
        }
        return false;
    }
	
    /**
     *method clones a pizza object and makes another duplicate pizza
     * @return an object with similar contents
     */
	public Pizza clone(){
		
		Pizza clonedPizza = null;
		try {
			clonedPizza = new Pizza(this.size, this.cheese, this.pineapple, this.greenPepper, this.ham);
		} catch (IllegalPizza e) {
			return null;
		}
		return clonedPizza;
		
	}
	
}
