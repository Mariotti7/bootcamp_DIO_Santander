package com.project.bootcamp.controller;

import java.util.List;	

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.bootcamp.model.DTO.StockDTO;
import com.project.bootcamp.service.StockService;

@CrossOrigin()
@RestController
@RequestMapping(value="/stock")
public class StockController {
	
	@Autowired
	private StockService stockService;
	
	@PostMapping
	public ResponseEntity<StockDTO> save(@Valid @RequestBody StockDTO dto){
		return ResponseEntity.ok(stockService.save(dto));
	}
	
	@PutMapping
	public ResponseEntity<StockDTO> update(@RequestBody StockDTO dto){
		return ResponseEntity.ok(stockService.update(dto));
	}
	
	@GetMapping
	public ResponseEntity<List<StockDTO>> findAll(){
		
		return ResponseEntity.ok(stockService.findAll());
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<StockDTO> finById(@PathVariable Long id){
		
		return ResponseEntity.ok(stockService.findById(id)); 
	}
	
	@GetMapping(value="/today")
	public ResponseEntity <List<StockDTO>> findByToday(){
		return ResponseEntity.ok(stockService.findByToday());
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<StockDTO> delete(@PathVariable Long id){
		return ResponseEntity.ok(stockService.delete(id));
	}
	
}
