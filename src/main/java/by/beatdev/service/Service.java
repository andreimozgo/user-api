package by.beatdev.service;

import by.beatdev.entity.AbstractEntity;

public interface Service<T extends AbstractEntity> {

    void createOrUpdate(T t);

    T findEntityById(Integer id);

    void delete(Integer id);
}
