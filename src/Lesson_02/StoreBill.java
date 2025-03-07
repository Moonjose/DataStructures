package Lesson_02;

public class StoreBill {
    String number;
    String description;
    int buyAmount;
    double itemPrice;

    public StoreBill(String number, String description, int buyAmount, double itemPrice) {
        this.number = number;
        this.description = description;
        this.buyAmount = buyAmount;
        this.itemPrice = itemPrice;
    }

    public String getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }

    public int getBuyAmount() {
        return buyAmount;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setBuyAmount(int buyAmount) {
        this.buyAmount = buyAmount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private double getTotalBill() {
        if (buyAmount <= 0 || itemPrice <= 0) return 0;
        return buyAmount * itemPrice;
    }

    public String toString() {
        return String.format("%s:  %.2f", getDescription(), getTotalBill());
    }
}
