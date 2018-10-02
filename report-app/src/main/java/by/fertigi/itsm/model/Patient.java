package by.fertigi.itsm.model;

public class Patient implements Entity{
    private int id;
    private String phone;
    private State state;

    public Patient() {
    }

    public Patient(int id, String phone, State state) {
        this.id = id;
        this.phone = phone;
        this.state = state;
    }

    public Patient(String phone, State state) {
        this.phone = phone;
        this.state = state;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", state=" + state +
                '}';
    }
}
