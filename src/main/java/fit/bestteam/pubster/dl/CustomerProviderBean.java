/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.dl;

import fit.bestteam.pubster.dl.entity.Customer;
import fit.bestteam.pubster.dl.service.CustomerFacade;
import fit.bestteam.pubster.interfaces.dl.CustomerProvider;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
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

    @Override
    public Customer getByIdentificator(String identificator) {
        return m_Customers.getByIdentificator(identificator);
    }

    @Override
    public boolean checkIdentificator(String identificator) {
        return m_Customers.checkIdentificator(identificator);
    }

    @Override
    public void placeCustomer(Customer customer) {
        m_Customers.create(customer);
    }

}
