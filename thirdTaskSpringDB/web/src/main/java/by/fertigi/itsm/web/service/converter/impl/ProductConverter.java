package by.fertigi.itsm.web.service.converter.impl;

import by.fertigi.itsm.entity.Product;
import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.web.model.ProductDto;
import by.fertigi.itsm.web.repository.StateRepository;
import by.fertigi.itsm.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProductConverter implements Converter<Product, ProductDto> {

    private final StateRepository stateRepository;

    @Autowired
    public ProductConverter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public ProductDto convert(Product entity) {
        ProductDto dto = new ProductDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setStateId(entity.getState().getId());

        return dto;
    }

    @Override
    public Product convert(ProductDto dto) {
        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find state with id = " + dto.getStateId()));

        Product product = new Product();

        product.setId(dto.getId());
        product.setName(dto.getName());
        product.setState(state);

        return product;
    }
}
