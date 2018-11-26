package by.fertigi.itsm.menu.sale;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.MenuHelper;
import by.fertigi.itsm.processors.AuditOperationAnnotation;
import by.fertigi.itsm.repository.PatientRepository;
import by.fertigi.itsm.repository.ProductRepository;
import by.fertigi.itsm.repository.ProductSaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@SaleMenuItem
public class CreateSaleMenuItem implements IMenuItem {

    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;
    private final ProductSaleRepository saleRepository;
    private final MenuHelper helper;

    @Autowired
    public CreateSaleMenuItem(
            PatientRepository patientRepository,
            ProductRepository productRepository,
            ProductSaleRepository saleRepository,
            MenuHelper helper) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.helper = helper;
    }

    @Override
    public String getTitle() {
        return "Make sale";
    }

    @Override
    @Transactional
    @AuditOperationAnnotation(operation = "sale")
    public int doAction() {
        System.out.println("input patient phone: ");
        String phone = helper.read();

        Patient patient = patientRepository.findByPhone(phone);
        if (patient == null) {
            System.out.println("Patient not found");
            return 0;
        }

        System.out.println("input product name");
        String name = helper.read();

        Product product = productRepository.findByName(name);
        if (product == null) {
            System.out.println("product not found");
            return 0;
        }

        try {
            Transaction transaction = new Transaction(null, patient, product, new Date(), null, null, null, null);
            saleRepository.save(transaction);
        } catch (Exception e) {
            System.out.println("failed to complete sale");
            e.printStackTrace();
        }

        return 0;
    }
}
