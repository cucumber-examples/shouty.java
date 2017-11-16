package shouty;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class ShoutyHelper {
    Shouty shouty = new Shouty();
}
