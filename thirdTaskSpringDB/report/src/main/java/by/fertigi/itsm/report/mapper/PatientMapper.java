package by.fertigi.itsm.report.mapper;

import by.fertigi.itsm.entity.Patient;
import by.fertigi.itsm.entity.State;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface PatientMapper {
    @Select("SELECT * FROM patients INNER JOIN states ON patients.state_id = states.id WHERE patients.id = #{patient_id}")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "state", column = "state_id", javaType = State.class, one = @One(select = "selectState"))
    })
    Patient selectPatient(int patient_id);
}
