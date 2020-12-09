package transport.repository;

import org.springframework.stereotype.Service;
import transport.model.DoanhThuXeKhach;

import java.sql.Date;
import java.util.List;
@Service
public interface DoanhThuRepository {
    List<DoanhThuXeKhach> tinhDoanhThu(Date startDate, Date endDate);
}
