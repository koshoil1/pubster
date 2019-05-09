/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit.bestteam.pubster.businesslayer;

import fit.bestteam.pubster.datalayer.entity.Board;
import fit.bestteam.pubster.datalayer.entity.Boardreservation;
import fit.bestteam.pubster.datalayer.entity.Customer;
import fit.bestteam.pubster.datalayer.entity.Reservation;
import fit.bestteam.pubster.interfaces.businesslayer.CustomerService;
import fit.bestteam.pubster.interfaces.datalayer.CustomerProvider;
import fit.bestteam.pubster.interfaces.datalayer.ReservationProvider;
import fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation.JSONReservation;
import fit.bestteam.pubster.presentationlayer.JSONobject.common.reservation.JSONTableReservation;
import fit.bestteam.pubster.presentationlayer.JSONobject.requestData.JSONDoReservationData;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONDoReservationResult;
import fit.bestteam.pubster.presentationlayer.JSONobject.responseResult.JSONGetActualReservationsResult;
import fit.bestteam.pubster.presentationlayer.rpcserver.JsonRpcContext;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * CustomerService implementation
 * Local, Stateless Bean to provide realization of API methods
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
        v_res.setState(JSONReservation.ACCEPTED);
        
        List<Boardreservation> v_boards = new LinkedList<>();
        for (JSONTableReservation jsonRes : data.getTables()) {
            Boardreservation v_board = new Boardreservation();
            v_board.setNumberofseats(jsonRes.getSeats());
            v_board.setTableid(new Board(jsonRes.getTableID()));
        }
        
        v_res.setBoardreservationList(v_boards);
        return v_res;
    }
    
    private JSONReservation parseToJSON(Reservation reservation) {
        JSONReservation v_res = new JSONReservation();
        
        v_res.setComment(reservation.getComment());
        v_res.setCreated(reservation.getCreationdate().getTime());
        v_res.setDuration(reservation.getDurationmin());
        v_res.setId(reservation.getReservationid());
        v_res.setSince(reservation.getSince().getTime());
        v_res.setState(reservation.getState());
        List<JSONTableReservation> v_tables = new LinkedList<>();
        for (Boardreservation br: reservation.getBoardreservationList()) {
            v_tables.add(new JSONTableReservation(br.getTablereservationid(),
                    br.getTableid().getBoardid(), br.getNumberofseats()));
        }
        v_res.setTables(v_tables);
        
        return v_res;
    }
    
    /**
     * JSON-RPC Method DoReservation
     * @param data parsed from request
     * @return JSONDoReservationResult - jackson compatible API result
     */
    @Override
    public JSONDoReservationResult DoReservation(JSONDoReservationData data) {
        Reservation v_reservation = 
                m_ReservationProvider.placeReservation(prepareFromJSON(data.getReservation()));
        
        return new JSONDoReservationResult(parseToJSON(v_reservation));
    }

    /**
     * JSON-RPC Method GetActualReservations
     * @return JSONGetActualReservationsResult - jackson compatible API result
     */
    @Override
    public JSONGetActualReservationsResult GetActualReservations() {
        List<JSONReservation> v_res = new LinkedList<>();
        
        Customer v_cust = m_CustomerProvider.getByIdentificator(JsonRpcContext.get(0, String.class));
        
        for (Reservation reserv: v_cust.getReservationList()) {
            v_res.add(parseToJSON(reserv));
        }
        
        return new JSONGetActualReservationsResult(v_res);
    }

}
