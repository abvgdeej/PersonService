package com.example.personalservice.controller;

import com.example.personalservice.persist.PersonEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response {
    private List<PersonEntity> list;
}
