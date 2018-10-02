package by.fertigi.itsm.model;

import java.sql.Date;

public class Transaction implements Entity{
    private int id;
    private Patient patient;
    private Product product;
    private Date date;

    public Transaction(Patient patient, Product product, Date date) {
        this.patient = patient;
        this.patient = patient;
        this.date = date;
    }

    public Transaction() {
    }

    public Transaction(int id, Patient patient, Product product, Date date) {
        this.id = id;
        this.patient = patient;
        this.product = product;
        this.date = date;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", patient=" + patient +
                ", product=" + product +
                ", date=" + date +
                '}';
    }
}
