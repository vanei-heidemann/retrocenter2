package br.com.javanei.platform;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@OpenAPIDefinition(
    tags = {
        @Tag(name = "Platform", description = "Platform operations.")
    },
    info = @Info(
        title = "Platforms API",
        version = "1.0.0",
        contact = @Contact(
            name = "Vanei Anderson Heidemann",
            url = "http://www.javanei.com.br",
            email = "vanei.heidemann@gmail.com"),
        license = @License(
            name = "Licença Pública Geral GNU, version 2",
            url = "https://www.gnu.org/licenses/old-licenses/gpl-2.0.html"
        )
    )
)
public class OpenAPIDefinitionApplication extends Application {
}
