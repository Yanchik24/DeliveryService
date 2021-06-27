package eu.exposit.consoleApp.services;

import eu.exposit.consoleApp.api.repositories.AbstractRepository;
import eu.exposit.consoleApp.api.services.AbstractService;
import eu.exposit.consoleApp.exceptions.NoSuitableEntryException;
import eu.exposit.consoleApp.model.BaseEntity;

import java.util.List;

public class AbstractServiceImpl<T extends BaseEntity> implements AbstractService<T> {

    protected AbstractRepository<T> abstractRepository;

    AbstractServiceImpl(AbstractRepository<T> abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    @Override
    public long create(T entity) {
        return abstractRepository.create(entity);
    }

    @Override
    public T get(long id) throws NoSuitableEntryException {
        return abstractRepository.get(id).orElseThrow(NoSuitableEntryException::new);
    }

    @Override
    public List<T> getAll() {
        return abstractRepository.getAll();
    }

}
