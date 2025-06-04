package lk.ijse.cmjd109.LostandFoundSystem.entities;

import jakarta.persistence.*;
import lk.ijse.cmjd109.LostandFoundSystem.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Item")
public class ItemEntity {
    @Id
    private String id;

    private String name;

    private String description;

    private String date;

    private String time;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ItemStatus itemStatus; // LOST, FOUND, CLAIMED
}
