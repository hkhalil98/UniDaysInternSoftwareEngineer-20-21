public class UseUnidays {

    public static void main(String[] args){

        final PricingRules PRICING_RULES = new PricingRules();
        UnidaysDiscountChallenge example = new UnidaysDiscountChallenge(PRICING_RULES);
        Price result;

        //Outputs the price rules in a short table
        System.out.println(PRICING_RULES.toString());


        // Variable declaration for example testing
        Item itemOne = new Item('E');
        Item itemTwo = new Item('E');
        Item itemThree = new Item('B');

        double totalPrice;
        double deliveryCharge;
        @SuppressWarnings("unused") // Used to suppress warning from use of example code
                double overallTotal;

        // Testing from GitHub specification example
        // Runs code verbatim to demonstrate desired functionality
        example = new UnidaysDiscountChallenge(PRICING_RULES);

        example.AddToBasket(itemOne);
        example.AddToBasket(itemTwo);
        example.AddToBasket(itemThree);

        result = example.CalculateTotalPrice();

        totalPrice = result.getTotal();
        deliveryCharge = result.getDeliveryCharge();
        overallTotal = totalPrice + deliveryCharge;
        // end of example implementation from GitHub

        System.out.printf("%-16s%-10s%-1s%-11s", " Items", "| Total", "| Delivery Charge", "| Overall Cost"); // Headers of output table
        // Stores string to display as a string from the manually-filled basket
        String displayString = example.basketToString();
        // outputs the baskets and the corresponding pricing
        testingOutput(displayString, result);


        // method used to display algorithmic functionality of program using given test cases

        runExampleTests(example, PRICING_RULES);
    }

    /* Efficient and simple method to test certain baskets
     *  Users write a string containing any combination of valid object types (A-->E)
     *  Does not return the Price object for each string, but rather just outputs
     *  Does not affect usual functionality, simply used to generate output for a large number of rest cases*/
    public static void runExampleTests(UnidaysDiscountChallenge example, PricingRules pricingRules){
        //	Outputs a series of headings to form a table once tests are run
        System.out.println("\n\nBaskets from runExampleTests()");
        System.out.printf("%-16s%-10s%-1s%-11s", " Items", "| Total", "| Delivery Charge", "| Overall Cost");

        // Runs multiple tests and produces output table
        testing("");
        testing("A");
        testing("B");
        testing("C");
        testing("D");
        testing("E");
        testing("BB");
        testing("BBB");
        testing("BBBB");
        testing("CCC");
        testing("CCCC");
        testing("DD");
        testing("DDD");
        testing("EE");
        testing("EEE");
        testing("EEEE");
        testing("DDDDDDDDDDDDDD");
        testing("BBBBCCC");
        testing("ABBCCCDDEE");
        testing("EDCBAEDCBC");
    }

    // Method used to separate items in strings from runExampleTests
    public static void testing(String itemString){
        // instantiate new instances of PricingRules and UnidaysDiscountChallenge
        PricingRules p = new PricingRules();
        UnidaysDiscountChallenge example = new UnidaysDiscountChallenge(p);
        // Array that holds item objects corresponding to characters in the array
        Item[] itemArray = new Item[itemString.length()];
        // Fills the itemArray with item objects corresponding to the string of item types
        for (int i = 0; i < itemString.length(); i++){
            itemArray[i] = new Item(itemString.charAt(i));
        }
        // Adds all values in the item list to the basket
        for (Item item : itemArray){
            example.AddToBasket(item);
        }
        // Creates instance of Price with values used from the calculation of the price
        Price result = example.CalculateTotalPrice();
        // outputs results in separate method for readability
        // Generates a table row for each of the strings entered
        testingOutput(itemString,result);
    }


    public static void testingOutput(String s, Price result){
        // outputs "None" if the basket is empty in place of the items
        if (s == ""){
            s = "None";
        }
        // outputs a row of data to contribute to testing table
        System.out.printf(String.format("\n%-16s", s) + result.toString());

    }
}
