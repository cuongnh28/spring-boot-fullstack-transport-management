package transport.service;

import org.springframework.stereotype.Service;
import transport.model.TaiXe;
import java.util.List;
import java.util.Optional;
@Service
public interface TaiXeService {
    List<TaiXe> getAllTaiXe();
    void saveTaiXe(TaiXe taiXe);
    void deleteTaiXe(Long id);
    Optional<TaiXe> getTaiXeById(Long id);
    List<TaiXe> searchTaiXeByKeyword(String keyword);
    boolean checkTonTai(String cmt, String maSoBangLai);
}
