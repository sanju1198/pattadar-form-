package com.example.demo.service;

import com.example.demo.entity.FormEntity;
import com.example.demo.Repository.FormRepo;
import com.example.demo.exception.ValidationException; // Use the custom exception
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormServiceImpl implements FormService {

    @Autowired
    private FormRepo formRepository;

    @Override
    public void validateForm(FormEntity formEntity) throws ValidationException {
        String landOwner = formEntity.getLandOwner();
        String fatherName = formEntity.getFatherName();
        String aadhaarNo = formEntity.getAadhaarNo();
        Boolean newPattadarBook = formEntity.getNewPattadarBook();
        String newPattadarBookNo = formEntity.getNewPattadarBookNo();
        Boolean oldPattadarBook = formEntity.getOldPattadarBook();
        String khataNo = formEntity.getKhataNo();

        // Validate Land Owner
        if (landOwner == null || landOwner.trim().isEmpty()) {
            throw new ValidationException("Land Owner name cannot be empty");
        }

        // Validate Father Name
        if (fatherName == null || fatherName.trim().isEmpty()) {
            throw new ValidationException("Father Name cannot be empty");
        }

        // Validate Aadhaar Number (12 digits)
        if (aadhaarNo == null || !aadhaarNo.matches("\\d{12}")) {
            throw new ValidationException("Invalid Aadhaar number. It must be 12 digits long.");
        }

        // Validate New Pattadar Book
        if (newPattadarBook == null) {
            throw new ValidationException("New Pattadar Book status cannot be null");
        }

        // Validate New Pattadar Book No
        if (newPattadarBookNo == null || !newPattadarBookNo.matches("[T][A-Z]{2}[A-Z]{2}[0-9]{4}")) {
            throw new ValidationException("Invalid New Pattadar Book No. Format should be like TXXADXX1234");
        }

        // Validate Old Pattadar Book
        if (oldPattadarBook == null) {
            throw new ValidationException("Old Pattadar Book status cannot be null");
        }

        // Validate Khata No
        if (khataNo == null || !khataNo.matches("[A-Z0-9]+([-][A-Z0-9]+)*(/[A-Z]+)?")) {
            throw new ValidationException("Invalid Khata No. Format should be like 12345/A or XYZ-6789");
        }
    }

    @Override
    public void saveForm(FormEntity formEntity) {
        formRepository.save(formEntity);
    }
}
