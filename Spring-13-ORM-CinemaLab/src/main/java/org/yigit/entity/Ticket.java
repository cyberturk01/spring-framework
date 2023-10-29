package org.yigit.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tickets")
@Data
@NoArgsConstructor
public class Ticket extends BaseEntity{
    private LocalDate dateTime;
    private Integer seatNumber;
    private Integer rowNumber;

    public Ticket(LocalDate dateTime, Integer seatNumber, Integer rowNumber) {
        this.dateTime = dateTime;
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
    }
}
