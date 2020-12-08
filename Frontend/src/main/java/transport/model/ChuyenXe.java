package transport.model;

import java.sql.Date;

public class ChuyenXe {

    private Long chuyenXeId;
    private int soKhach;
    private float giaVe;
    private Date ngayDi;
    private Long phuXeId;
    private Long laiXeId;
    private Long xeKhachId;
    private Long tuyenXeId;
    private String tenLaiXe;
    private String tenPhuXe;
    private String bienSoXe;

    public ChuyenXe() {
    }

    public ChuyenXe(Long chuyenXeId, int soKhach, float giaVe, Date ngayDi, Long phuXeId, Long laiXeId, Long xeKhachId, Long tuyenXeId, String tenLaiXe, String tenPhuXe, String bienSoXe) {
        this.chuyenXeId = chuyenXeId;
        this.soKhach = soKhach;
        this.giaVe = giaVe;
        this.ngayDi = ngayDi;
        this.phuXeId = phuXeId;
        this.laiXeId = laiXeId;
        this.xeKhachId = xeKhachId;
        this.tuyenXeId = tuyenXeId;
        this.tenLaiXe = tenLaiXe;
        this.tenPhuXe = tenPhuXe;
        this.bienSoXe = bienSoXe;
    }

    public ChuyenXe(float giaVe, int soKhach, Date ngayDi, Long laiXeId, Long phuXeId, Long tuyenXeId, Long xeKhachId) {
        this.giaVe = giaVe;
        this.soKhach = soKhach;
        this.ngayDi = ngayDi;
        this.laiXeId = laiXeId;
        this.phuXeId = phuXeId;
        this.tuyenXeId = tuyenXeId;
        this.xeKhachId = xeKhachId;
    }

    public Long getChuyenXeId() {
        return chuyenXeId;
    }

    public void setChuyenXeId(Long chuyenXeId) {
        this.chuyenXeId = chuyenXeId;
    }

    public float getGiaVe() {
        return giaVe;
    }

    public void setGiaVe(float giaVe) {
        this.giaVe = giaVe;
    }

    public int getSoKhach() {
        return soKhach;
    }

    public void setSoKhach(int soKhach) {
        this.soKhach = soKhach;
    }

    public Date getNgayDi() {
        return ngayDi;
    }

    public void setNgayDi(Date ngayDi) {
        this.ngayDi = ngayDi;
    }

    public Long getLaiXeId() {
        return laiXeId;
    }

    public void setLaiXeId(Long laiXeId) {
        this.laiXeId = laiXeId;
    }

    public Long getPhuXeId() {
        return phuXeId;
    }

    public void setPhuXeId(Long phuXeId) {
        this.phuXeId = phuXeId;
    }

    public Long getTuyenXeId() {
        return tuyenXeId;
    }

    public void setTuyenXeId(Long tuyenXeId) {
        this.tuyenXeId = tuyenXeId;
    }

    public Long getXeKhachId() {
        return xeKhachId;
    }

    public void setXeKhachId(Long xeKhachId) {
        this.xeKhachId = xeKhachId;
    }

    public String getTenLaiXe() {
        return tenLaiXe;
    }

    public void setTenLaiXe(String tenLaiXe) {
        this.tenLaiXe = tenLaiXe;
    }

    public String getTenPhuXe() {
        return tenPhuXe;
    }

    public void setTenPhuXe(String tenPhuXe) {
        this.tenPhuXe = tenPhuXe;
    }

    public String getBienSoXe() {
        return bienSoXe;
    }

    public void setBienSoXe(String bienSoXe) {
        this.bienSoXe = bienSoXe;
    }
}
