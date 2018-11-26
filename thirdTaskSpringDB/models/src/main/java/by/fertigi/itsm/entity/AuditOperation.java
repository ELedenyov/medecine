package by.fertigi.itsm.entity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "auditoperations")
@Table(name = "auditoperations")
public class AuditOperation implements IEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private String status;

    @Column(name = "action")
    private String action;

    @ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private  User user;

    public AuditOperation() {
    }

    public AuditOperation(Date date, String status, String action, User user) {
        this.date = date;
        this.status = status;
        this.action = action;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
