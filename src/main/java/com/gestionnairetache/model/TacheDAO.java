package com.gestionnairetache.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class TacheDAO {
    private String id;
    private String label;
    private boolean complete;

}
