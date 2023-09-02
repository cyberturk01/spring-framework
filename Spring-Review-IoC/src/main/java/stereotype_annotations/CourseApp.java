package stereotype_annotations;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import stereotype_annotations.config.AppConfig;
import stereotype_annotations.model.DataStructure;
import stereotype_annotations.model.MicroService;

public class CourseApp {
    public static void main(String[] args) {
        ApplicationContext context= new AnnotationConfigApplicationContext(AppConfig.class);

        DataStructure dataStructure = context.getBean(DataStructure.class);
        dataStructure.getTotalHours();
        MicroService microService = context.getBean(MicroService.class);
        microService.getTotalHours();

    }
}
