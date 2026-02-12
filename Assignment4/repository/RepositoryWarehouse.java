package repository;

import domain.Warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryWarehouse implements RepositoryCRUD<Warehouse> {
    private final Map<Integer, Warehouse> storage= new HashMap<>();
    private List<String> names = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public void save(Warehouse entity, String name) {
        if (entity.getId() == null) {
            entity.setId(idCounter++);
        }
        names.add(name);
        storage.put(entity.getId(), entity);
    }

    @Override
    public int getId() {
        return this.idCounter;
    }

    @Override
    public Warehouse findById(int id) {
        return storage.get(id);
    }

    @Override
    public List<Warehouse> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    public List<String> getNames() {
        return names;
    }
}
