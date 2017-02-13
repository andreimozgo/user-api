package by.beatdev.service;

import by.beatdev.entity.AbstractEntity;
import by.beatdev.service.exceptions.ServiceException;

public interface Service<T extends AbstractEntity> {

    void save(T t);

    T findEntityById(Integer id) throws ServiceException;

    void delete(Integer id);
}
