package lk.ijse.cmjd109.LostandFoundSystem.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ItemDTO implements Serializable {
    private String id;
    private String name;
    private String description;
    private String date;
    private String time;
    private String status;

}
