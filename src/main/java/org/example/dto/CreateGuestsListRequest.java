package org.example.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateGuestsListRequest {

    private String listName;
    private List<Long> idsGuests;
}