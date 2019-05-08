/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.bl;

import fit.bestteam.pubster.dl.entity.Board;
import fit.bestteam.pubster.dl.entity.Boardreservation;
import fit.bestteam.pubster.dl.entity.Customer;
import fit.bestteam.pubster.dl.entity.Reservation;
import fit.bestteam.pubster.interfaces.bl.CustomerService;
import fit.bestteam.pubster.interfaces.dl.CustomerProvider;
import fit.bestteam.pubster.interfaces.dl.ReservationProvider;
import fit.bestteam.pubster.pl.JSONobject.common.reservation.JSONReservation;
import fit.bestteam.pubster.pl.JSONobject.common.reservation.JSONTableReservation;
import fit.bestteam.pubster.pl.JSONobject.requestData.JSONDoReservationData;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONDoReservationResult;
import fit.bestteam.pubster.pl.JSONobject.responseResult.JSONGetActualReservationsResult;
import fit.bestteam.pubster.pl.rpcserver.JsonRpcContext;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author illia
 */
@Stateless
public class CustomerServiceBean implements CustomerService{

    @EJB
    ReservationProvider m_ReservationProvider;
    @EJB
    CustomerProvider m_CustomerProvider;
    
    private Reservation prepareFromJSON(JSONReservation data){
        Customer v_Customer = m_CustomerProvider.getByIdentificator(JsonRpcContext.get(0, String.class));
        Reservation v_res = new Reservation();
        v_res.setCustomerid(v_Customer);
        v_res.setComment(data.getComment());
        v_res.setCreationdate(new Date());
        v_res.setDurationmin(data.getDuration());
        v_res.setSince(new Date(data.getSince()));
        v_res.setState(0);
        
        List<Boardreservation> v_boards = new LinkedList<>();
        for (JSONTableReservation jsonRes : data.getTables()) {
            Boardreservation v_board = new Boardreservation();
            v_board.setNumberofseats(jsonRes.getSeats());
            v_board.setTableid(new Board(jsonRes.getTableID()));
        }
        
        v_res.setBoardreservationList(v_boards);
        return v_res;
    }
    
    @Override
    public JSONDoReservationResult DoReservation(JSONDoReservationData data) {
        JSONReservation v_res = new JSONReservation();
        
        m_ReservationProvider.placeReservation(prepareFromJSON(data.getReservation()));
        
        return new JSONDoReservationResult(v_res);
    }

    @Override
    public JSONGetActualReservationsResult GetActualReservations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
