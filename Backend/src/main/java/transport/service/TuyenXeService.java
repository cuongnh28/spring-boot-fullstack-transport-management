package transport.service;

import transport.model.TuyenXe;

import java.util.List;
import java.util.Optional;

public interface TuyenXeService {
    List<TuyenXe> getAllTuyenXe();
    void saveTuyenXe(TuyenXe tuyenXe);
    void deleteTuyenXe(int id);
    Optional<TuyenXe> getTuyenXeById(int id);
    List<TuyenXe> searchTuyenXeByKeyWord(String keyword);
}
