package coree.coree.coree.services;

import java.util.List;
import java.util.Optional;

public interface Service<T,ID> {
    void save(T data);
    List<T> getAll();
    Optional<T> show(ID dataID);
}
