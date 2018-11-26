package by.fertigi.itsm.web.service.impl;

import by.fertigi.itsm.entity.Transaction;
import by.fertigi.itsm.web.model.ProductSaleDto;
import by.fertigi.itsm.web.service.AbstractCrudService;
import by.fertigi.itsm.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@Service
@Transactional
public class ProductSaleService extends AbstractCrudService<Transaction, ProductSaleDto> {

    @Autowired
    public ProductSaleService(
            JpaRepository<Transaction, Integer> repository,
            Converter<Transaction, ProductSaleDto> converter
    ) {
        super(repository, converter);
    }

    @Override
    public void save(ProductSaleDto dto) {
        Transaction entity = converter.convert(dto);

        Integer patStateId = entity.getPatient().getState().getId();
        Integer prdStateId = entity.getProduct().getState().getId();

        if (!Objects.equals(patStateId, prdStateId)) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        repository.save(entity);
    }
}
