package transport.service;

import transport.model.TaiXe;
import java.util.List;
import java.util.Optional;

public interface TaiXeService {
    List<TaiXe> getAllTaiXe();
    void saveTaiXe(TaiXe taiXe);
    void deleteTaiXe(int id);
    Optional<TaiXe> getTaiXeById(int id);
}
