package com.ibanking.app.controller;

import com.ibanking.app.model.dao.entities.CustomerSlaveDTO;
import com.ibanking.app.model.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class CheckerController {

    private final CustomerService customerService;

    @Autowired
    public CheckerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("checker")
    public String checkerView(ModelMap modelMap){
        modelMap.addAttribute("customerListFromSlave",customerService.getAllCustomerFromSlave());
        return "checkerview";
    }

    @GetMapping("authorizeCustomer")
    public String authorize(@RequestParam(name = "auId") String auId,
                            @RequestParam(name = "recStatus") String recStatus,
                            Principal principal){
        CustomerSlaveDTO customerSlaveDTO = customerService.getCustomerFromSlaveById(auId);
        customerSlaveDTO.setAuthorizedBy(principal.getName());
        customerSlaveDTO.setAuthorizedDate(String.valueOf(LocalDateTime.now()));
        customerSlaveDTO.setRecordStatus("A");
        if (recStatus.equals("N") || recStatus.equals("NM")) {
            customerService.saveCustomerToMaster(customerService.convertSlaveToMaster(customerSlaveDTO));
            customerService.deleteFromSlaveTable(customerSlaveDTO);
        } else if (recStatus.equals("D")) {
            customerService.deleteFromSlaveTable(customerSlaveDTO);
            customerService.deleteFromMasterTable(customerService.convertSlaveToMaster(customerSlaveDTO));
        } else if (recStatus.equals("M")) {
            customerService.updateCustomerInMaster(customerService.convertSlaveToMaster(customerSlaveDTO));
            customerService.deleteFromSlaveTable(customerSlaveDTO);
        }
        return "redirect:checker";
    }

    @GetMapping("rejectCustomer")
    public String reject(@RequestParam(name = "rejId") String rejId,
                            @RequestParam(name = "recStatus") String recStatus,
                            Principal principal){
        CustomerSlaveDTO customerSlaveDTO = customerService.getCustomerFromSlaveById(rejId);
        customerSlaveDTO.setAuthorizedBy(principal.getName());
        customerSlaveDTO.setAuthorizedDate(String.valueOf(LocalDateTime.now()));

        if (recStatus.equals("N")) {
            customerSlaveDTO.setRecordStatus("NR");
            customerService.updateSlaveRecord(customerSlaveDTO);
        } else if (recStatus.equals("M")) {
            customerSlaveDTO.setRecordStatus("MR");
            customerService.updateSlaveRecord(customerSlaveDTO);
        } else if (recStatus.equals("D")) {
            customerSlaveDTO.setRecordStatus("DR");
            customerService.updateSlaveRecord(customerSlaveDTO);
        }
        return "redirect:checker";
    }

}
