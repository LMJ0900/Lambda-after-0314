package com.turing.api.common;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public abstract class AbstractService<T> {
    public abstract Messenger save(T t) throws SQLException;
    public abstract List<T> findAll();
    public abstract Optional<T> findAById(Long id);
    public abstract String count();
    public abstract Optional<T> getOne(String id);
    public abstract String delete(T t);
    public abstract String deleteAll();
    public abstract Boolean existById(Long id);
}
