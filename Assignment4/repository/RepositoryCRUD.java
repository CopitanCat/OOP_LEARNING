package repository;

import domain.BaseEntity;
import java.util.List;

public interface RepositoryCRUD<T extends BaseEntity> {
    void save(T entity);
    T findById(int id);
    int getId();
    List<T> findAll();
    void delete(int id);
}
