package by.fertigi.itsm.service.transaction;

import by.fertigi.itsm.dao.CrudOperation;
import by.fertigi.itsm.dao.DaoTransaction;
import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("transactionServiceImpl")
public class TransactionServiceImpl implements TransactionService {
    private final DaoTransaction daoTransaction;
    private final CrudOperation<Patient> daoPatient;
    private final CrudOperation<Product> daoProduct;

    @Autowired
    public TransactionServiceImpl(@Qualifier(value = "daoTransaction") DaoTransaction daoTransaction,
                                  @Qualifier(value = "daoCrudPatient") CrudOperation<Patient> daoPatient,
                                  @Qualifier(value = "daoCrudProduct") CrudOperation<Product> daoProduct) {
        this.daoTransaction = daoTransaction;
        this.daoPatient = daoPatient;
        this.daoProduct = daoProduct;
    }

    @Override
    @Transactional
    public void createTransaction(Transaction transaction) throws Exception {
        Patient patient = daoPatient.read(transaction.getIdPatient());
        Product product = daoProduct.read(transaction.getIdProduct());
        if (patient.getIdState() == product.getIdState()){
            daoTransaction.createTransaction(transaction);
        } else {
            System.out.println("the product is not for sale in the patient's state");
            throw new Exception("the product is not for sale in the patient's state");
        }
    }
}
