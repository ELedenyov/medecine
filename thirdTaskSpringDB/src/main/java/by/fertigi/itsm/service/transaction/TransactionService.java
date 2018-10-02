package by.fertigi.itsm.service.transaction;


import by.fertigi.itsm.entity.Transaction;

public interface TransactionService {
    void createTransaction(Transaction transaction) throws Exception;
}
