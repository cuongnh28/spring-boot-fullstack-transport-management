package transport.model;

import org.hibernate.validator.constraints.Range;

public class TuyenXe {

	private Long tuyenXeId;
	private String diemDau;
	private String diemCuoi;
	@Range(min = 1, max =3)
	private int doPhucTap;

	public TuyenXe(){}

	public TuyenXe(Long taiXeId, String diemDau, String diemCuoi, int doPhucTap){
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

	public Long getTuyenXeId() {
		return tuyenXeId;
	}

	public void setTuyenXeId(Long tuyenXeId) {
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

}
