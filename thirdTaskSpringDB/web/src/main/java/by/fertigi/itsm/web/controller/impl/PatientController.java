package by.fertigi.itsm.web.controller.impl;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.web.controller.AbstractCrudController;
import by.fertigi.itsm.web.model.PatientDto;
import by.fertigi.itsm.web.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientController extends AbstractCrudController<Patient, PatientDto> {

    @Autowired
    public PatientController(ICrudService<Patient, PatientDto> service) {
        super(service);
    }

}
