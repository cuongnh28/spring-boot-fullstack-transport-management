package transport.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import transport.model.TaiXe;
@Repository
public interface TaiXeRepository extends CrudRepository<TaiXe, Integer>{

}
