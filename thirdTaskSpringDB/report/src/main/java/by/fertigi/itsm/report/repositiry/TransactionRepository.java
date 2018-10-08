package by.fertigi.itsm.report.repositiry;

import by.fertigi.itsm.entity.Transaction;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public interface TransactionRepository {
    List<Transaction> getAllTransaction(Date start, Date finish) throws ParseException;
}
