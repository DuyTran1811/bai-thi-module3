package mode;

public class Product {
    private byte id;
    private String name;
    private float price;
    private byte quantity;
    private String color;
    private String category;
    private byte category_id;

    public Product() {
    }

    public Product(byte id, String name, float price,
                   byte quantity, String color, String category, byte category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
        this.category_id = category_id;
    }

    public Product(String name, float price, byte quantity, String color, byte category_id) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category_id = category_id;
    }

    public Product(byte id, String name, float price, byte quantity, String color, byte category_id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category_id = category_id;
    }

    public byte getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public byte getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public String getCategory() {
        return category;
    }

    public byte getCategory_id() {
        return category_id;
    }
}
