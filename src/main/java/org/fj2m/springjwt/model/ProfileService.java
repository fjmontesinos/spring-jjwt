package org.fj2m.springjwt.model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.fj2m.springjwt.model.domain.DetailedProfile;
import org.fj2m.springjwt.model.domain.MinimalProfile;
import org.fj2m.springjwt.model.domain.Profile;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

/**
 * Created by javier-montesinos on 19/02/17.
 */
@Component
public class ProfileService {
    private final List<Profile> profiles;

    private final Path PROFILES_FILE = Paths.get(this.getClass().getResource("/profiles.json").toURI());

    public ProfileService() throws IOException, URISyntaxException {
        ObjectMapper objectMapper = new ObjectMapper();
        profiles = objectMapper.readValue(PROFILES_FILE.toFile(), new TypeReference<List<Profile>>() {
        });
    }

    protected Optional<Profile> get(String username) {
        return profiles.stream()
                .filter(profile -> profile.getLogin().getUsername().equals(username))
                .findFirst();
    }

    public Optional<MinimalProfile> minimal(String username) {
        return get(username).map(profile -> new MinimalProfile(profile));
    }

    public Optional<DetailedProfile> detailed(String username) {
        return get(username).map(profile -> new DetailedProfile(profile));
    }
}
