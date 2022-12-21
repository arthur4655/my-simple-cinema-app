package cinema.app.config;

import cinema.app.model.CinemaHall;
import cinema.app.model.Movie;
import cinema.app.model.MovieSession;
import cinema.app.model.Role;
import cinema.app.model.User;
import cinema.app.service.CinemaHallService;
import cinema.app.service.MovieService;
import cinema.app.service.MovieSessionService;
import cinema.app.service.RoleService;
import cinema.app.service.UserService;
import java.time.LocalDateTime;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final RoleService roleService;
    private final UserService userService;
    private final MovieService movieService;
    private final CinemaHallService cinemaHallService;
    private final MovieSessionService movieSessionService;

    public DataInitializer(RoleService roleService, UserService userService,
                           MovieService movieService, CinemaHallService cinemaHallService,
                           MovieSessionService movieSessionService) {
        this.roleService = roleService;
        this.userService = userService;
        this.movieService = movieService;
        this.cinemaHallService = cinemaHallService;
        this.movieSessionService = movieSessionService;
    }

    @PostConstruct
    public void inject() {
        //Inject default user with ADMIN role
        Role adminRole = new Role();
        adminRole.setName(Role.Type.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setName(Role.Type.USER);
        roleService.add(userRole);
        User user = new User();
        user.setEmail("admin@i.ua");
        user.setPassword("admin123");
        user.setRoles(Set.of(adminRole));
        userService.add(user);

        //Inject default movie, cinema hall and movie session
        Movie darkKnight = new Movie();
        darkKnight.setTitle("Dark Knight");
        darkKnight.setDescription("The Dark Knight is a 2008 superhero film "
                + "directed by Christopher Nolan.");
        movieService.add(darkKnight);
        CinemaHall hallAlpha = new CinemaHall();
        hallAlpha.setCapacity(120);
        hallAlpha.setDescription("Big and comfortable");
        cinemaHallService.add(hallAlpha);
        MovieSession darkKnightSession = new MovieSession();
        darkKnightSession.setCinemaHall(hallAlpha);
        darkKnightSession.setMovie(darkKnight);
        darkKnightSession.setShowTime(LocalDateTime.now());
        movieSessionService.add(darkKnightSession);
    }
}
