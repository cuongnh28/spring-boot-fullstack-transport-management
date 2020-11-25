package transport.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import transport.model.XeKhach;
import transport.repository.XeKhachRepository;
import transport.service.XeKhachService;

import java.util.List;
import java.util.Optional;

@Service
public class XeKhachImpl implements XeKhachService {
    private XeKhachRepository xeKhachRepo;
    @Autowired
    public XeKhachImpl(XeKhachRepository xeKhachRepo){
        this.xeKhachRepo = xeKhachRepo;
    }

    @Override
    public List<XeKhach> getAllXeKhach() {
        return (List<XeKhach>) xeKhachRepo.findAll();
    }

    @Override
    public void saveXeKhach(XeKhach xeKhach) {
        xeKhachRepo.save(xeKhach);
    }

    @Override
    public void deleteXeKhach(int id) {
        xeKhachRepo.deleteById(id);
    }

    @Override
    public Optional<XeKhach> getXeKhachById(int id) {
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
}
