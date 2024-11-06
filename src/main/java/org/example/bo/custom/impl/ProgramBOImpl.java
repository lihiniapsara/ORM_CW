package org.example.bo.custom.impl;

import org.example.dao.custom.impl.ProgramDAOImpl;
import org.example.dto.ProgramDTO;

import java.util.List;

public class ProgramBOImpl {
    ProgramDAOImpl programDAO = new ProgramDAOImpl();

    // Save a new program
    public boolean save(ProgramDTO programDTO) {
        return programDAO.save(new ProgramDTO(programDTO.getProgram_name(), programDTO.getDuration(), programDTO.getFee()));
    }

    // Update an existing program
    public boolean update(ProgramDTO programDTO) {
        return programDAO.update(programDTO);
    }

    // Delete a program by ID
    public boolean delete(long programId) {
        return programDAO.delete(programId);
    }

    // Retrieve all programs
    public List<ProgramDTO> getAllPrograms() {
        return programDAO.getAll();
    }
}
