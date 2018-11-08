package by.fertigi.itsm.repository.domain;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.entity.User;
import by.fertigi.itsm.repository.IListRepository;

import java.util.List;

public interface ITransactionRepository extends IListRepository<Transaction> {
    void sale(Product product, Patient patient);
    List<Transaction> findByUser();
}
