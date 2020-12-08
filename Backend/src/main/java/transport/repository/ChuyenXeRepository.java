package transport.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import transport.model.ChuyenXe;

@Repository
public interface ChuyenXeRepository extends JpaRepository<ChuyenXe, Long> {
}
