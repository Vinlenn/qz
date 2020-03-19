package com.vinlen.zxc.service;


import com.vinlen.zxc.bean.Animal;
import com.vinlen.zxc.ioc.annotationLoader.Component;

@Component
public class AnimalService {
    public Animal getAnimal() {
        return new Animal("狗", "骨头");
    }
}
