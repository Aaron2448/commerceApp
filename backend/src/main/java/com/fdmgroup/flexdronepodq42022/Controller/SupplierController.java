package com.fdmgroup.flexdronepodq42022.Controller;

import com.fdmgroup.flexdronepodq42022.Model.Supplier;
import com.fdmgroup.flexdronepodq42022.Repository.SupplierRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
@RestController
@RequestMapping("/api/v1/suppliers")
public class SupplierController {
    private final SupplierRepository supplierRepository;

    @Autowired
    public SupplierController(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    @GetMapping("/getAll")
    public List<Supplier> getAllSuppliers() {
        log.info("Getting all suppliers: " + supplierRepository.findAll());

        return supplierRepository.findAll();
    }

    @PostMapping("/create")
    public Supplier createSupplier(@RequestBody Supplier supplier) {
        log.info("Creating supplier: " + supplier);

        return supplierRepository.save(supplier);
    }

    @PutMapping("/update/{id}")
    public Supplier updateSupplier(@PathVariable Long id, @RequestBody Supplier supplier) {
        Supplier existingSupplier = supplierRepository.findById(id).orElse(null);
        if (existingSupplier == null) {
            log.info("Supplier with id: " + id + " does not exist");
            return null;
        }
        existingSupplier.setName(supplier.getName());
        existingSupplier.setLocation(supplier.getLocation());
        existingSupplier.setEmail(supplier.getEmail());
        existingSupplier.setPhone(supplier.getPhone());
        log.info("Updating supplier: " + existingSupplier);

        return supplierRepository.save(existingSupplier);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSupplier(@PathVariable Long id) {
        log.info("Deleting supplier with id: " + id);

        supplierRepository.deleteById(id);
    }
}