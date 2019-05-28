package dao;

import java.util.ArrayList;

public abstract class DAO<T> {
    public abstract T getById(int id) throws Exception;
    public abstract void insert(T dat);
    public abstract void update(T dat);
    public abstract void delete(T dat);
    public abstract ArrayList<T> getAll();
}
