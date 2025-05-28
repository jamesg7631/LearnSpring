package com.in28minutes.learn_spring_framewok.exercise.businesscalculationservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
interface DataService {
    int[] retrieveData();
}

@Component
@Qualifier("MongoDBQualifier")
class MongoDbDataService implements DataService {
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }
}

@Component
@Primary
class MySQLDataService implements DataService {
    public int[] retrieveData() {
        return new int[] {1, 2, 3, 4, 5};
    }
}

@Component
class BusinessCalculationService {
    private DataService dataService;

    @Autowired
    public BusinessCalculationService(@Qualifier("MongoDBQualifier") DataService dataService) {
        this.dataService = dataService;
    }
    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}

@Configuration
@ComponentScan
public class BusinessServiceLauncher {
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(BusinessServiceLauncher.class)) {
            System.out.println(context.getBean(BusinessCalculationService.class).findMax());
        }
    }
}
