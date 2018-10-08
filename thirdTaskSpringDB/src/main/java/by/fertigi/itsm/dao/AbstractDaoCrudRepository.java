package by.fertigi.itsm.dao;

import by.fertigi.itsm.entity.Entity;
import by.fertigi.itsm.mappers.IEntityRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public abstract class AbstractDaoCrudRepository<T extends Entity> implements CrudOperation<T>{
    protected JdbcTemplate template;
    protected IEntityRowMapper<T> mapper;

    protected AbstractDaoCrudRepository(JdbcTemplate template, IEntityRowMapper<T> mapper) {
        this.template = template;
        this.mapper = mapper;
    }

    public T read(int id){
        String sql = "SELECT * FROM " + mapper.getTableName() +
                " INNER JOIN states ON " +
                mapper.getTableName() + ".state_id = states.idState " +
                "where " + mapper.getTableName() + ".id = ?";
        System.out.println(sql);
        return template.query(sql, new Object[]{id}, mapper).get(0);
    }

    public void deleteById(int id) {
        String sql = "DELETE FROM " + mapper.getTableName() + " WHERE id = ?";
        template.update(sql, new Object[]{ id });
    }

    public List<T> getAll() {
        String sql = "SELECT * FROM " + mapper.getTableName() +
                " INNER JOIN states ON " +
                mapper.getTableName() + ".state_id = states.idState";
        return template.query(sql, mapper);
    }
}
