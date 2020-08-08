package co.ke.makamuevans.jav1.Models;

import lombok.*;

import javax.annotation.Nullable;
import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "bookings")
public class Booking extends BaseEntity{

    @ManyToOne
    @JoinColumn(name = "service_id")
    @NonNull
    private Service service;

    @Column(nullable = false)
    @NonNull
    private String phone;

    @Column(nullable = false)
    @NonNull
    private String request_id;

    @Column(nullable = false)
    @NonNull
    private String names;

    private Integer seat;

    @Column(columnDefinition = "int(10) default 0 NOT NULL")
    private Integer status = 0;

    @Column(columnDefinition = "tinyint(1) default 0 NOT NULL")
    private Boolean attended = false;
}
