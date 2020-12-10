package transport.model;

import java.sql.Date;

public class XeKhach {
	private Long xeKhachId;
	private String bienSo;
	private String mauXe;
	private String hangSanXuat;
	private int doiXe;
	private String model;
	private int soGhe;
	private int soNamSuDung;
	private Date ngayBaoDuong; //ngay bao duong truoc do.
	private String ngayBaoDuongTiepTheo; //ngay bao duong tiep theo.

	public XeKhach(){}

	public XeKhach(Long xeKhachId, String bienSo, String mauXe, String hangSanXuat, int doiXe, String model, int soGhe, int soNamSuDung, Date ngayBaoDuong){
		this.xeKhachId = xeKhachId;
		this.bienSo = bienSo;
		this.mauXe = mauXe;
		this.hangSanXuat = hangSanXuat;
		this.doiXe = doiXe;
		this.model = model;
		this.soGhe = soGhe;
		this.soNamSuDung = soNamSuDung;
		this.ngayBaoDuong = ngayBaoDuong;
	}

	public XeKhach(String bienSo, String mauXe, String hangSanXuat, int doiXe, String model, int soGhe, int soNamSuDung, Date ngayBaoDuong, String ngayBaoDuongTiepTheo){
		this.bienSo = bienSo;
		this.mauXe = mauXe;
		this.hangSanXuat = hangSanXuat;
		this.doiXe = doiXe;
		this.model = model;
		this.soGhe = soGhe;
		this.soNamSuDung = soNamSuDung;
		this.ngayBaoDuong = ngayBaoDuong;
		this.ngayBaoDuongTiepTheo = ngayBaoDuongTiepTheo;
	}

	public Long getXeKhachId() {
		return xeKhachId;
	}

	public void setXeKhachId(Long xeKhachId) {
		this.xeKhachId = xeKhachId;
	}

	public String getBienSo() {
		return bienSo;
	}

	public void setBienSo(String bienSo) {
		this.bienSo = bienSo;
	}

	public String getMauXe() {
		return mauXe;
	}

	public void setMauXe(String mauXe) {
		this.mauXe = mauXe;
	}

	public String getHangSanXuat() {
		return hangSanXuat;
	}

	public void setHangSanXuat(String hangSanXuat) {
		this.hangSanXuat = hangSanXuat;
	}

	public int getDoiXe() {
		return doiXe;
	}

	public void setDoiXe(int doiXe) {
		this.doiXe = doiXe;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSoGhe() {
		return soGhe;
	}

	public void setSoGhe(int soGhe) {
		this.soGhe = soGhe;
	}

	public int getSoNamSuDung() {
		return soNamSuDung;
	}

	public void setSoNamSuDung(int soNamSuDung) {
		this.soNamSuDung = soNamSuDung;
	}

	public Date getNgayBaoDuong() {
		return ngayBaoDuong;
	}

	public void setNgayBaoDuong(Date ngayBaoDuong) {
		this.ngayBaoDuong = ngayBaoDuong;
	}

	public String getNgayBaoDuongTiepTheo(){ return ngayBaoDuongTiepTheo; }

	public void setNgayBaoDuongTiepTheo(String ngayBaoDuongTiepTheo) {
		this.ngayBaoDuongTiepTheo = ngayBaoDuongTiepTheo;
	}
}
