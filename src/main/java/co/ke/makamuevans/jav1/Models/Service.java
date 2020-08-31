package co.ke.makamuevans.jav1.Models;

import co.ke.makamuevans.jav1.utilities.Helpers.Formatters.Formatter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "services")
public class Service extends BaseEntity{

    @NotBlank(message = "Title cannot be blank!")
    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT default null")
    private String description;

    @Column(columnDefinition = "tinyint(1) default 1 NOT NULL")
    private Boolean status = true;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(columnDefinition = "DATETIME(0)")
    @NotNull(message = "Service Date cannot be blank!")
    private LocalDateTime dated;

    @OneToMany
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private List<Booking> bookings;

    private Long created_by;

    private BigInteger count;

    @Column(columnDefinition = "int(10)")
    private BigInteger upper_deck;

    @Column(columnDefinition = "int(10)")
    private BigInteger lower_deck;


    public String getFormattedStatus(){
        if (this.getStatus() != null && this.getStatus() == true)
            return "active";
        return "inactive";
    }

    public String appendDated(){
        return Formatter.formatDateOne(this.getDated());
    }
}
