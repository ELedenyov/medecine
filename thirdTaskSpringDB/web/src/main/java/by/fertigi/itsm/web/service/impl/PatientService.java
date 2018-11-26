package by.fertigi.itsm.web.service.impl;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.web.model.PatientDto;
import by.fertigi.itsm.web.service.AbstractCrudService;
import by.fertigi.itsm.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class PatientService extends AbstractCrudService<Patient, PatientDto> {

    @Autowired
    public PatientService(
            JpaRepository<Patient, Integer> repository,
            Converter<Patient, PatientDto> converter
    ) {
        super(repository, converter);
    }
}
