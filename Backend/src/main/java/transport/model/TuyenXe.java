package transport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@Entity
//@RequiredArgsConstructor
public class TuyenXe {
	@Id
	@Column(name="tuyenXeId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int tuyenXeId;
	@NotNull
	private String diemDau;
	@NotNull
	private String diemCuoi;
	@NotNull
	private int doPhucTap;
	public TuyenXe(){}
	@OneToMany(mappedBy = "tuyenXe", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChuyenXe> listChuyenXe;
}
