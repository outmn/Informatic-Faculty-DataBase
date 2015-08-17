package facultyDataBase;

import java.util.List;

/**
 * Created by maximgrozniy on 15.08.15.
 */
public interface DAO <T> {

    List<T> getAll();
    List<T> getById(int id);
    List<T> getByName(String name);
    boolean insert(String firstParameter, String secondParameter);
    boolean update(T entity);
    boolean delete(T entity);
    boolean delete(int id);
    boolean delete(String parameter);


}
