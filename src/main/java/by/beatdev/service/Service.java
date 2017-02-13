package by.beatdev.service;

import by.beatdev.entity.AbstractEntity;
import by.beatdev.service.exceptions.NotFoundServiceException;

public interface Service<T extends AbstractEntity> {

    void save(T t);

    T getEntityById(Integer id) throws NotFoundServiceException;

    void delete(Integer id);
}
