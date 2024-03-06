//package com.trungtd.departmentservice.config;
//
//import com.trungtd.departmentservice.client.EmployeeClient;
//import lombok.RequiredArgsConstructor;
//import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.reactive.function.client.WebClient;
//import org.springframework.web.reactive.function.client.support.WebClientAdapter;
//import org.springframework.web.service.invoker.HttpServiceProxyFactory;
//
//@Configuration
//@RequiredArgsConstructor
//public class WebClientConfig {
//    private final LoadBalancedExchangeFilterFunction filterFunction;
//    @Bean
//    public WebClient employeeWebClient() {
//        return WebClient.builder()
//                .baseUrl("http://employee-service")
//                .filter(filterFunction)
//                .build();
//    }
//
//    @Bean
//    public EmployeeClient employeeClient() {
//        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
//                .builder(WebClientAdapter.create(employeeWebClient()))
//                .build();
//        return httpServiceProxyFactory.createClient(EmployeeClient.class);
//    }
//
////    @Bean
////    public RestTemplate restTemplate() {
////        return new RestTemplate();
////    }
//}
