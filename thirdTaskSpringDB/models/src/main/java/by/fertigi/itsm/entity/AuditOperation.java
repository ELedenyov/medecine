package by.fertigi.itsm.entity;

import java.sql.Date;

public class AuditOperation implements Entity{
    private int id;
    private Date date;
    private String status;
    private String action;

    public AuditOperation() {
    }

    public AuditOperation(Date date, String status, String action) {
        this.date = date;
        this.status = status;
        this.action = action;
    }

    public AuditOperation(int id, Date date, String status, String action) {
        this.id = id;
        this.date = date;
        this.status = status;
        this.action = action;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "AuditOperation{" +
                "id=" + id +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
