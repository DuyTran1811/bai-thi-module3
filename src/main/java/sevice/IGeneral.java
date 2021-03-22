package sevice;

import java.util.List;

public interface IGeneral<T> {
    List<T> getAll();

    boolean insert(T t);

    boolean update(T t);

    boolean delete(int id);

    T getById(byte id);
    List<T> search(String name);
}
