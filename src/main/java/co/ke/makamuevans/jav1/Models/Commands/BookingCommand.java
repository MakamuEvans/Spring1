package co.ke.makamuevans.jav1.Models.Commands;

import lombok.*;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingCommand {
    @NotNull(message = "You must select a Service!")
    private Long service_id;

    @NotEmpty(message = "You need at-least one Attendee!")
    private List<AttendeeCommand> attendees = new ArrayList<>();

    public AttendeeCommand addAttendee(){
        AttendeeCommand attendeeAction = new AttendeeCommand();
        attendees.add(attendeeAction);
        return attendeeAction;
    }
}
