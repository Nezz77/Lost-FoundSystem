package lk.ijse.cmjd109.LostandFoundSystem.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Request")
public class RequestEntity {
    @Id
    private String requestId;

    private String userId;

    private String itemId;

    @Column(nullable = false)
    private String status; // PENDING, APPROVED, REJECTED

    private LocalDate requesteddate;

    private LocalTime requestedtime;
}
