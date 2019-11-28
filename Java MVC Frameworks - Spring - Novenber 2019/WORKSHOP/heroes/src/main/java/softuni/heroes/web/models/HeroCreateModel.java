package softuni.heroes.web.models;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor
@NoAutoStart
public class HeroCreateModel {

    private String name;
    private String gender;
}
