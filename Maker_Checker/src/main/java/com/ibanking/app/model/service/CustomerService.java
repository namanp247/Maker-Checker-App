package com.ibanking.app.model.service;

import com.ibanking.app.model.dao.entities.*;
import com.ibanking.app.model.formbean.CustomerFormBean;

import java.util.List;

public interface CustomerService {
    List<CustomerSlaveDTO> getAllCustomerFromSlave();
    List<CustomerMasterDTO> getAllCustomerFromMaster();

    CustomerMasterDTO convertFormBeanToCustomerMaster(CustomerFormBean customerFormBean);
    CustomerSlaveDTO convertFormBeanToCustomerSlave(CustomerFormBean customerFormBean);
    public CustomerSlaveDTO convertMasterToSlave(CustomerMasterDTO customerMasterDTO);
    public CustomerMasterDTO convertSlaveToMaster(CustomerSlaveDTO customerSlaveDTO);
    public CustomerFormBean convertMasterToFormBean(CustomerMasterDTO customerMasterDTO);
    public CustomerFormBean convertSlaveToFormBean(CustomerSlaveDTO customerSlaveDTO);

    void saveCustomerToSlave(CustomerSlaveDTO customerSlaveDTO);
    CustomerSlaveDTO getCustomerFromSlaveById(String code);
    void saveCustomerToMaster(CustomerMasterDTO customerMasterDTO);
    void deleteFromSlaveTable(CustomerSlaveDTO customerSlaveDTO);
    void updateSlaveRecord(CustomerSlaveDTO slaveDTO);
    CustomerMasterDTO getCustomerFromMasterByCode(String code);
    void deleteFromMasterTable(CustomerMasterDTO masterDTO);
    void updateCustomerInMaster(CustomerMasterDTO customerMasterDTO);

}
