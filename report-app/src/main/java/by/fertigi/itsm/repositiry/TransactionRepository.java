package by.fertigi.itsm.repositiry;

import by.fertigi.itsm.model.Transaction;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TransactionRepository {
    Transaction getTransaction(int id);
    List<Transaction> getAllTransaction(Date start, Date finish) throws ParseException;
}
