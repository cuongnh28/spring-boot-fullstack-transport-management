package transport.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.dto.ChuyenXeRequest;
import transport.model.ChuyenXe;
import transport.repository.ChuyenXeRepository;
import transport.service.ChuyenXeService;

import java.util.List;
import java.util.Optional;

@Service
public class ChuyenXeServiceImpl implements ChuyenXeService {

    private ChuyenXeRepository chuyenXeRepo;
    @Autowired
    public ChuyenXeServiceImpl(ChuyenXeRepository chuyenXeRepo){ this.chuyenXeRepo = chuyenXeRepo; }
    @Override
    public List<ChuyenXe> getAllChuyenXe() {
        return chuyenXeRepo.findAll();
    }

    @Override
    public void saveChuyenXe(ChuyenXe chuyenXe) {
        chuyenXeRepo.save(chuyenXe);
    }

    @Override
    public void deleteChuyenXe(Long id) {
        chuyenXeRepo.deleteById(id);
    }

    @Override
    public Optional<ChuyenXe> getChuyenXeById(Long id) {
        return chuyenXeRepo.findById(id);
    }
}
