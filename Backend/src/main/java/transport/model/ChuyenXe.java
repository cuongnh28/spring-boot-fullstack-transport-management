package transport.model;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
public class ChuyenXe implements Serializable {
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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "laiXeId")
	private TaiXe laiXe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phuXeId")
	private TaiXe phuXe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "xeKhachId")
	private XeKhach xeKhach;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tuyenXeId")
	private TuyenXe tuyenXe;

	public ChuyenXe(){}

	public ChuyenXe(int chuyenXeId, int soKhach, int giaVe, Date ngayDi, TaiXe laiXe, TaiXe phuXe, TuyenXe tuyenXe, XeKhach xeKhach){
		this.chuyenXeId = chuyenXeId;
		this.soKhach = soKhach;
		this.giaVe = giaVe;
		this.ngayDi = ngayDi;
		this.laiXe = laiXe;
		this.phuXe = phuXe;
		this.tuyenXe = tuyenXe;
		this.xeKhach = xeKhach;
	}

	public ChuyenXe(int soKhach, int giaVe, Date ngayDi, TaiXe laiXe, TaiXe phuXe, TuyenXe tuyenXe, XeKhach xeKhach){
		this.soKhach = soKhach;
		this.giaVe = giaVe;
		this.ngayDi = ngayDi;
		this.laiXe = laiXe;
		this.phuXe = phuXe;
		this.tuyenXe = tuyenXe;
		this.xeKhach = xeKhach;
	}

	public int getChuyenXeId() {
		return chuyenXeId;
	}

	public void setChuyenXeId(int chuyenXeId) {
		this.chuyenXeId = chuyenXeId;
	}

	public int getSoKhach() {
		return soKhach;
	}

	public void setSoKhach(int soKhach) {
		this.soKhach = soKhach;
	}

	public float getGiaVe() {
		return giaVe;
	}

	public void setGiaVe(float giaVe) {
		this.giaVe = giaVe;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	@JsonIgnore
	public TaiXe getLaiXe() {
		return laiXe;
	}

	public void setLaiXe(TaiXe laiXe) {
		this.laiXe = laiXe;
	}

	@JsonIgnore
	public TaiXe getPhuXe() {
		return phuXe;
	}

	public void setPhuXe(TaiXe phuXe) {
		this.phuXe = phuXe;
	}

	@JsonIgnore
	public XeKhach getXeKhach() {
		return xeKhach;
	}

	public void setXeKhach(XeKhach xeKhach) {
		this.xeKhach = xeKhach;
	}

	@JsonIgnore
	public TuyenXe getTuyenXe() {
		return tuyenXe;
	}

	public void setTuyenXe(TuyenXe tuyenXe) {
		this.tuyenXe = tuyenXe;
	}

	public int getLaiXeId() {
		return laiXe.getTaiXeId();
	}

//	public void setLaiXeId(int laiXeId){
//		this.laiXe.setTaiXeId(laiXeId);
//	}

	public int getPhuXeId() {
		return phuXe.getTaiXeId();
	}

//	public void setPhuXeId(int phuXeId){
//		this.phuXe.setTaiXeId(phuXeId);
//	}

	public int getXeKhachId() {
		return xeKhach.getXeKhachId();
	}

//	public void setXeKhachId(int xeKhachId){
//		this.xeKhach.setXeKhachId(xeKhachId);
//	}

	public int getTuyenXeId() {
		return tuyenXe.getTuyenXeId();
	}

//	public void setTuyenXeId(int tuyenXeId){
//		this.tuyenXe.setTuyenXeId(tuyenXeId);
//	}

}
