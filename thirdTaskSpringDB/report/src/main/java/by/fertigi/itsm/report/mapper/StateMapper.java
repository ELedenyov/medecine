package by.fertigi.itsm.report.mapper;

import by.fertigi.itsm.entity.State;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface StateMapper {
    @Select("SELECT * FROM states WHERE states.id = #{state_id}")
    State selectState(int state_id);
}
