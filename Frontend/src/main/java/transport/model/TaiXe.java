package transport.model;
import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Size;

public class TaiXe {
	private Long taiXeId;
	private String ten;
	@Size(min=5, message="Name must be 6 characters long")
	private String cmt;
	private String maSoBangLai;
	private String loaiBang;
	private String diaChi;
	private Date ngaySinh;
	private int thamNien;
	private List<ChuyenXe> listChuyenXePhu;
	private List<ChuyenXe> listChuyenXeLai;
	private float salary;

	public TaiXe(){}

	public TaiXe(String ten, String cmt, String maSoBangLai, String loaiBang, String diaChi, Date ngaySinh, int thamNien){
		this.ten = ten;
		this.cmt = cmt;
		this.maSoBangLai = maSoBangLai;
		this.loaiBang = loaiBang;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.thamNien = thamNien;
	}

	public TaiXe(Long taiXeId, String ten, String cmt, String maSoBangLai, String loaiBang, String diaChi, Date ngaySinh, int thamNien){
		this.taiXeId = taiXeId;
		this.ten = ten;
		this.cmt = cmt;
		this.maSoBangLai = maSoBangLai;
		this.loaiBang = loaiBang;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.thamNien = thamNien;
	}

	public Long getTaiXeId() {
		return taiXeId;
	}

	public void setTaiXeId(Long taiXeId) {
		this.taiXeId = taiXeId;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getCmt() {
		return cmt;
	}

	public void setCmt(String cmt) {
		this.cmt = cmt;
	}

	public String getMaSoBangLai() {
		return maSoBangLai;
	}

	public void setMaSoBangLai(String maSoBangLai) {
		this.maSoBangLai = maSoBangLai;
	}

	public String getLoaiBang() {
		return loaiBang;
	}

	public void setLoaiBang(String loaiBang) {
		this.loaiBang = loaiBang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public int getThamNien() {
		return thamNien;
	}

	public void setThamNien(int thamNien) {
		this.thamNien = thamNien;
	}
}
