package transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

//@Data Su dung DATA trong intellij bi loi nen get set phai viet lai.
@Entity
public class TaiXe implements Serializable {
	@Id
	@Column(name="taiXeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int taiXeId;
//	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String ten;
	@NotNull
	private String cmt;
	@NotNull
	private String maSoBangLai;
	private String loaiBang;
	private String diaChi;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaySinh;
	private int thamNien;

	@OneToMany(mappedBy = "laiXe", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChuyenXe> listChuyenXeLai; //list chuyen xe ma tai xe lam lai xe.
	@OneToMany(mappedBy = "phuXe", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChuyenXe> listChuyenXePhu; //list chuyen xe ma tai xe lam phu xe.

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

	public TaiXe(int taiXeId, String ten, String cmt, String maSoBangLai, String loaiBang, String diaChi, Date ngaySinh, int thamNien){
		this.taiXeId = taiXeId;
		this.ten = ten;
		this.cmt = cmt;
		this.maSoBangLai = maSoBangLai;
		this.loaiBang = loaiBang;
		this.diaChi = diaChi;
		this.ngaySinh = ngaySinh;
		this.thamNien = thamNien;
	}

	public int getTaiXeId() {
		return taiXeId;
	}

	public void setTaiXeId(int taiXeId) {
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

	@JsonIgnore
	public List<ChuyenXe> getListChuyenXeLai(){
		return this.listChuyenXeLai;
	}

	public void setListChuyenXeLai(List<ChuyenXe> listChuyenXeLai){
		this.listChuyenXeLai = listChuyenXeLai;
	}

	@JsonIgnore
	public List<ChuyenXe> getListChuyenXePhu(){
		return this.listChuyenXePhu;
	}

	public void setListChuyenXePhu(List<ChuyenXe> listChuyenXePhu){
		this.listChuyenXePhu = listChuyenXePhu;
	}
}
