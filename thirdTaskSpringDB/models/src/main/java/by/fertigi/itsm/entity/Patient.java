package by.fertigi.itsm.entity;

public class Patient implements Entity{
    private int id;
    private String phone;
    private State state;

    public Patient() {
    }

    public Patient(int id, String phone) {
        this.id = id;
        this.phone = phone;
    }

    public Patient(String phone, State state) {
        this.phone = phone;
        this.state = state;
    }

    public Patient(int id, String phone, State state) {
        this.id = id;
        this.phone = phone;
        this.state = state;
    }

    public Patient(int idPatient) {
        this.id = idPatient;
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
