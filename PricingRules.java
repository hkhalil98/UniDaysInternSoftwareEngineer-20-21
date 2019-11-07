import java.util.HashMap;

// here i have implemented a hashmap as it the best data structure to hold key value pairs.
// it references the item's price and the discount applied to it.

public class PricingRules {


    //@SuppressWarnings("serial")
    private HashMap<Character, Double> RULES = new HashMap<Character, Double>()
    {{
        put('A', 8.00);		// No discount applied for this price.
        put('B', 12.00);	// 2 for £20.00 discount will be applied.
        put('C', 4.00);		// 3 for £10.00 discount will be applied.
        put('D', 7.00);		// Buy 1 get 1 free offer.
        put('E', 5.00);		// 3 for the price of 2 offer.
    }};


    /*Applies discount for each type of item in basket
     * Takes the type of Item and the switch statement applies
     * the discount based on the quantity of each item given
     */
    public double applyDiscount(char itemType, int quantity){
        // Initially set appliedPrice to zero
        double appliedPrice = 0;
        // Set the price value to the
        double price = RULES.get(itemType);
        // Switch statement by character representing item type
        switch (itemType) {

            /*switch (case) statement is the most efficient way of matching the item to its associated discount rather
            than using if statements which would be tedious and messy.
             */

            case 'B':	// 2 for £20.00
                appliedPrice = (20.00 * (quantity/2)) + (price * (quantity%2));
                break;

            case 'C':	// 3 for £10.00
                appliedPrice = (10.00 * (quantity/3)) + (price * (quantity%3));
                break;

            case 'D':   // Buy 1 get 1 free
                appliedPrice = (price * (quantity/2)) + (price * (quantity%2));
                break;

            case 'E':	// 3 for the price of 2
                appliedPrice = (price*quantity) - (price *(quantity/3));
                break;

            default:	// No discount applied (Case A )
                appliedPrice = (price*quantity);
        }
        return appliedPrice;
    }

    @Override // Option to output the price rules for readability
    public String toString(){
        String output = "Item\tPrice\n";
        for (char key : RULES.keySet()){
            output +=String.format("%-8s£%-8.2f\n",key,RULES.get(key) );		}

        return output;

    }
    public HashMap<Character, Double> getRules() {
        return RULES;
    }
}
