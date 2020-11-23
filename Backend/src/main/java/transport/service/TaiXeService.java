package transport.service;

import org.springframework.stereotype.Service;
import transport.model.TaiXe;
import java.util.List;
import java.util.Optional;
@Service
public interface TaiXeService {
    List<TaiXe> getAllTaiXe();
    void saveTaiXe(TaiXe taiXe);
    void deleteTaiXe(int id);
    Optional<TaiXe> getTaiXeById(int id);
    List<TaiXe> searchTaiXeByKeyword(String keyword);
}
