package co.ke.makamuevans.jav1.Models.Commands;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookingAction {
    private Long service_id;
    private List<AttendeeAction> attendees = new ArrayList<>();

    public AttendeeAction addAttendee(){
        AttendeeAction attendeeAction = new AttendeeAction();
        attendees.add(attendeeAction);
        return attendeeAction;
    }
}
