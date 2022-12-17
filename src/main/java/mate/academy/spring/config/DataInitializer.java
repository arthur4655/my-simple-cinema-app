package mate.academy.spring.config;

import java.time.LocalDateTime;
import java.util.Set;
import javax.annotation.PostConstruct;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.Role;
import mate.academy.spring.model.User;
import mate.academy.spring.service.CinemaHallService;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.RoleService;
import mate.academy.spring.service.UserService;
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
