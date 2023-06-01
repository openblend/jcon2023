package org.openblend.jcon23.funky;

/**
 * @author Ales Justin
 */
public class PriceDto {
    private double price;

    public PriceDto() {
    }

    public PriceDto(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PriceDto{" +
            "price=" + price +
            '}';
    }
}
