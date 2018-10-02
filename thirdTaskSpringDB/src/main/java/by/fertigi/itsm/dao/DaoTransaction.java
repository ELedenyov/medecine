package by.fertigi.itsm.dao;


import by.fertigi.itsm.entity.Transaction;

public interface DaoTransaction {
    void createTransaction(Transaction transaction) throws Exception;
}
