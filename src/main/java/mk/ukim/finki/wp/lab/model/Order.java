package mk.ukim.finki.wp.lab.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Duration;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class Order {
    private String pizzaType;
    private String clientName;
    private String clientAddress;
    private String pizzaSize;
    private Long orderId;
    private LocalDateTime timeOrdered;

    public Order(String pizzaType, String clientName, String clientAddress, Long orderId, String pizzaSize) {
        this.pizzaType = pizzaType;
        this.clientName = clientName;
        this.clientAddress = clientAddress;
        this.orderId = orderId;
        timeOrdered= LocalDateTime.now().plusMinutes(25);
        this.pizzaSize=pizzaSize;
    }

    public String timeRemaining(){
        LocalDateTime now = LocalDateTime.now();
        Duration period = Duration.between(now,timeOrdered);

        String TimeFormated = period.toString();

        String time[]=TimeFormated.split("M");
        String minutes = time[0].substring(2);
        String seconds = time[1].substring(0, 2);
        return minutes+":"+seconds;
    }
}
