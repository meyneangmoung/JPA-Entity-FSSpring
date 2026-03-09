package co.istad.chhaya.fswd_sbapp.valueannotation;



//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//record AppInfo(
//        String appName,
//        Integer appPort
//){
//}
//@RestController
//
//public class ValueAnnotationController {
//
//    @Value("${spring.application.name}")
//    private String appName;
//
//    @Value("${server.port}")
//    private Integer appPort;
//    @GetMapping("/ingo")
//   public AppInfo getAppInfo(){
//       return  new AppInfo(appName,appPort);
//   }
//
//}
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
record AppInfo(String appName, Integer appPort){

}
@RestController
public class ValueAnnotationController {
    @Value("${spring.application.name}")
    private String appName;
    @Value("${server.port}")
    private Integer appPort;
    @GetMapping("/appInfo")
    public AppInfo getAppInfo(){
        return new AppInfo(appName, appPort);
    }

}
