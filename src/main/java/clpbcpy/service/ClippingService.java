package clpbcpy.service;

import clpbcpy.ClippingNotFoundException;
import clpbcpy.entity.Clipping;
import clpbcpy.repository.ClippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class ClippingService {

    @Autowired
    private ClippingRepository clippingRepository;

    public Clipping getLatest() {
        return clippingRepository.findFirstByOrderByIdDesc().orElseThrow(ClippingNotFoundException::new);
    }

    public ResponseEntity<?> saveClipping(String message, String contentLinks) {
        Clipping clipping = Clipping.builder().message(message).contentLinksJson(contentLinks).build();
        clippingRepository.saveAndFlush(clipping);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(clipping.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    public Clipping getById(long id) {
        return clippingRepository.getById(id).orElseThrow(ClippingNotFoundException::new);
    }
}
