package application;
import java.io.Serializable;

public class LineItem implements Serializable, Comparable<LineItem>{
	
	/**
	 * class implements a line item for one of the orders
	 * @author Amaar Jivanji
	 * student ID 17amj6
	 */
	private static final long serialVersionUID = 1L;
	private int number;
	private Pizza pizza;
	
	/**
	 * constructs a line with the number of a given pizza and its contents
	 * pointer to the object pizza in pizza class
	 * @param number the number of pizzas ordered
	 * @param pizza1 the pizza contents
	 * @throws IllegalPizza throws an exception for an invalid parameter or attribute
	 */
	
	LineItem(int number, Pizza pizza1) throws IllegalPizza {
		
		if (pizza1 == null) {
			throw new IllegalPizza("Null pointer exception caught");
		}
		// if number of pizzas ordered is more than 100 or less than 1
		else if (number < 1 || number > 100) {
			throw new IllegalPizza("number of pizzas ordered should be between 1 and 100 inclusive");
		
		} else {
		
			this.number = number;
			this.pizza = pizza1;
		}
		
		
	}
	
	/**
	 * constructs a default single pizza 
	 * @param pizza1 the pizza object
	 * @throws IllegalPizza throws an exception if pizza object is null
	 */
	
	LineItem(Pizza pizza1) throws IllegalPizza {
		
		if (pizza1 == null) {
			throw new IllegalPizza("null pointer exception caught");
		} else {
			this.setNumber(1);
			this.pizza = pizza1;
		}

	}

	/**
	 * getter for the number of pizzas ordered
	 * @return the number of pizzas ordered
	 */
	public int getNumber() {
		return this.number;
	}

	/**
	 * method has an accessor sets the number of pizzas to a given number 
	 * @param number the number of pizzas order
	 * @throws IllegalPizza throws exception if pizzas ordered is less than 1 or greater than 100
	 */
	public void setNumber(int number) throws IllegalPizza{
		
		
		if (number < 1 || number > 100) {
			throw new IllegalPizza("number of pizzas ordered should be between 1 and 100 inclusive");
		}
		
		this.number = number;
		
	}
	
	/**
	 * getter method to return the pizza object
	 * @return the pizza object
	 */

	public Pizza getPizza() {
		return pizza;
	}
	
	/**
	 * method calculates the pizza total depending on the number of pizzas and discounts
	 * @return the price of pizzas ordered (total)
	 */
	public double getCost() {
		double price = 0;
		//10% discount
		if (this.number>=10 && this.number<=20) {
			price += 0.9 * this.pizza.getCost() * this.number;
		}
		//15% discount
		else if (this.number>20 && this.number <101) {
			price += 0.85 * this.pizza.getCost() * this.number;
		}
		//if pizzas ordered is less than 10
		else {
			price += this.pizza.getCost()*this.number;
		}
		
		return price;
	}
	
	/**
	 * method concatenates the number of pizzas and the pizza object
	 * @return string with pizza and number of pizzas ordered
	 */
	public String toString() {
		
		String str = this.number + " " + this.pizza.toString();
		
		if (this.number < 10) {
			str = " " + str;
		}
		
		return str;
		
		
	}
	
	/**
	 * method compares two objects based on their cost
	 * @return returns 0,-1, or 1 depending on the comparison
	 */
	public int compareTo(LineItem item2) {
		if (Math.abs(this.getCost() - item2.getCost()) < 1) {
			return 0;
		}
		if (this.getCost() > item2.getCost()) {
			return -1;
		} else if (item2.getCost() > this.getCost())  {
			return 1;
		}
		
		else {
			return 1;
		}
		
	}
	
}
	
	