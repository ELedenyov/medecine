package by.fertigi.itsm.web.service;

import by.fertigi.itsm.entity.IEntity;
import by.fertigi.itsm.web.model.IDto;
import by.fertigi.itsm.web.service.converter.Converter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;


public class AbstractCrudService<E extends IEntity, D extends IDto> implements ICrudService<E, D>  {

    protected final JpaRepository<E, Integer> repository;
    protected final Converter<E, D> converter;

    public AbstractCrudService(
            JpaRepository<E, Integer> repository,
            Converter<E, D> converter
    ) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public void save(D dto) {
        E e = converter.convert(dto);
        repository.save(e);
    }

    @Override
    public D find(Integer id) {
        E e = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Can't find entity with id = " + id));
        return converter.convert(e);
    }

    @Override
    public List<D> findAll() {
        return repository.findAll()
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
