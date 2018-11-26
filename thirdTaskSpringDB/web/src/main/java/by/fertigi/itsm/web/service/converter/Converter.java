package by.fertigi.itsm.web.service.converter;


import by.fertigi.itsm.entity.IEntity;
import by.fertigi.itsm.web.model.IDto;

public interface Converter<E extends IEntity, D extends IDto> {

    D convert(E entity);

    E convert(D dto);
}
