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

    //Neu ton tai cmt hoac maSoBangLai thi khong them vao.
    @Query("SELECT COUNT(taiXe)>0 FROM TaiXe taiXe WHERE taiXe.cmt = ?1 OR taiXe.maSoBangLai = ?2")
    public boolean checkTonTai(String cmt, String maSoBangLai);
}
