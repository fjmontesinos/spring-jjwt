package org.fj2m.springjwt.web;

import org.fj2m.springjwt.model.ProfileService;
import org.fj2m.springjwt.model.domain.DetailedProfile;
import org.fj2m.springjwt.model.domain.MinimalProfile;
import org.fj2m.springjwt.model.exceptions.ProfileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by javier-montesinos on 19/02/17.
 */
@RestController
@RequestMapping(path = "/profile")
public class ProfileController {

    private final ProfileService profileService;

    @SuppressWarnings("unused")
    public ProfileController() {
        this(null);
    }

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(path = "/{username}",
            method = GET,
            produces = APPLICATION_JSON_VALUE)
    public MinimalProfile minimal(@PathVariable String username) {
        return profileService.minimal(username)
                .orElseThrow(() -> new ProfileNotFoundException(username));
    }

    @RequestMapping(path = "/details/{username}",
            method = GET,
            produces = APPLICATION_JSON_VALUE)
    public DetailedProfile details(@PathVariable String username) {
        return profileService.detailed(username)
                .orElseThrow(() -> new ProfileNotFoundException(username));
    }
}