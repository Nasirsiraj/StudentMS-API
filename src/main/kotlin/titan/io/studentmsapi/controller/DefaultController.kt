package titan.io.studentmsapi.controller

import lombok.extern.slf4j.Slf4j
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping

@Slf4j
@Controller
@CrossOrigin(origins = arrayOf("*"), allowedHeaders = arrayOf("*"))
class DefaultController {
    @RequestMapping("/")
    public fun getDefaultPage(): String{

        return "index.html"
    }
}
