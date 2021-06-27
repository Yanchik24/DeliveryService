package eu.exposit.consoleApp.api.services;

import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.BaseEntity;

import java.util.List;

public interface AbstractService<T extends BaseEntity> {

    long create(T entity);

    T get(long id) throws NoSuitableEntryException;

    List<T> getAll();
}
