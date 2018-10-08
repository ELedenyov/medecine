package by.fertigi.itsm.entity;

public class Product implements Entity{
    private int id;
    private String name;
    private State state;

    public Product() {
    }

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public Product(int id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public Product(int idProduct) {
        this.id = idProduct;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}