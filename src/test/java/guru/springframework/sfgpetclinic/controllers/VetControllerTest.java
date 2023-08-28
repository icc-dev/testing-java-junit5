package guru.springframework.sfgpetclinic.controllers;

import guru.springframework.fauxspring.ModelMapImpl;
import guru.springframework.sfgpetclinic.fauxspring.Model;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.map.SpecialityMapService;
import guru.springframework.sfgpetclinic.services.map.VetMapService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class VetControllerTest {
    VetController controller;
    VetMapService vetMapService;
    @BeforeEach
    void setUp() {
        vetMapService = new VetMapService(new SpecialityMapService());
        controller = new VetController(vetMapService);
    }

    @Test
    void verifyReturnedCorrectNameView() {
        assertEquals(
                controller.listVets(new ModelMapImpl()),
                "vets/index"
        );
    }

    @Test
    void verifyListValuesModel() {
        vetMapService.save(new Vet(1L, "firstName", "lastName", new HashSet<>()));
        vetMapService.save(new Vet(2L, "firstName", "lastName", new HashSet<>()));
        Model model = new ModelMapImpl();
        controller.listVets(model);
        assertEquals(vetMapService.findAll(), model.getAttribute("vets"), "List of vets not equals");
    }
}