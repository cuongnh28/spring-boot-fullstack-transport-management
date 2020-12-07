package transport.service;

import org.springframework.stereotype.Service;
import transport.model.ChuyenXe;

import java.util.List;
import java.util.Optional;
@Service
public interface ChuyenXeService {
    List<ChuyenXe> getAllChuyenXe();
    void saveChuyenXe(ChuyenXe chuyenXe);
    void deleteChuyenXe(int id);
    Optional<ChuyenXe> getChuyenXeById(int id);
}
