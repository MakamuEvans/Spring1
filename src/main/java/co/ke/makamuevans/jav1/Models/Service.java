package co.ke.makamuevans.jav1.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "services")
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT default null")
    private String description;

    @Column(columnDefinition = "tinyint(1) default 1")
    private Boolean status;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(columnDefinition = "DATETIME(0)")
    private Date dated;

    private Long created_by;

    private BigInteger count;

    private BigInteger upper_deck;

    private BigInteger lower_deck;

    @CreationTimestamp
    private Date created_at;

    @UpdateTimestamp
    private Date updated_at;

    public String getFormattedStatus(){
        if (this.getStatus() != null && this.getStatus() == true)
            return "active";
        return "inactive";
    }
}
