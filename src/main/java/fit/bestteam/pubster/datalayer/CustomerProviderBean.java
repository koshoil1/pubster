/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.datalayer;

import fit.bestteam.pubster.datalayer.entity.Customer;
import fit.bestteam.pubster.datalayer.service.CustomerFacade;
import fit.bestteam.pubster.interfaces.datalayer.CustomerProvider;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * CustomerProvider implementation
 * Local Stateless Bean to provide access to Customer objects
 * @author illia
 */
@Stateless
public class CustomerProviderBean implements CustomerProvider{

    @EJB
    CustomerFacade m_Customers;
    
    @Override
    public List<Customer> getAll() {
        return m_Customers.findAll();
    }

    @Override
    public Customer getByID(int id) {
        return m_Customers.find(id);
    }

    /**
     * Search for Customer, which can be Identified by identificator 
     * (email/login/phone number)
     * @param identificator
     * @return found Customer or null
     */
    @Override
    public Customer getByIdentificator(String identificator) {
        return m_Customers.getByIdentificator(identificator);
    }

    /**
     * Check, if passed Identificator is unique
     * @param identificator
     * @return true if unique
     */
    @Override
    public boolean checkIdentificator(String identificator) {
        return m_Customers.checkIdentificator(identificator);
    }

    @Override
    public void placeCustomer(Customer customer) {
        m_Customers.create(customer);
    }

}
