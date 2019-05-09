/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.interfaces.datalayer;

import fit.bestteam.pubster.datalayer.entity.Customer;
import java.util.List;
import javax.ejb.Local;

/**
 * Interface for Beans, declares necessary methods for accessing Customer objects
 * @author illia
 */
@Local
public interface CustomerProvider {
    
    /**
     * Check, if passed Identificator is unique
     * @param identificator
     * @return true if unique
     */
    public boolean checkIdentificator(String identificator);
    
    public List<Customer> getAll();

    public Customer getByID(int id);

    /**
     * Search for Customer, which can be Identified by identificator 
     * (email/login/phone number)
     * @param identificator
     * @return found Customer or null
     */
    public Customer getByIdentificator(String identificator);

    public void placeCustomer(Customer customer);
    
    
}
