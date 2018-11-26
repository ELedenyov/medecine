package by.fertigi.itsm.web.service.converter.impl;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.web.model.ProductSaleDto;
import by.fertigi.itsm.web.repository.PatientRepository;
import by.fertigi.itsm.web.repository.ProductRepository;
import by.fertigi.itsm.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductSaleConverter implements Converter<Transaction, ProductSaleDto> {

    private final PatientRepository patientRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ProductSaleConverter(
            PatientRepository patientRepository,
            ProductRepository productRepository
    ) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public ProductSaleDto convert(Transaction entity) {
        ProductSaleDto dto = new ProductSaleDto();

        dto.setPatientId(entity.getPatient().getId());
        dto.setProductId(entity.getProduct().getId());
        dto.setDate(entity.getDate());

        return dto;
    }

    @Override
    public Transaction convert(ProductSaleDto dto) {
        Patient patient = patientRepository
                .findById(dto.getPatientId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find patient with id = " + dto.getPatientId()));

        Product product = productRepository
                .findById(dto.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find product with id = " + dto.getProductId()));

        Transaction entity = new Transaction();

        entity.setId(dto.getId());
        entity.setDate(dto.getDate());

        entity.setPatient(patient);
        entity.setProduct(product);

        return entity;
    }
}
