package eu.exposit.consoleApp.api.datastorage;

import eu.exposit.consoleApp.model.BaseEntity;

import java.util.List;

public interface AbstractDataStorage<T extends BaseEntity> {

    List<T> getEntities();

    void setEntities(List<T> entities);

    long generateEntityId();

    T create(T entity);

}
