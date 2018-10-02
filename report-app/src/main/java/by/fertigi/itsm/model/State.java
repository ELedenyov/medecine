package by.fertigi.itsm.model;

public class State implements Entity{
    private int id;
    private String code;
    private String name;

    public State() {
    }

    public State(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public State(String code, String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
