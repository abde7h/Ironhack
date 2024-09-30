package service;

import model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DoctorRepository;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorStatus(Long id, String status) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setStatus(status);
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctorDepartment(Long id, String department) {
        Doctor doctor = doctorRepository.findById(id).orElseThrow();
        doctor.setDepartment(department);
        return doctorRepository.save(doctor);
    }
}

