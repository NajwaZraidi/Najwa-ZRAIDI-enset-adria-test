package ma.enset.clientservice.entities;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "client",types = Client.class)
public interface ClientProjection {
    public Long getId();
    public String getNom();
    public String getEmail();

}
