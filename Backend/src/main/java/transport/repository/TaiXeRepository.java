package transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import transport.model.TaiXe;

import java.util.List;

@Repository
public interface TaiXeRepository extends JpaRepository<TaiXe, Integer> {
    @Query("SELECT taiXe FROM TaiXe taiXe WHERE taiXe.cmt LIKE %?1%"
            + "OR taiXe.ten LIKE %?1%"
            + "OR taiXe.diaChi Like %?1%")
    public List<TaiXe> searchTaiXeByKeyword(String keyword);
}
