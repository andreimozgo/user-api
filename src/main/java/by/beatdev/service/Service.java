package by.beatdev.service;

import by.beatdev.entity.AbstractEntity;

public interface Service<T extends AbstractEntity> {

    void save(T t);

    T findEntityById(Integer id);

    void delete(Integer id);
}
