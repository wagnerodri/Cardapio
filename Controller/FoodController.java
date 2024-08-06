package com.example.Cardapio.Controller;

import com.example.Cardapio.Food.Food;
import com.example.Cardapio.Food.FoodRepository;
import com.example.Cardapio.Food.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("food")
public class FoodController {

    @Autowired
    private FoodRepository repository;

    @PostMapping
    public void saveFood(@RequestBody  FoodResponseDTO data){

        Food foodData = new Food(data);
        repository.save( foodData);


    }

    @GetMapping
    public List< FoodResponseDTO> getAll(){

 List< FoodResponseDTO> FoodList = repository.findAll().stream().map(FoodResponseDTO::new).toList();
 return FoodList;

    }
}
