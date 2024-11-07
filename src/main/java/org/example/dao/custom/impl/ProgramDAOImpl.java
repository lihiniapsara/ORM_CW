package org.example.dao.custom.impl;

import org.example.config.FactoryConfiguration;
import org.example.dto.ProgramDTO;
import org.example.entity.Program;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ProgramDAOImpl {
    public boolean save(Program programDTO) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.save(programDTO);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean update(Program program) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(program);
        transaction.commit();
        session.close();
        return true;
    }

    public boolean delete(String programId) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.createNativeQuery("DELETE FROM Program WHERE program_id = :programId").setParameter("programId", programId)
                .executeUpdate();
        transaction.commit();
        session.close();
        return true;
    }

    public List<ProgramDTO> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        List<Program> programs = session.createQuery("FROM Program", Program.class).list();
        transaction.commit();
        session.close();

        List<ProgramDTO> programDTOs = new ArrayList<>();
        for (Program program : programs) {
            programDTOs.add(new ProgramDTO(program.getProgramId(), program.getName(), program.getDuration(), program.getFee()));
        }
        return programDTOs;
    }

}
