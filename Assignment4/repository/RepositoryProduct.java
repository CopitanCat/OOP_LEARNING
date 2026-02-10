package repository;

import domain.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryProduct implements RepositoryCRUD<Product> {
    private final Map<Integer, Product> storage= new HashMap<>();
    private int idCounter = 1;

    @Override
    public void save(Product entity) {
        if (entity.getId() == null) {
            entity.setId(idCounter++);
        }
        storage.put(entity.getId(), entity);
    }

    public int getId(){
        return this.idCounter;
    }


    @Override
    public Product findById(int id) {
        return storage.get(id);
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }


}
