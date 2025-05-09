package challenge.pragma.aws.infrastructure.input.rest.v1;


import challenge.pragma.aws.infrastructure.util.constant.RestConstants;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/home")
public class HomeController {
    @Operation(summary = RestConstants.SWAGGER_SUMMARY_GET_HOME)
    @GetMapping
    public String home(){
        return "User's Microservice";
    }
}
