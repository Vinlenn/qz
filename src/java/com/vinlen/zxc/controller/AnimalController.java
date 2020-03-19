package com.vinlen.zxc.controller;


import com.vinlen.zxc.bean.Animal;
import com.vinlen.zxc.ioc.annotationLoader.Component;
import com.vinlen.zxc.ioc.annotationLoader.Inject;
import com.vinlen.zxc.service.AnimalService;


@Component
public class AnimalController {
   @Inject
    private AnimalService animalService;
   public void getAnimal(){
       Animal animal=animalService.getAnimal();
       System.out.println(animal);
   }
}
