package com.kc.learnings.spring.restfulwebservices.responseFiltering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class responseFiltering {

    @GetMapping("/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("value1", "value2", "value3");
    }

    @GetMapping("/filtering-dynamic")
    public MappingJacksonValue retrieveSomeBeanDynamicFiltering(){

        SomeBean someBean = new SomeBean("value1", "value2", "value3");
//        FilterProvider filters = new SimpleFilterProvider().addFilter();

        //Add simpleBeanPropertyFilter to dynamically filter fields only for this specific controller method
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1");

        //Create a FilterProvider and add SimplePropertyFilter
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        //Create MappingJascksonValue with FilterProvider
        MappingJacksonValue mapping = new MappingJacksonValue(someBean);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/filtering-list")
    public List<SomeBean> retrieveListOfSomeBeans(){
        return Arrays.asList(
            new SomeBean("field1", "field2", "field3"),
            new SomeBean("field13", "field15", "field16")
        );
    }

    @GetMapping("/filtering-list-dynamic")
    public MappingJacksonValue retrieveSomeBeanListDynamicFiltering(){

        List<SomeBean> list = Arrays.asList(
                new SomeBean("field1", "field2", "field3"),
                new SomeBean("field13", "field15", "field16")
        );

        //Add simpleBeanPropertyFilter to dynamically filter fields only for this specific controller method
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("field1");

        //Create a FilterProvider and add SimplePropertyFilter
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);

        //Create MappingJascksonValue with FilterProvider
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        mapping.setFilters(filters);

        return mapping;
    }
}
