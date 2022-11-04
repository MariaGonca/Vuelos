package com.solera.ndproyect.ndproyect.controller;

import com.solera.ndproyect.ndproyect.entity.FamousOrigin;
import com.solera.ndproyect.ndproyect.entity.Trip;
import com.solera.ndproyect.ndproyect.service.IFamousOriginService;
import com.solera.ndproyect.ndproyect.service.ITripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FamousController {

    @Autowired
    private IFamousOriginService FOService;

    @GetMapping("/FO")
    public List<FamousOrigin> placesOrigin() {
        return FOService.listOrigins();
    }
}
