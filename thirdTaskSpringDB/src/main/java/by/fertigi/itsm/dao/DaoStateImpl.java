package by.fertigi.itsm.dao;

import by.fertigi.itsm.entity.State;
import by.fertigi.itsm.mappers.IEntityRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Qualifier(value = "daoStateImpl")
public class DaoStateImpl implements DaoState{
    private final JdbcTemplate template;
    private final RowMapper<State> mapper;

    @Autowired
    public DaoStateImpl(JdbcTemplate template, IEntityRowMapper<State> mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    @Override
    public State getById(int id) {
        String sql = "select * from states where idState = ?";
        return template.queryForObject(sql, new Object[]{ id }, mapper);
    }

    @Override
    public State getByName(String name) {
        String sql = "select * from states where name = ?";
        return template.queryForObject(sql, new Object[]{ name }, mapper);
    }

    @Override
    public State getByCode(String code) {
        String sql = "select * from states where code = ?";
        return template.queryForObject(sql, new Object[]{ code }, mapper);
    }

    @Override
    public List<State> getAll() {
        String sql = "select * from states";
        return template.query(sql, mapper);
    }
}
