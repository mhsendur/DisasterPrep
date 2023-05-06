package com.project.disasterprep.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.project.disasterprep.entity.Disaster;
import com.project.disasterprep.entity.EmergencyContact;
import com.project.disasterprep.entity.PreparednessChecklist;
import com.project.disasterprep.repository.DisasterRepository;
import com.project.disasterprep.repository.EmergencyContactRepository;
import com.project.disasterprep.repository.PreparednessChecklistRepository;

@RestController
@RequestMapping("/disasterprep")
public class DisasterPrepController {

    @Autowired private DisasterRepository disasterRepository;
    @Autowired private EmergencyContactRepository emergencyContactRepository;
    @Autowired private PreparednessChecklistRepository preparednessChecklistRepository;

    @PostConstruct
    public void init() {

        if (disasterRepository.count() == 0) {
            Disaster earthquake = new Disaster("Earthquake", "Tectonic movements");
            Disaster hurricane = new Disaster("Hurricane", "High wind speeds and heavy rain");
            disasterRepository.saveAll(Arrays.asList(earthquake, hurricane));
        }

        if (emergencyContactRepository.count() == 0) {
            EmergencyContact contact1 = new EmergencyContact("Emergency Services", "112");
            EmergencyContact contact2 = new EmergencyContact("Police", "155");
            EmergencyContact contact3 = new EmergencyContact("Fire Department", "110");
            emergencyContactRepository.saveAll(Arrays.asList(contact1, contact2, contact3));
        }

        if (preparednessChecklistRepository.count() == 0) {
            PreparednessChecklist earthquakeChecklist = new PreparednessChecklist("Earthquake", new String[] { "Water", "Non-perishable food", "First aid supplies", "Flashlight", "Radio" });
            PreparednessChecklist hurricaneChecklist = new PreparednessChecklist("Hurricane", new String[] { "Water", "Non-perishable food", "First aid supplies", "Flashlight", "Battery-operated radio", "Cash" });
            preparednessChecklistRepository.saveAll(Arrays.asList(earthquakeChecklist, hurricaneChecklist));
        }

    }

    @GetMapping("/disasters")
    public List<Disaster> getAllDisasters() {
        return disasterRepository.findAll();
    }

    @PostMapping("/disasters/save")
    public Disaster createDisaster(@RequestBody Disaster disaster) {
        return disasterRepository.save(disaster);
    }

    @DeleteMapping("/disasters/{id}")
    public void deleteDisasterById(@PathVariable("id") String id) {
        disasterRepository.deleteById(id);
    }

    @GetMapping("/emergencycontacts")
    public List<EmergencyContact> getAllEmergencyContacts() {
        return emergencyContactRepository.findAll();
    }

    @PostMapping("/emergencycontacts/save")
    public EmergencyContact createEmergencyContact(@RequestBody EmergencyContact contact) {
        return emergencyContactRepository.save(contact);
    }
    
    @DeleteMapping("/emergencycontacts/{id}")
    public void deleteEmergencyContactById(@PathVariable("id") String id) {
        emergencyContactRepository.deleteById(id);
    }

    @GetMapping("/preparednesschecklists")
    public List<PreparednessChecklist> getAllPreparednessChecklists() {
        return preparednessChecklistRepository.findAll();
    }

    @PostMapping("/preparednesschecklists/save")
    public PreparednessChecklist createPreparednessChecklist(@RequestBody PreparednessChecklist preparednessChecklist) {
        return preparednessChecklistRepository.save(preparednessChecklist);
    }
}