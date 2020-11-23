package transport.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.model.TaiXe;
import transport.repository.TaiXeRepository;
import transport.service.TaiXeService;

import java.util.List;
import java.util.Optional;

@Service
public class TaiXeServiceImpl implements TaiXeService {

    private TaiXeRepository taiXeRepo;
    @Autowired
    public TaiXeServiceImpl(TaiXeRepository taiXeRepo){
        this.taiXeRepo = taiXeRepo;
    }

    @Override
    public List<TaiXe> getAllTaiXe() {
        return (List<TaiXe>) taiXeRepo.findAll();
    }

    @Override
    public void saveTaiXe(TaiXe taiXe) {
        taiXeRepo.save(taiXe);
    }

    @Override
    public void deleteTaiXe(int id) {
        taiXeRepo.deleteById(id);
    }

    @Override
    public Optional<TaiXe> getTaiXeById(int id) {
        return taiXeRepo.findById(id);
    }

    @Override
    public List<TaiXe> searchTaiXeByKeyword(String keyword) {
        return taiXeRepo.searchTaiXeByKeyword(keyword);
    }
}
