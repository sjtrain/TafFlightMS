package com.tekarch.FlightMS.Controller;

import com.tekarch.FlightMS.DTO.FlightDTO;
import com.tekarch.FlightMS.Services.Impl.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightServiceImpl flightsService;

    @GetMapping
    public ResponseEntity<List<FlightDTO>> getAllFlights() {
        return ResponseEntity.ok(flightsService.getAllFlights());
    }

    @GetMapping("/{flightId}")
    public ResponseEntity<FlightDTO> getFlightById(@PathVariable Long flightId) {
        FlightDTO flight = flightsService.getFlightById(flightId);
        return flight != null ? ResponseEntity.ok(flight) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<FlightDTO> addFlight(@RequestBody FlightDTO flight) {
        FlightDTO addedFlight = flightsService.addFlight(flight);
        return ResponseEntity.ok(addedFlight);
    }

    @PutMapping("/{flightId}")
    public ResponseEntity<FlightDTO> updateFlight(@PathVariable Long flightId ,@RequestBody FlightDTO updatedFlight) {
        FlightDTO updated = flightsService.updateFlight(flightId, updatedFlight);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{flightId}")
    public ResponseEntity<String> deleteFlight(@PathVariable Long flightId) {
        flightsService.deleteFlight(flightId);
        String message = "Flight with id " + flightId + " has been deleted.";
        return ResponseEntity.ok(message);

    }


}
