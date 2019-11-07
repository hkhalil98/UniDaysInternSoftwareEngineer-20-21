// the purpose of this class is to implement the key methods that will called later in the UseUnidays class's main method.

public class Price {

    // private instance variables that will be accessed via accessor methods.
    private double Total;
    private double DeliveryCharge;


    public double getTotal() {
        return Total;
    } // accessor (get) methods

    public double getDeliveryCharge() {
        return DeliveryCharge;
    }

    public Price(double Total, double DeliveryCharge) {

        this.Total = Total;
        this.DeliveryCharge = DeliveryCharge;

    } // constructor

    public String toString(){
        return String.format("|£%-8.2f|£%-15.2f|£%-13.2f", Total, DeliveryCharge, Total+DeliveryCharge);
    } // toString method
}
