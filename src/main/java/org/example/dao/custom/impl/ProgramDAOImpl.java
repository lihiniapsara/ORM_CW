package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dto.ProgramDTO;
import org.example.entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProgramDAOImpl {
    public boolean save(ProgramDTO programDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(programDTO);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(ProgramDTO programDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(programDTO);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(long programId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Program program = session.get(Program.class, programId);
        if (program != null) {
            session.delete(program);
            transaction.commit();
            session.close();
            return true;
        }
        session.close();
        return false;
    }

    public List<ProgramDTO> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<ProgramDTO> programs = session.createQuery("FROM Program").list();
        transaction.commit();
        session.close();
        return programs;
    }
}
