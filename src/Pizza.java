public class Pizza {
    int id;
    private final double price;
    private final String title;
    private final String topping;

    public Pizza(int id, double price, String title, String topping) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.topping = topping;
    }

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getTopping() {
        return topping;
    }

    private int getLength() {
        String value = getId() + ". " + getTitle() + ": " + getTopping() + " " + getPrice() + ",-";
        return value.length();
    }

    private String getSpace() {
        int max = 92;
        int totalDots = max - getLength();
        String dots = "";
        for (int i = 0; i < totalDots; i++) {
            dots += ".";
        }
        return dots;
    }

    @Override
    public String toString() {
        return getId() + ". " + getTitle() + ": " + getTopping() + getSpace() + " " + getPrice() + ",-";
    }
}
