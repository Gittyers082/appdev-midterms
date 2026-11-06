package appdev.refactor;

/**
 * REFACTORING EXERCISE - this class WORKS, but it smells. A lot.
 * Read REFACTORING.md before touching anything.
 */
public class OrderProcessor {

    private double tempSubtotal;

    // processes an order and returns the receipt text
    public String processOrder(String customerName, String customerEmail, String customerPhone,
                               String customerType, String itemName, double price, int qty,
                               String region) {
        // check the inputs first
        // the name must not be null or empty
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        // price must be positive
        if (price <= 0) {
            throw new IllegalArgumentException("Bad price");
        }
        // quantity must be positive
        if (qty <= 0) {
            throw new IllegalArgumentException("Bad quantity");
        }

        // compute the subtotal
        tempSubtotal = price * qty;

        // apply discount based on customer type
        double discount;
        switch (customerType) {
            case "GOLD":
                discount = tempSubtotal * 0.15;
                break;
            case "SILVER":
                discount = tempSubtotal * 0.10;
                break;
            default:
                discount = 0;
        }
        double afterDiscount = tempSubtotal - discount;

        // add the tax
        double tax = afterDiscount * 0.12;

        // compute shipping based on region
        double shipping;
        if (region.equals("NCR")) {
            shipping = 50;
        } else if (region.equals("LUZON")) {
            shipping = 150;
        } else {
            shipping = 250;
        }
        // gold members get free shipping
        if (customerType.equals("GOLD")) {
            shipping = 0;
        }

        double total = afterDiscount + tax + shipping;

        // build the receipt
        String receipt = "";
        receipt += "Customer: " + customerName + " <" + customerEmail + "> " + customerPhone + "\n";
        receipt += "Item: " + itemName + " x" + qty + "\n";
        receipt += "Subtotal: " + String.format("%.2f", tempSubtotal) + "\n";
        receipt += "Discount: " + String.format("%.2f", discount) + "\n";
        receipt += "Tax: " + String.format("%.2f", tax) + "\n";
        receipt += "Shipping: " + String.format("%.2f", shipping) + "\n";
        receipt += "Total: " + String.format("%.2f", total);
        return receipt;
    }

    // estimates the total WITHOUT shipping (used by the cart page)
    public double estimateTotal(String customerType, double price, int qty) {
        double subtotal = price * qty;
        double discount;
        switch (customerType) {
            case "GOLD":
                discount = subtotal * 0.15;
                break;
            case "SILVER":
                discount = subtotal * 0.10;
                break;
            default:
                discount = 0;
        }
        double afterDiscount = subtotal - discount;
        return afterDiscount + afterDiscount * 0.12;
    }

    // label shown on the order page
    public String customerLabel(Customer c) {
        return c.getName().toUpperCase() + " (" + c.getEmail() + ", " + c.getPhone() + ")";
    }
}
