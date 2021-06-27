package eu.exposit.consoleApp.api.repositories;

import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public interface AbstractRepository<T extends BaseEntity> {

    long create(T entity);

    void delete(long entity) throws NoSuitableEntryException;

    void update(T entity);

    Optional<T> get(long id);

    List<T> getAll();
}
