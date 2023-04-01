package com.ibanking.app.model.dao;

import com.ibanking.app.model.dao.entities.CustomerMasterDTO;
import com.ibanking.app.model.dao.entities.CustomerSlaveDTO;
import com.ibanking.app.model.formbean.CustomerFormBean;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{

    private final SessionFactory sessionFactory;

    public CustomerDaoImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<CustomerSlaveDTO> getAllCustomerFromSlave() {
        return getSession().createQuery("select c from CustomerSlaveDTO c").getResultList();
    }

    @Override
    public List<CustomerMasterDTO> getAllCustomerFromMaster() {
        return getSession().createQuery("select c from CustomerMasterDTO c").getResultList();
    }

    @Override
    public CustomerMasterDTO convertFormBeanToCustomerMaster(CustomerFormBean customerFormBean){

        CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO(customerFormBean.getCustomerCode(),
                                            customerFormBean.getCustomerName(),customerFormBean.getAddress1(),
                                            customerFormBean.getAddress2(),customerFormBean.getPinCode(),
                                            customerFormBean.getEmail(),customerFormBean.getContactNumber(),
                                            customerFormBean.getPrimaryContactPerson(),
                                            customerFormBean.getActiveInactive());
        customerMasterDTO.setCreateDate(String.valueOf(LocalDateTime.now()));
        customerMasterDTO.setRecordStatus("N");

        return customerMasterDTO;
    }

    @Override
    public CustomerSlaveDTO convertFormBeanToCustomerSlave(CustomerFormBean customerFormBean){

        CustomerSlaveDTO customerSlaveDTO = new CustomerSlaveDTO(customerFormBean.getCustomerCode(),
                customerFormBean.getCustomerName(),customerFormBean.getAddress1(),
                customerFormBean.getAddress2(),customerFormBean.getPinCode(),
                customerFormBean.getEmail(),customerFormBean.getContactNumber(),
                customerFormBean.getPrimaryContactPerson(),
                customerFormBean.getActiveInactive());


        return customerSlaveDTO;
    }

    @Override
    public CustomerMasterDTO convertSlaveToMaster(CustomerSlaveDTO customerSlaveDTO){
        CustomerMasterDTO customerMasterDTO = new CustomerMasterDTO();

        customerMasterDTO.setId(customerSlaveDTO.getId());
        customerMasterDTO.setCustomerCode(customerSlaveDTO.getCustomerCode());
        customerMasterDTO.setCustomerName(customerSlaveDTO.getCustomerName());
        customerMasterDTO.setAddress1(customerSlaveDTO.getAddress1());
        customerMasterDTO.setAddress2(customerSlaveDTO.getAddress2());
        customerMasterDTO.setPinCode(customerSlaveDTO.getPinCode());
        customerMasterDTO.setEmail(customerSlaveDTO.getEmail());
        customerMasterDTO.setContactNumber(customerSlaveDTO.getContactNumber());

        customerMasterDTO.setPrimaryContactPerson(customerSlaveDTO.getPrimaryContactPerson());
        customerMasterDTO.setRecordStatus(customerSlaveDTO.getRecordStatus());
        customerMasterDTO.setActiveInactive(customerSlaveDTO.getActiveInactive());


        customerMasterDTO.setCreatedBy(customerSlaveDTO.getCreatedBy());
        customerMasterDTO.setCreateDate(customerSlaveDTO.getCreateDate());
        customerMasterDTO.setModifiedBy(customerSlaveDTO.getModifiedBy());
        customerMasterDTO.setModifiedDate(customerSlaveDTO.getModifiedDate());
        customerMasterDTO.setAuthorizedBy(customerSlaveDTO.getAuthorizedBy());
        customerMasterDTO.setAuthorizedDate(customerSlaveDTO.getAuthorizedDate());

        return customerMasterDTO;
    }

    @Override
    public CustomerSlaveDTO convertMasterToSlave(CustomerMasterDTO customerMasterDTO){
        CustomerSlaveDTO customerSlaveDTO = new CustomerSlaveDTO();

        customerSlaveDTO.setId(customerMasterDTO.getId());
        customerSlaveDTO.setCustomerCode(customerMasterDTO.getCustomerCode());
        customerSlaveDTO.setCustomerName(customerMasterDTO.getCustomerName());
        customerSlaveDTO.setAddress1(customerMasterDTO.getAddress1());
        customerSlaveDTO.setAddress2(customerMasterDTO.getAddress2());
        customerSlaveDTO.setPinCode(customerMasterDTO.getPinCode());
        customerSlaveDTO.setEmail(customerMasterDTO.getEmail());
        customerSlaveDTO.setContactNumber(customerMasterDTO.getContactNumber());

        customerSlaveDTO.setPrimaryContactPerson(customerMasterDTO.getPrimaryContactPerson());
        customerSlaveDTO.setRecordStatus(customerMasterDTO.getRecordStatus());
        customerSlaveDTO.setActiveInactive(customerMasterDTO.getActiveInactive());


        customerSlaveDTO.setCreatedBy(customerMasterDTO.getCreatedBy());
        customerSlaveDTO.setCreateDate(customerMasterDTO.getCreateDate());
        customerSlaveDTO.setModifiedBy(customerMasterDTO.getModifiedBy());
        customerSlaveDTO.setModifiedDate(customerMasterDTO.getModifiedDate());
        customerSlaveDTO.setAuthorizedBy(customerMasterDTO.getAuthorizedBy());
        customerSlaveDTO.setAuthorizedDate(customerMasterDTO.getAuthorizedDate());

        return customerSlaveDTO;
    }

    @Override
    public CustomerFormBean convertMasterToFormBean(CustomerMasterDTO customerMasterDTO) {
        CustomerFormBean customerFormBean = new CustomerFormBean(customerMasterDTO.getCustomerCode(),
                customerMasterDTO.getCustomerName(),customerMasterDTO.getAddress1(),
                customerMasterDTO.getAddress2(), customerMasterDTO.getPinCode(),
                customerMasterDTO.getEmail(),customerMasterDTO.getContactNumber(),
                customerMasterDTO.getPrimaryContactPerson(),customerMasterDTO.getRecordStatus(),
                customerMasterDTO.getActiveInactive());
        return customerFormBean;
    }

    @Override
    public CustomerFormBean convertSlaveToFormBean(CustomerSlaveDTO customerSlaveDTO) {
        CustomerFormBean customerFormBean = new CustomerFormBean(customerSlaveDTO.getCustomerCode(),
                customerSlaveDTO.getCustomerName(),customerSlaveDTO.getAddress1(),
                customerSlaveDTO.getAddress2(), customerSlaveDTO.getPinCode(),
                customerSlaveDTO.getEmail(),customerSlaveDTO.getContactNumber(),
                customerSlaveDTO.getPrimaryContactPerson(),customerSlaveDTO.getRecordStatus(),
                customerSlaveDTO.getActiveInactive());
        return customerFormBean;
    }

    @Override
    public CustomerSlaveDTO getCustomerFromSlaveById(String code){
        Integer id = Integer.valueOf(code);
        return (CustomerSlaveDTO) getSession()
                .createQuery("from CustomerSlaveDTO where id = :id")
                .setParameter("id",id).uniqueResult();
    }

    @Override
    public CustomerMasterDTO getCustomerFromMasterByCode(String code){
        return (CustomerMasterDTO) getSession()
                .createQuery("from CustomerMasterDTO where customerCode = :customerCode")
                .setParameter("customerCode",code).uniqueResult();
    }

    @Override
    public void saveCustomerToSlave(CustomerSlaveDTO customerSlaveDTO){
        getSession().save(customerSlaveDTO);
    }



    @Override
    public void saveCustomerToMaster(CustomerMasterDTO customerMasterDTO) {
        getSession().save(customerMasterDTO);
    }

    @Override
    public void deleteFromSlaveTable(CustomerSlaveDTO customerSlaveDTO){
        getSession().createQuery("delete from CustomerSlaveDTO where customerCode = :customerCode")
                .setParameter("customerCode",customerSlaveDTO.getCustomerCode()).executeUpdate();
    }

    @Override
    public void deleteFromMasterTable(CustomerMasterDTO masterDTO){
        getSession().remove(masterDTO);
    }

    @Override
    public void updateSlaveRecord(CustomerSlaveDTO slaveDTO){
        getSession().update(slaveDTO);
    }

    @Override
    public void updateCustomerInMaster(CustomerMasterDTO customerMasterDTO){
        getSession().update(customerMasterDTO);
    }



}
