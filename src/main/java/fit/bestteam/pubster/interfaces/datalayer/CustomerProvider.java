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
 *
 * @author illia
 */
@Local
public interface CustomerProvider {
    
    public boolean checkIdentificator(String identificator);
    
    public List<Customer> getAll();
    public Customer getByID(int id);
    public Customer getByIdentificator(String identificator);
    public void placeCustomer(Customer customer);
    
    
}
