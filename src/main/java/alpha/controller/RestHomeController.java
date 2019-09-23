package alpha.controller;

import alpha.model.Home;
import alpha.service.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
class RestHomeController {

    @Autowired
    private HomeService homeService;

    @RequestMapping(value = "/homes", method = RequestMethod.GET)
    public ResponseEntity<Iterable<Home>> listAllHome( ) {
        List<Home> homes = (List<Home>) homeService.findAll();
        if (homes.size() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(homes, HttpStatus.OK);
    }

    @RequestMapping(value = "/homes/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Home> getHome(@PathVariable Long id) {
        System.out.println("Fetching Home with id" + id);
        Home home = homeService.findById(id);
        if (home == null) {
            return new ResponseEntity<Home>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Home>(home, HttpStatus.OK);
    }

    @RequestMapping(value = "/homes", method = RequestMethod.POST)
    public ResponseEntity<Void> createHome(@RequestBody Home home) {
        homeService.save(home);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value = "/homes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Home> updateHome(@PathVariable("id") Long id, @RequestBody Home home) {
        Home currentHome = homeService.findById(id);

        if (currentHome == null) {
            return new ResponseEntity<Home>(HttpStatus.NOT_FOUND);
        }
        currentHome.setId(home.getId());
        currentHome.setName(home.getName());
        currentHome.setKindOfHome(home.getKindOfHome());
        currentHome.setKindOfRoom(home.getKindOfRoom());
        currentHome.setAddress(home.getAddress());
        currentHome.setNumberOfBedRoom(home.getNumberOfBedRoom());
        currentHome.setBathRoom(home.getBathRoom());
        currentHome.setDescription(home.getDescription());
        currentHome.setPrice(home.getPrice());


        homeService.save(currentHome);
        return new ResponseEntity<Home>(currentHome, HttpStatus.OK);
    }

    @RequestMapping(value = "/homes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Home> deleteHome(@PathVariable("id") Long id) {
        Home home = homeService.findById(id);
        if (home == null) {
            return new ResponseEntity<Home>(HttpStatus.NOT_FOUND);
        }

        homeService.remove(id);
        return new ResponseEntity<Home>(HttpStatus.NO_CONTENT);
    }

}
