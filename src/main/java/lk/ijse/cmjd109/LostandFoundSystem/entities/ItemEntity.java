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
@Table(name = "Item")
public class ItemEntity {
    @Id
    private String id;

    private String name;

    private String description;

    private String date;

    private String time;

    @Column(nullable = false)
    private String status; // LOST, FOUND, CLAIMED
}
