package by.fertigi.itsm.repository;

import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductSaleRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findAllByCreatedBy(User user);
}
