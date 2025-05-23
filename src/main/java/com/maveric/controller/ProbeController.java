package com.maveric.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maveric.model.ProbeRequest;
import com.maveric.model.ProbeResponse;
import com.maveric.service.ProbeService;

@RestController
@RequestMapping("/control")
public class ProbeController {
	@Autowired
    private ProbeService probeService;

    @PostMapping
    public ResponseEntity<ProbeResponse> controlProbe(@RequestBody ProbeRequest request) {
        return ResponseEntity.ok(probeService.executeCommands(request));
    }
}
