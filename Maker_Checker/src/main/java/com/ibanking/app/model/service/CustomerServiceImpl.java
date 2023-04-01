package com.ibanking.app.model.service;

import com.ibanking.app.model.dao.CustomerDao;
import com.ibanking.app.model.dao.entities.*;
import com.ibanking.app.model.formbean.CustomerFormBean;
import com.ibanking.app.model.service.annotation.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;

    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao){
        this.customerDao=customerDao;
    }


    @Log
    @Override
    public List<CustomerSlaveDTO> getAllCustomerFromSlave() {
        return customerDao.getAllCustomerFromSlave();
    }

    @Log
    @Override
    public List<CustomerMasterDTO> getAllCustomerFromMaster() {
        return customerDao.getAllCustomerFromMaster();
    }

    @Override
    public CustomerMasterDTO convertFormBeanToCustomerMaster(CustomerFormBean customerFormBean){
        return customerDao.convertFormBeanToCustomerMaster(customerFormBean);
    }

    @Override
    public CustomerSlaveDTO convertFormBeanToCustomerSlave(CustomerFormBean customerFormBean){
        return customerDao.convertFormBeanToCustomerSlave(customerFormBean);
    }
    @Override
    public void saveCustomerToSlave(CustomerSlaveDTO customerSlaveDTO){
        customerDao.saveCustomerToSlave(customerSlaveDTO);
    }
    @Override
    public CustomerSlaveDTO getCustomerFromSlaveById(String code){
        return customerDao.getCustomerFromSlaveById(code);
    }

    @Override
    public void saveCustomerToMaster(CustomerMasterDTO customerMasterDTO) {
        customerDao.saveCustomerToMaster(customerMasterDTO);
    }

    @Override
    public CustomerMasterDTO convertSlaveToMaster(CustomerSlaveDTO customerSlaveDTO) {
        return customerDao.convertSlaveToMaster(customerSlaveDTO);
    }

    @Override
    public CustomerSlaveDTO convertMasterToSlave(CustomerMasterDTO customerMasterDTO) {
        return customerDao.convertMasterToSlave(customerMasterDTO);
    }

    @Override
    public void deleteFromSlaveTable(CustomerSlaveDTO customerSlaveDTO){
        customerDao.deleteFromSlaveTable(customerSlaveDTO);
    }

    @Override
    public CustomerFormBean convertMasterToFormBean(CustomerMasterDTO customerMasterDTO) {
        return customerDao.convertMasterToFormBean(customerMasterDTO);
    }

    @Override
    public CustomerFormBean convertSlaveToFormBean(CustomerSlaveDTO customerSlaveDTO) {
        return customerDao.convertSlaveToFormBean(customerSlaveDTO);
    }
    @Override
    public void updateSlaveRecord(CustomerSlaveDTO slaveDTO){
        customerDao.updateSlaveRecord(slaveDTO);
    }

    @Override
    public CustomerMasterDTO getCustomerFromMasterByCode(String code){
        return customerDao.getCustomerFromMasterByCode(code);
    }

    @Override
    public void deleteFromMasterTable(CustomerMasterDTO masterDTO){
        customerDao.deleteFromMasterTable(masterDTO);
    }
    @Override
    public void updateCustomerInMaster(CustomerMasterDTO customerMasterDTO){
        customerDao.updateCustomerInMaster(customerMasterDTO);
    }

}
