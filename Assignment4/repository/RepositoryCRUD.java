package repository;

import domain.BaseEntity;
import domain.Product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface RepositoryCRUD<T extends BaseEntity> {
    void save(T entity, String name);
    T findById(int id);
    int getId();
    List<T> findAll();
    void delete(int id);
    List<String> getNames();
}
