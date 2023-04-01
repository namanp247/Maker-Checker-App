package com.ibanking.app.model.dao;

import com.ibanking.app.model.dao.entities.*;
import com.ibanking.app.model.formbean.CustomerFormBean;

import java.util.List;

public interface CustomerDao {
    List<CustomerSlaveDTO> getAllCustomerFromSlave();
    List<CustomerMasterDTO> getAllCustomerFromMaster();

    CustomerMasterDTO convertFormBeanToCustomerMaster(CustomerFormBean customerFormBean);
    CustomerSlaveDTO convertFormBeanToCustomerSlave(CustomerFormBean customerFormBean);
    CustomerMasterDTO convertSlaveToMaster(CustomerSlaveDTO customerSlaveDTO);
    public CustomerSlaveDTO convertMasterToSlave(CustomerMasterDTO customerMasterDTO);
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
