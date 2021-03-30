package com.example.demo.interfaces;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.OrdemServico;
import com.example.demo.representationmodelclass.RepresentationModelOrdemServico;

public interface OrdemServiceInterface extends JpaRepository<OrdemServico, Long>{
	//List<RepresentationModelOrdemServico> listarOrdens(); 
}