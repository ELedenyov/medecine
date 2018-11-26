package by.fertigi.itsm.entity;

public interface ModifyMarker {
    void setCreatedBy(User user);
    User getCreatedBy();
    void setUpdatedBy(User user);
    User getUpdatedBy();
}
