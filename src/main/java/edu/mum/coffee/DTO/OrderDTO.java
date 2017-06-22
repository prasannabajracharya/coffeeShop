package edu.mum.coffee.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by prasannabajracharya on 6/21/17.
 */
public class OrderDTO {

    private Date orderDate;

    private long personId;

    private List<OrderLineDTO> orderLinesDTO = new ArrayList<OrderLineDTO>();

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public List<OrderLineDTO> getOrderLinesDTO() {
        return orderLinesDTO;
    }

    public void setOrderLinesDTO(List<OrderLineDTO> orderLinesDTO) {
        this.orderLinesDTO = orderLinesDTO;
    }
}
