package org.example.bo.custom.impl;

import org.example.dao.custom.impl.ProgramDAOImpl;
import org.example.dto.ProgramDTO;
import org.example.entity.Program;
import org.example.entity.User;

import java.util.ArrayList;
import java.util.List;

public class ProgramBOImpl {
    ProgramDAOImpl programDAO = new ProgramDAOImpl();

    // Save a new program
    public boolean save(ProgramDTO programDTO) {
        return programDAO.save(new Program(programDTO.getProgram_id(),programDTO.getProgram_name(), programDTO.getDuration(), programDTO.getFee()));
    }

    // Update an existing program
    public boolean update(ProgramDTO programDTO) {
        return programDAO.update(new Program(programDTO.getProgram_id(),programDTO.getProgram_name(), programDTO.getDuration(), programDTO.getFee()));

    }

    // Delete a program by ID
    public boolean delete(String programId) {
        return programDAO.delete(programId);
    }

    // Retrieve all programs
    public List<ProgramDTO> getAllPrograms() {
        return programDAO.getAll();
    }

    public ArrayList<ProgramDTO> getAll() {
        List<ProgramDTO> programDTOs = programDAO.getAll();
        return new ArrayList<>(programDTOs);
    }

}
