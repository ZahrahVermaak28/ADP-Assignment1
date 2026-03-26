package za.ac.cput.Repository;

public interface IRepository <T, ID>  {

        T create(T entity);
        T read(ID id);
        T update(T entity);
        boolean delete(ID id);

}
