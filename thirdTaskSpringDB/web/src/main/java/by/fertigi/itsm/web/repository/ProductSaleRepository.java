package by.fertigi.itsm.web.repository;

import by.fertigi.itsm.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductSaleRepository extends JpaRepository<Transaction, Integer> {
}
