package at.ht.control;

import at.htl.entity.Vehicle;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/vehicle")
public class VehicleResource {

    private final List<Vehicle> vehicles = List.of(
            new Vehicle("Opel", "Kadett"),
            new Vehicle("Opel", "Astra"),
            new Vehicle("VW", "Golf"),
            new Vehicle("VW", "Passat"),
            new Vehicle("VW", "Tiguan"),
            new Vehicle("VW", "Touareg"),
            new Vehicle("VW", "Tupolev"),
            new Vehicle("VW", "Golf Plus"),
            new Vehicle("VW", "Golf R"),
            new Vehicle("VW", "Golf GTI")
    );

    @GET
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance getVehicles() {
        return Templates.vehicle(vehicles);
    }

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance vehicle(List<Vehicle> vehicles);
    }
}
