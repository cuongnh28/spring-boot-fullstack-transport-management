package transport.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Entity
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
	@Range(min = 1, max =3)
	private int doPhucTap;
	@OneToMany(mappedBy = "tuyenXe", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChuyenXe> listChuyenXe; //list Chuyen Xe co su dung tuyen xe nay.

	public TuyenXe(){}

	public TuyenXe(int taiXeId, String diemDau, String diemCuoi, int doPhucTap){
		this.tuyenXeId = taiXeId;
		this.diemDau = diemDau;
		this.diemCuoi = diemCuoi;
		this.doPhucTap = doPhucTap;
	}

	public TuyenXe(String diemDau, String diemCuoi, int doPhucTap){
		this.diemDau = diemDau;
		this.diemCuoi = diemCuoi;
		this.doPhucTap = doPhucTap;
	}

	public int getTuyenXeId() {
		return tuyenXeId;
	}

	public void setTuyenXeId(int tuyenXeId) {
		this.tuyenXeId = tuyenXeId;
	}

	public String getDiemCuoi() {
		return diemCuoi;
	}

	public void setDiemCuoi(String diemCuoi) {
		this.diemCuoi = diemCuoi;
	}

	public String getDiemDau() {
		return diemDau;
	}

	public void setDiemDau(String diemDau) {
		this.diemDau = diemDau;
	}

	public int getDoPhucTap() {
		return doPhucTap;
	}

	public void setDoPhucTap(int doPhucTap) {
		this.doPhucTap = doPhucTap;
	}

	@JsonIgnore
	private List<ChuyenXe> getListChuyenXe() { return this.listChuyenXe; }

	@JsonIgnore
	private void setListChuyenXe(List<ChuyenXe> listChuyenXe) {
		this.listChuyenXe = listChuyenXe;
	}

}
