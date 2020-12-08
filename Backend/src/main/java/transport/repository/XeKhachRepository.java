package transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import transport.model.XeKhach;

import java.util.List;

@Repository
public interface XeKhachRepository extends JpaRepository<XeKhach, Long> {
    //Tim kiem boi bien so.
    @Query("SELECT xeKhach FROM XeKhach xeKhach WHERE xeKhach.bienSo LIKE %?1%")
    public List<XeKhach> searchXeKhachByKeyword(String keyword);

    //Check trung bien so truoc khi insert.
    @Query("SELECT COUNT(xeKhach) > 0 FROM XeKhach xeKhach WHERE xeKhach.bienSo = ?1")
    public boolean checkTonTai(String bienSo);
}
