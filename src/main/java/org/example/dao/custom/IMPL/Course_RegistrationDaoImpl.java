package org.example.dao.custom.IMPL;

import org.example.config.FactoryConfiguration;
import org.example.dao.custom.Course_registrationDao;
import org.example.entity.Student_programDetail;
import org.hibernate.Session;

import java.io.Serializable;

public class Course_RegistrationDaoImpl implements Course_registrationDao {

    @Override

    public String getNewId() {

        Session session = FactoryConfiguration.getInstance().getSession();
        String hql = "select max(spid) from Student_programDetail";
        String result = (String) session.createQuery(hql).uniqueResult();
        if (result == null) {
            return "1";
        } else {
            int id = Integer.parseInt(result);
            id = id + 1;
            return String.valueOf(id);
        }
    }

    @Override
    public boolean save(Student_programDetail studentProgramDetail, Session session) {
        try {
            Serializable id = (Serializable) session.save(studentProgramDetail);
            if (id != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getspid(String sid, String pid) {
        System.out.println(sid + pid);
        Session session = FactoryConfiguration.getInstance().getSession();
        String hql = "select spid from Student_programDetail where student.id = :sid and program.programId = :pid";
        String spid = (String) session.createQuery(hql).setParameter("sid", sid).setParameter("pid", pid).uniqueResult();
        if (spid != null) {
            return spid;
        }
        return null;
    }


}
