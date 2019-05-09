/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster;

import fit.bestteam.pubster.bl.Hasher;
import fit.bestteam.pubster.dl.entity.Customer;
import fit.bestteam.pubster.interfaces.dl.CustomerProvider;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import static java.util.Arrays.asList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;

/**
 *
 * @author illia
 */
@ApplicationScoped
public class PubsterIdentityStore implements IdentityStore{
    
    @EJB
    CustomerProvider m_CustomerProvider;
    
    public CredentialValidationResult validate(UsernamePasswordCredential usernamePasswordCredential) {
        
        try {
            String caller = usernamePasswordCredential.getCaller();
            String pwd = usernamePasswordCredential.getPasswordAsString();
            
            Customer v_cust = m_CustomerProvider.getByIdentificator(caller);
            
            // just for the exercise, assign the role based on the user name
            String role = "customer";
            
            
            if (Hasher.validatePassword(pwd, v_cust.getPassword())) {
                // return a VALID result with the caller and the set of groups s/he belongs to.
                return new CredentialValidationResult(caller, new HashSet<>(asList(role)));
            }
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            Logger.getLogger(PubsterIdentityStore.class.getName()).log(Level.SEVERE, null, ex);
        }
        return CredentialValidationResult.INVALID_RESULT;
 }
    
}
