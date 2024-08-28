package com.abhinav.E_CommerceProject.Model;

import com.abhinav.E_CommerceProject.Enum.PaymentStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Order order;

    private PaymentStatus paymentstatus;
}
