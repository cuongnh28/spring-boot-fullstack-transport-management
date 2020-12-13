package transport.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
//Tinh doanh thu xe khach theo yeu cau nang cao.
@SqlResultSetMapping(
		name = "DoanhThuResult",
		classes = {
				@ConstructorResult(
						targetClass = DoanhThuXeKhach.class,
						columns = {
								@ColumnResult(name = "xe_khach_id", type = Long.class),
								@ColumnResult(name = "bien_so", type = String.class),
								@ColumnResult(name = "doanh_thu", type = Float.class)
						}
				)
		}
)
public class XeKhach implements Serializable {
	@Id
	@Column(name="xeKhachId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long xeKhachId;
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
	@OneToMany(mappedBy = "xeKhach", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ChuyenXe> listChuyenXe;
	//@Transient
	private String ngayBaoDuongTiepTheo;

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

	@JsonIgnore
	public List<ChuyenXe> getListChuyenXe() {
		return listChuyenXe;
	}

	@JsonIgnore
	public void setListChuyenXe(List<ChuyenXe> listChuyenXe) {
		this.listChuyenXe = listChuyenXe;
	}

//	@JsonIgnore
//	public void setNgayBaoDuongTiepTheo(String ngayBaoDuongTiepTheo) {
//		this.ngayBaoDuongTiepTheo = ngayBaoDuongTiepTheo;
//	}

	public String getNgayBaoDuongTiepTheo(){
		Date ngayBdTiepTheo = addDays(ngayBaoDuong, 360);
		for(ChuyenXe chuyenXe:listChuyenXe){
			//Neu he so kho la 2 thi * 1.2 con neu la 3 thi * 1.5
			int heSoKho = 100;
			if(chuyenXe.getTuyenXe().getDoPhucTap() == 2){
				heSoKho *= 1.2;
			}
			else if(chuyenXe.getTuyenXe().getDoPhucTap() == 3){
				heSoKho *= 1.5;
			}
			//Ngay bao duong tiep theo se bang ngay dung han tru di quangduong/heSoKho.
			ngayBdTiepTheo = subtractDays(ngayBdTiepTheo, chuyenXe.getTuyenXe().getQuangDuong()/heSoKho);
		}
		if(ngayBdTiepTheo.compareTo(new Date(System.currentTimeMillis())) < 0){
			ngayBaoDuongTiepTheo = "Đã quá hạn bảo dưỡng";
			return ngayBaoDuongTiepTheo;
		}
		else{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			ngayBaoDuongTiepTheo = dateFormat.format(ngayBdTiepTheo);
			return ngayBaoDuongTiepTheo;
		}
	}

	//Ham cong ngay.
	@JsonIgnore
	public static Date addDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, days);
		return new Date(c.getTimeInMillis());
    }

    //Ham tru ngay.
	@JsonIgnore
	public static Date subtractDays(Date date, int days) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, -days);
		return new Date(c.getTimeInMillis());
	}

}
