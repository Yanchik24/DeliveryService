package eu.exposit.consoleApp.repositories;

import eu.exposit.consoleApp.api.datastorage.AbstractDataStorage;
import eu.exposit.consoleApp.api.repositories.AbstractRepository;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public class AbstractRepositoryImpl<T extends BaseEntity> implements AbstractRepository<T> {

    protected AbstractDataStorage<T> abstractDataStorage;

    AbstractRepositoryImpl(AbstractDataStorage<T> abstractDataStorage) {
        this.abstractDataStorage = abstractDataStorage;
    }

    @Override
    public long create(T entity) {
        return abstractDataStorage.create(entity).getId();
    }

    @Override
    public void delete(long id) throws NoSuitableEntryException {
        T entityToDelete = abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst()
                .orElseThrow(NoSuitableEntryException::new);

        abstractDataStorage.getEntities().remove(entityToDelete);
    }

    @Override
    public void update(T entity) {
        int index = abstractDataStorage.getEntities().indexOf(entity);
        abstractDataStorage.getEntities().set(index, entity);
    }

    @Override
    public Optional<T> get(long id) {
        return abstractDataStorage.getEntities()
                .stream()
                .filter(entity -> entity.getId() == id)
                .findFirst();
    }

    @Override
    public List<T> getAll() {
        return abstractDataStorage.getEntities();
    }
}
