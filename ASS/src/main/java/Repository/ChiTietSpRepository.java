package Repository;

import domain_model.ChiTietSp;
import domain_model.KhachHang;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
import view_model.QLChiTietSP;
import view_model.QLKhachHang;

import java.util.ArrayList;
import java.util.List;

public class ChiTietSpRepository {
    private Session hSession;

    public ChiTietSpRepository() {

        this.hSession = HibernateUtil.getFACTORY().openSession();
    }

    public void insert(ChiTietSp chiTietSP) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.persist(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void update(ChiTietSp chiTietSP) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.merge(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public void delete(ChiTietSp chiTietSP) {
        Transaction transaction = this.hSession.getTransaction();
        try {
            transaction.begin();
            this.hSession.delete(chiTietSP);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
    }

    public ChiTietSp findById(String id) {
        return this.hSession.find(ChiTietSp.class, id);
    }

    public List<ChiTietSp> findAll() {
        String hql = "SELECT obj FROM ChiTietSp obj";
        TypedQuery<ChiTietSp> query = this.hSession.createQuery(hql, ChiTietSp.class);
        return query.getResultList();
    }

}
