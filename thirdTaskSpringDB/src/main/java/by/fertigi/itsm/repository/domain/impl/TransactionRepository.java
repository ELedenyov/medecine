package by.fertigi.itsm.repository.domain.impl;

import by.fertigi.itsm.annotations.AuditOperationAnnotation;
import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.processors.UserHolder;
import by.fertigi.itsm.repository.AbstractCrudRepository;
import by.fertigi.itsm.repository.domain.ITransactionRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public class TransactionRepository extends AbstractCrudRepository<Transaction> implements ITransactionRepository {
    @Override
    protected Class<Transaction> getEntityClass() {
        return Transaction.class;
    }

    @Override
    @AuditOperationAnnotation(operation = "sale")
    public void sale(Product product, Patient patient) {
        if (!product.getState().equals(patient.getState())) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }
        Transaction transaction = new Transaction(patient, product, new Date());
        create(transaction);
    }

    @Override
    public List<Transaction> findByUser() {
        TypedQuery<Transaction> query = em.createQuery("select t from transactions t " +
                "JOIN FETCH t.patient pa " +
                "JOIN FETCH t.product pro " +
                "JOIN FETCH t.createdBy cre " +
                "JOIN FETCH t.updatedBy up " +
                "JOIN FETCH pa.state past " +
                "JOIN FETCH pro.state prost " +
                "where t.createdBy.id = :createdBy", Transaction.class);
        query.setParameter("createdBy", UserHolder.getCurrentUser().getId());
        return query.getResultList();
    }

    @Override
    protected void addCreatedBy(Transaction transaction) {
        transaction.setCreatedBy(UserHolder.getCurrentUser());
    }

    @Override
    protected void addUpdateBy(Transaction transaction) {
        transaction.setUpdatedBy(UserHolder.getCurrentUser());
    }
}
