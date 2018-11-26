package by.fertigi.itsm.web.service;


import by.fertigi.itsm.entity.IEntity;
import by.fertigi.itsm.web.model.IDto;

import java.util.List;

public interface ICrudService<E extends IEntity, D extends IDto> {
    void save(D dto);

    D find(Integer id);

    List<D> findAll();
}
