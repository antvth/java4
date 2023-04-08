package domain_model;

import jakarta.persistence.*;


@Entity
@Table(name = "ChiTietSp")


public class ChiTietSp {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "UNIQUEIDENTIFIER DEFAULT NEWID()")
    private String Id;

    @Column(name = "NamBH")
    private String NamBH;

    @Column(name = "MoTa")
    private String MoTa;

    @Column(name = "SoLuongTon")
    private String SoLuongTon;

    @Column(name = "GiaNhap")
    private String GiaNhap;

    @Column(name = "GiaBan")
    private String GiaBan;

    @ManyToOne()
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id"
    )
    private SanPham sp;

    @ManyToOne()
    @JoinColumn(
            name = "IdNsx",
            referencedColumnName = "Id"
    )
    private Nsx nsx;


    @ManyToOne()
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id"
    )
    private MauSac ms;

    @ManyToOne()
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id"
    )
    private DongSp dongsp;


    public ChiTietSp() {
    }

    public ChiTietSp(String id, String namBH, String moTa, String soLuongTon, String giaNhap, String giaBan, SanPham sp, Nsx nsx, MauSac ms, DongSp dongsp) {
        Id = id;
        NamBH = namBH;
        MoTa = moTa;
        SoLuongTon = soLuongTon;
        GiaNhap = giaNhap;
        GiaBan = giaBan;
        this.sp = sp;
        this.nsx = nsx;
        this.ms = ms;
        this.dongsp = dongsp;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getNamBH() {
        return NamBH;
    }

    public void setNamBH(String namBH) {
        NamBH = namBH;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getSoLuongTon() {
        return SoLuongTon;
    }

    public void setSoLuongTon(String soLuongTon) {
        SoLuongTon = soLuongTon;
    }

    public String getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(String giaNhap) {
        GiaNhap = giaNhap;
    }

    public String getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(String giaBan) {
        GiaBan = giaBan;
    }

    public SanPham getSp() {
        return sp;
    }

    public void setSp(SanPham sp) {
        this.sp = sp;
    }

    public Nsx getNsx() {
        return nsx;
    }

    public void setNsx(Nsx nsx) {
        this.nsx = nsx;
    }

    public MauSac getMs() {
        return ms;
    }

    public void setMs(MauSac ms) {
        this.ms = ms;
    }

    public DongSp getDongsp() {
        return dongsp;
    }

    public void setDongsp(DongSp dongsp) {
        this.dongsp = dongsp;
    }
}
