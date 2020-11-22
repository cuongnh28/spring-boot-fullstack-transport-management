package transport.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
//@RequiredArgsConstructor
public class XeKhach {
	@Id
	@Column(name="xeKhachId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int xe_Id;
	@NotNull
	private String bienSo;
	private String mauXe;
	private String hangSanXuat;
	private int doiXe;
	private String model;
	@NotNull
	private int soGhe;
	private int soNamSuDung;
	private Date ngayBaoDuong;
	public XeKhach(){}
	@OneToMany(mappedBy = "xeKhach", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChuyenXe> listChuyenXe;
}
