package transport.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;

@Entity
@Data
//@RequiredArgsConstructor
public class ChuyenXe {
	@Id
	@Column(name="chuyenXeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int chuyenXeId;

	@NonNull
	private int soKhach;
	@NonNull
	private float giaVe;
	@NonNull
	private Date ngayDi;

	public ChuyenXe(){}

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "laiXeId")
	private TaiXe laiXe;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "phuXeId")
	private TaiXe phuXe;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "xeKhachId")
	private XeKhach xeKhach;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "tuyenXeId")
	private TuyenXe tuyenXe;

}
