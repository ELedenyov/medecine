package by.fertigi.itsm.report.repositiry;

import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.report.mapper.TransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository{
    private final TransactionMapper mapper;

    @Autowired
    public TransactionRepositoryImpl(TransactionMapper transactionMapper) {
        System.out.println("constr TransactionRepositoryImpl");
        this.mapper = transactionMapper;
    }

    public List<Transaction> getAllTransaction(Date dateStart, Date dateFinish){
        return mapper.getTransactions(dateStart, dateFinish);
    }

}
