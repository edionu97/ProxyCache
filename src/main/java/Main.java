import cache.proxies.ProxyCacher;
import config.Bootstrapper;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.IUserService;

public class Main {

    public static void main(String ...args) {

        final var bootstapper = new AnnotationConfigApplicationContext(Bootstrapper.class);

//        var service = ProxyCacher.getCacheable(bootstapper.getBean(IUserService.class));
        var service = bootstapper.getBean(IUserService.class);

        System.out.println(service.getAll().size());
        System.out.println(service.getAll().size());
        System.out.println(service.getAll().size());

        service.addUser("maria", "ioana");

        System.out.println(service.getAll().size());
        System.out.println(service.getAll().size());
        System.out.println(service.getAll().size());
    }
}
