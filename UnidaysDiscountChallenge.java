import java.util.ArrayList;



    public class UnidaysDiscountChallenge{
        private ArrayList<Item> basket = new ArrayList<>();
        private PricingRules pricingRules;

        public UnidaysDiscountChallenge(PricingRules pricingRules){
            this.pricingRules = pricingRules;
        }

        public void AddToBasket(Item item){
            basket.add(item);
        }


        public Price CalculateTotalPrice() {
            // Instantiates variable to pass to new Price object
            double deliveryCharge = 0;
            double totalPrice= 0;

            int[] quantityArray = {0,0,0,0,0};
            final char[] INDEX_ARRAY = {'A','B','C','D','E'};

            // Uses conversions 'A' = 10 --> 'E' --> 14 to correctly total the quantities of each item
            for (Item item : basket){
                quantityArray[(Character.getNumericValue(item.getType()) - 10)] +=1;
            }
            // Applies discounts for each of the 5 different item types, adds returned values to totalPrice
            for (int i = 0; i<INDEX_ARRAY.length ; i++){
                totalPrice += pricingRules.applyDiscount(INDEX_ARRAY[i], quantityArray[i]);
            }
            // Adds a delivery charge if the price is <£50.00 and there are items in the basket
            if (totalPrice <50.00 && !(basket.isEmpty())) {
                deliveryCharge = 7.00;
            }

            return new Price(totalPrice, deliveryCharge);
        }

        public String basketToString(){
            String output = "";
            for (Item item : basket){
                output +=item.getType();

            }
            return output;
        }
    }

