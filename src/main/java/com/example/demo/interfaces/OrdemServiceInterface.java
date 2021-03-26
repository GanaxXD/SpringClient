package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.OrdemServico;

public interface OrdemServiceInterface extends JpaRepository<OrdemServico, Long>{

}
