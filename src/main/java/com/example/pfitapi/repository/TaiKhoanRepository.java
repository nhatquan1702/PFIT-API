package com.example.pfitapi.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TaiKhoanRepository {
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    public Boolean checkTaiKhoan(String email){
//        Session session = sessionFactory.getCurrentSession();
//        return (Long) session.createQuery("select count(*) from KhachHang as a where a.maHocVien = '"+email+"'").uniqueResult() > 0;
//    }
}
