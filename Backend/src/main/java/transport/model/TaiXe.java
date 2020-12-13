package transport.model;

import java.io.Serializable;
import java.sql.Date;
import java.text.ParseException;
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
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

//@Data Su dung DATA trong intellij bi loi nen get set phai viet lai.
@Entity
public class TaiXe implements Serializable {
	@Id
	@Column(name="taiXeId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long taiXeId;
//	@Size(min = 5, message = "Name must be at least 5 characters long")
	private String ten;
	@NotNull
	@Size(min=5, message="Name must be 6 characters long")
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

	private float salary;
	public TaiXe(){}

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
	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary= salary;
	}
	public void setSalary() throws ParseException{
		long millis=System.currentTimeMillis();   
    	java.sql.Date date2 =new java.sql.Date(millis);   
//    	System.out.println(date);
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    	java.sql.Date dau_thang = (java.sql.Date) sdf.parse("2020-12-01");
    	String str = "2020-12-01";
    	Date date1 = Date.valueOf(str);
    	
		float s1 = 0;
		
		for (ChuyenXe j : listChuyenXeLai) {
			
			if (j.getNgayDi().after(date1)&&j.getNgayDi().before(date2)||j.getNgayDi().equals(date2)) {
				s1 += j.getGiaVe() * j.getSoKhach() * 0.4;
				if (j.getTuyenXe().getDoPhucTap() == 2) {
					s1 += 100;
				}
				if (j.getTuyenXe().getDoPhucTap() == 3) {
					s1 += 150;
				}
			}
		}
		float s2 =0;
		for (ChuyenXe k : listChuyenXePhu) {
			float s = 0;
			if (k.getNgayDi().after(date1)&&k.getNgayDi().before(date2)||k.getNgayDi().equals(date2)) {
				s += k.getGiaVe() * k.getSoKhach() * 0.4;
				if (k.getTuyenXe().getDoPhucTap() == 2) {
					s += 100;
				}
				if (k.getTuyenXe().getDoPhucTap() == 3) {
					s += 150;
				}
			}
			s /= 2;
			s2 += s;
		}
		this.salary = s1+s2;
		
	}
}
