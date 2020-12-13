package transport.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import transport.model.DoanhThuXeKhach;
import transport.model.XeKhach;
import transport.repository.DoanhThuRepository;
import transport.repository.Impl.DoanhThuRepositoryImpl;
import transport.repository.XeKhachRepository;
import transport.service.XeKhachService;

import javax.persistence.EntityManager;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Component
public class XeKhachServiceImpl implements XeKhachService {
    @Autowired
    private DoanhThuRepository doanhThuRepository;
    @Autowired
    private XeKhachRepository xeKhachRepo;

    @Override
    public List<XeKhach> getAllXeKhach() {
        return (List<XeKhach>) xeKhachRepo.findAll();
    }

    @Override
    public void saveXeKhach(XeKhach xeKhach) {
        xeKhachRepo.save(xeKhach);
    }

    @Override
    public void deleteXeKhach(Long id) {
        xeKhachRepo.deleteById(id);
    }

    @Override
    public Optional<XeKhach> getXeKhachById(Long id) {
        return xeKhachRepo.findById(id);
    }

    @Override
    public List<XeKhach> searchXeKhachByKeyword(String keyword) {
        return xeKhachRepo.searchXeKhachByKeyword(keyword);
    }

    @Override
    public boolean checkTonTai(String bienSo) {
        return xeKhachRepo.checkTonTai(bienSo);
    }

    @Override
    public List<DoanhThuXeKhach> doanhThuXeKhachs(Date startDate, Date endDate) {
        return doanhThuRepository.tinhDoanhThu(startDate, endDate);
    }
}
