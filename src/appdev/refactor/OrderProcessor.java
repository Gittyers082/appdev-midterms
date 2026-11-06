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
        validateInputs(customerName, price, qty);

        tempSubtotal = price * qty;
        double discount = calculateDiscount(customerType, tempSubtotal);
        double afterDiscount = tempSubtotal - discount;
        double tax = calculateTax(afterDiscount);

        double shipping = calculateShipping(region);
        // gold members get free shipping
        if (customerType.equals("GOLD")) {
            shipping = 0;
        }

        double total = afterDiscount + tax + shipping;

        return buildReceipt(customerName, customerEmail, customerPhone, itemName, qty, discount, tax, shipping, total);
    }

    // estimates the total WITHOUT shipping (used by the cart page)
    public double estimateTotal(String customerType, double price, int qty) {
        double subtotal = price * qty;
        double afterDiscount = subtotal - calculateDiscount(customerType, subtotal);
        return afterDiscount + calculateTax(afterDiscount);
    }

    // label shown on the order page
    public String customerLabel(Customer c) {
        return c.getName().toUpperCase() + " (" + c.getEmail() + ", " + c.getPhone() + ")";
    }

    private void validateInputs(String customerName, double price, int qty) {
        if (customerName == null || customerName.isEmpty()) {
            throw new IllegalArgumentException("Name required");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Bad price");
        }
        if (qty <= 0) {
            throw new IllegalArgumentException("Bad quantity");
        }
    }

    private double calculateDiscount(String customerType, double subtotal) {
        switch (customerType) {
            case "GOLD":
                return subtotal * 0.15;
            case "SILVER":
                return subtotal * 0.10;
            default:
                return 0;
        }
    }

    private double calculateTax(double amount) {
        return amount * 0.12;
    }

    private double calculateShipping(String region) {
        if (region.equals("NCR")) {
            return 50;
        } else if (region.equals("LUZON")) {
            return 150;
        } else {
            return 250;
        }
    }

    private String buildReceipt(String customerName, String customerEmail, String customerPhone, String itemName, int qty,
                                double discount, double tax, double shipping, double total) {
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
}
