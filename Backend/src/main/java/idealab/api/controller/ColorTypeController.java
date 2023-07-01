package idealab.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import idealab.api.dto.request.ColorTypeUpdateRequest;
import idealab.api.dto.response.DataResponse;
import idealab.api.dto.response.GenericResponse;
import idealab.api.model.ColorType;
import idealab.api.operations.ColorTypeOperations;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorTypeController {

    private ColorTypeOperations colorOperations;

    public ColorTypeController(ColorTypeOperations colorOperations) {
        this.colorOperations = colorOperations;
    }

    @GetMapping("/active")
    public ResponseEntity<?> getActiveColors() {
        DataResponse<ColorType> response = colorOperations.getActiveColors();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping
    public ResponseEntity<?> getAllColors() {
        DataResponse<ColorType> response = colorOperations.getAllColors();

        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    /**
     * This allows the user to change the availability status of the color.
     * Requires input of the color that wants the availability changed + whether it should
     * be available or not.
     * @param printId
     * @param model
     * @return
     */
    @PutMapping("/{color-id}/availability")
    public ResponseEntity<?> colorTypeUpdateAvailability(@PathVariable("color-id") Integer colorId,
                                                  @RequestBody ColorTypeUpdateRequest dto) {

        GenericResponse response = colorOperations.updateColorAvailability(colorId, dto);
        return new ResponseEntity<>(response, response.getHttpStatus());
    }

    @GetMapping("/inactive")
    public ResponseEntity<?> getInactiveColors() {
        DataResponse<ColorType> response = colorOperations.getInactiveColors();
        return new ResponseEntity<>(response, response.getHttpStatus());
    }
}