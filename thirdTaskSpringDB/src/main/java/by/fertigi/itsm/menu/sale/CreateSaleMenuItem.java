package by.fertigi.itsm.menu.sale;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.menu.IMenuItem;
import by.fertigi.itsm.menu.util.MenuHelper;
import by.fertigi.itsm.repository.domain.IPatientRepository;
import by.fertigi.itsm.repository.domain.IProductRepository;
import by.fertigi.itsm.repository.domain.ITransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@SaleMenuItem
public class CreateSaleMenuItem implements IMenuItem {

    private final IPatientRepository patientRepository;
    private final IProductRepository productRepository;
    private final ITransactionRepository saleRepository;
    private final MenuHelper helper;

    @Autowired
    public CreateSaleMenuItem(
            IPatientRepository patientRepository,
            IProductRepository productRepository,
            ITransactionRepository saleRepository,
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
            saleRepository.sale(product, patient);
        } catch (Exception e) {
            System.out.println("failed to complete sale");
            e.printStackTrace();
        }

        return 0;
    }
}
