package co.istad.chhaya.fswd_sbapp.bean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.PublicKey;
import java.util.List;

@RestController
public class MyBeanController {
//    1. Declare dependency
    private final MyAnnotationBean bean;
    private  MyAnnotationBean bean2;

//    2. Dependency injection (Constructor-based )
    public MyBeanController  (MyAnnotationBean bean){
        this.bean = bean;

    }
    @Autowired
    public void setBean2(MyAnnotationBean bean2){
        this.bean2 = bean2;
    }

    @GetMapping("/bean")
    public List<MyAnnotationBean> getBean(){
        System.out.println("bean: "+ bean);
        System.out.println("bean2: " + bean2 );
        bean.name = " Flynn ";
        bean2.name = "Jennie";
        return List.of( bean,bean2 ) ;

    }
}
