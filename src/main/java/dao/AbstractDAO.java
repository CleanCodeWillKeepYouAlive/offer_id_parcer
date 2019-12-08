package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public abstract class AbstractDAO<T> {
    public abstract T getById(int id) throws Exception;
    public abstract void insert(T dat);
    public abstract void update(T dat);
    public abstract void delete(T dat);
    public abstract List<T> getAll() throws Exception;

    private Connection connection;

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }

}
