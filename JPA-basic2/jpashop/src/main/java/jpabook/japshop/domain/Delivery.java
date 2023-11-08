package jpabook.japshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(mappedBy = "delivery")
    private Order order;
    private String city;
    private String street;
    private String zipCode;
    private DeliveryStatus deliveryStatus;
}
