package com.ibanking.app.controller;

import com.ibanking.app.model.dao.entities.*;
import com.ibanking.app.model.formbean.CustomerFormBean;
import com.ibanking.app.model.service.CustomerService;
import com.ibanking.app.model.service.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class MakerController {

    private CustomerService customerService;

    @Autowired
    public MakerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String toLoginPage(){
        return "index";
    }


    @GetMapping("maker")
    public String makerView(ModelMap modelMap){

//        modelMap creates a user instance
        modelMap.addAttribute("customerListFromMaster",customerService.getAllCustomerFromMaster());
        modelMap.addAttribute("customerListFromSlave",customerService.getAllCustomerFromSlave());
        return "makerview";
    }

    @GetMapping("addCustomer")
    public String forwardToAddCustomer(ModelMap modelMap){
        CustomerFormBean customerFormBean = new CustomerFormBean();
        modelMap.addAttribute("customerFormBean", customerFormBean);
        return "addCustomer";
    }

//  @Valid to check whether the data inputted is valid or not, if not valid then binding result works as a catcher and redirect the request to the same page.
//  Principal stores info related to the current session user.
//  Model attribute checks whether the name passed below is same as modelAttribute value from the form.
    @PostMapping("addNew")
    public String addNewToSlave(@Valid @ModelAttribute(name  = "customerFormBean")CustomerFormBean customerFormBean,
                                BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "addCustomer";
        }

        CustomerSlaveDTO customerSlaveDTO = customerService.convertFormBeanToCustomerSlave(customerFormBean);
        customerSlaveDTO.setCreatedBy(principal.getName());
        customerSlaveDTO.setCreateDate(String.valueOf(LocalDateTime.now()));
        customerSlaveDTO.setRecordStatus("N");
        customerService.saveCustomerToSlave(customerSlaveDTO);
        return "redirect:maker";
    }

    @GetMapping("updateThis")
    public String updateCustomerFromSlave(ModelMap modelMap,@RequestParam(name = "upid")String code,
                                          @RequestParam(name = "recStatus") String recStatus){
        CustomerSlaveDTO customerSlaveDTO = customerService.getCustomerFromSlaveById(code);
        CustomerFormBean customerFormBean = customerService.convertSlaveToFormBean(customerSlaveDTO);
        customerFormBean.setId(customerSlaveDTO.getId());
        modelMap.addAttribute("customerFormBean",customerFormBean);
        modelMap.addAttribute("masterSlave","slave");
        modelMap.addAttribute("recStatus",recStatus);
        return "updateCustomer";
    }

    @PostMapping("update")
    public String updateSlaveRecord(@ModelAttribute(name = "customerFormBean") CustomerFormBean customerFormBean,
                                    BindingResult bindingResult, Principal principal,
                                    @RequestParam(name = "masterSlave") String masterSlave,
                                    @RequestParam(name = "recStatus") String recStatus){
        if(bindingResult.hasErrors()){
            return "updateCustomer";
        }
        CustomerSlaveDTO customerSlaveDTO = customerService.convertFormBeanToCustomerSlave(customerFormBean);
        customerSlaveDTO.setModifiedBy(principal.getName());
        customerSlaveDTO.setModifiedDate(String.valueOf(LocalDateTime.now()));
        customerSlaveDTO.setId(customerFormBean.getId());
        if (masterSlave.equals("slave")){
            if (recStatus.equals("M") || recStatus.equals("MR") || recStatus.equals("D") || recStatus.equals("DR")){
                customerSlaveDTO.setRecordStatus("M");
                customerService.updateSlaveRecord(customerSlaveDTO);
            } else if (recStatus.equals("N") || recStatus.equals("NM") || recStatus.equals("NR")){
                customerSlaveDTO.setRecordStatus("NM");
                customerService.updateSlaveRecord(customerSlaveDTO);
            }
        }else if(masterSlave.equals("master")){
            customerSlaveDTO.setRecordStatus("M");
            customerService.saveCustomerToSlave(customerSlaveDTO);
        }
        return "redirect:maker";
    }

    @GetMapping("deleteThis")
    public String deleteSlaveRecord(@RequestParam(name = "delid")Integer id){
        String code = String.valueOf(id);
        CustomerSlaveDTO customerSlaveDTO = customerService.getCustomerFromSlaveById(code);
        customerService.deleteFromSlaveTable(customerSlaveDTO);
        return "redirect:maker";
    }

    @GetMapping("updateMaster")
    public String updateMasterRecord(ModelMap modelMap,@RequestParam(name = "upid") String code){
        CustomerMasterDTO customerMasterDTO = customerService.getCustomerFromMasterByCode(code);
        CustomerFormBean customerFormBean = customerService.convertMasterToFormBean(customerMasterDTO);
        customerFormBean.setId(customerMasterDTO.getId());
        modelMap.addAttribute("customerFormBean",customerFormBean);
        modelMap.addAttribute("masterSlave","master");
        return "updateCustomer";
    }

    @GetMapping("deleteMaster")
    public String deleteMasterRecord(@RequestParam(name = "delid") String code,Principal principal){
        CustomerMasterDTO customerMasterDTO = customerService.getCustomerFromMasterByCode(code);
        customerMasterDTO.setModifiedBy(principal.getName());
        customerMasterDTO.setModifiedDate(String.valueOf(LocalDateTime.now()));
        customerMasterDTO.setRecordStatus("D");
        customerService.saveCustomerToSlave(customerService.convertMasterToSlave(customerMasterDTO));

        return "redirect:maker";
    }


}
