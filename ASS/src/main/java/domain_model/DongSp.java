package domain_model;

import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
public class DongSp {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Type(type = "uuid-char")
    private UUID id;

    @Column(name = "Ma")
    private String Ma;

    @Column(name = "Ten")
    private String Ten;

    @OneToMany(
            mappedBy = "dongsp",
            fetch = FetchType.LAZY
    )
    private List<ChiTietSp> listCtsp;

    public DongSp() {
    }

    public DongSp(UUID id, String ma, String ten, List<ChiTietSp> listCtsp) {
        this.id = id;
        Ma = ma;
        Ten = ten;
        this.listCtsp = listCtsp;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String ma) {
        Ma = ma;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public List<ChiTietSp> getListCtsp() {
        return listCtsp;
    }

    public void setListCtsp(List<ChiTietSp> listCtsp) {
        this.listCtsp = listCtsp;
    }
}