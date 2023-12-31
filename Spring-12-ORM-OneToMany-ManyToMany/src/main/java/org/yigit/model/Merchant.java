package org.yigit.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "merchants")
@Data
@NoArgsConstructor
public class Merchant extends BaseEntity{

    private String name;
    private String code;
    private BigDecimal transactionFee;
    private BigDecimal  commissionRate;
    private Integer payoutDelayCount;

    //Doesn't create merchantId but connects with Payment table which wil have many data
    @OneToMany(mappedBy = "merchant", fetch = FetchType.LAZY)
    private List<Payment> paymentList;

    public Merchant(String name, String code, BigDecimal transactionFee, BigDecimal commissionRate, Integer payoutDelayCount) {
        this.name = name;
        this.code = code;
        this.transactionFee = transactionFee;
        this.commissionRate = commissionRate;
        this.payoutDelayCount = payoutDelayCount;
    }
}
