package by.fertigi.itsm.web.service.converter.impl;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.web.model.PatientDto;
import by.fertigi.itsm.web.repository.StateRepository;
import by.fertigi.itsm.web.service.converter.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class PatientConverter implements Converter<Patient, PatientDto> {

    private final StateRepository stateRepository;

    @Autowired
    public PatientConverter(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public PatientDto convert(Patient entity) {
        PatientDto dto = new PatientDto();

        dto.setId(entity.getId());
        dto.setPhone(entity.getPhone());
        dto.setStateId(entity.getState().getId());

        return dto;
    }

    @Override
    public Patient convert(PatientDto dto) {
        State state = stateRepository.findById(dto.getStateId())
                .orElseThrow(() -> new IllegalArgumentException("Can't find state with id = " + dto.getStateId()));

        Patient patient = new Patient();

        patient.setId(dto.getId());
        patient.setPhone(dto.getPhone());
        patient.setState(state);

        return patient;
    }
}
