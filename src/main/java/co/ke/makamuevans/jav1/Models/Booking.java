package co.ke.makamuevans.jav1.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "bookings")
public class Booking extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String request_id;

    @Column(nullable = false)
    private String names;

    private Integer seat;

    private Integer status;

    @Column(columnDefinition = "tinyint(1) default 0")
    private Boolean attended;
}
