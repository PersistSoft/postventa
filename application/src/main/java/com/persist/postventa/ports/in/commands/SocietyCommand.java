package com.persist.postventa.ports.in.commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SocietyCommand {
    private String name;
    private String nit;
}
