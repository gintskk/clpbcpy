package clpbcpy.controller;

import clpbcpy.entity.Clipping;
import clpbcpy.service.ClippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ClippingController {

    @Autowired
    private ClippingService service;

    @GetMapping(path = "/latest")
    public @ResponseBody
    Clipping getLatest() {
        return service.getLatest();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody
    Clipping getById(@PathVariable long id) {
        return service.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> saveClipping(@RequestParam String message, @RequestBody String contentLinksJson) {
        return service.saveClipping(message, contentLinksJson);
    }
}
