package com.example.demo.controllerCliente;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.ComentariosInput;
import com.example.demo.models.Estados;
import com.example.demo.models.OrdemServico;
import com.example.demo.representationmodelclass.RepresentationModelComentario;
import com.example.demo.handlerexception.NegocioException;
import com.example.demo.interfaces.OrdemServiceInterface;
import com.example.demo.models.Comentarios;
import com.example.demo.services.OrdemServiceService;

@RestController
@RequestMapping("/ordemservico/{ordemservicoId}/comentario")
public class ComentarioController {

	@Autowired
	OrdemServiceService ordemServicoService;
	
	@Autowired
	OrdemServiceInterface Ointerface;
	
	@Autowired
	ModelMapper modelMap;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ComentariosInput criarComentario(@PathVariable Long ordemservicoId, @Valid @RequestBody ComentariosInput comentario) {
		Comentarios coment = ordemServicoService.adicionarcomentario(ordemservicoId, comentario.getDescricao());
		return toModel(coment);
	}
	
	@GetMapping
	public List<ComentariosInput> listarComentarios (@PathVariable Long ordemservicoId){
		OrdemServico os = Ointerface.findById(ordemservicoId)
				.orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada!"));
		return toCollection(os.getComentarios());
	}
	
	@PutMapping("/ordemservico/{ordemservicoId}/finalizar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalizar(@PathVariable Long ordemservicoId) {
		OrdemServico os = Ointerface.findById(ordemservicoId)
				.orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada!"));
		if(!os.getStatus().equals(Estados.ABERTO)) {
			throw new NegocioException("A ordem está ou cancelada ou finaizada.");
		}
		os.setStatus(Estados.FINALIZADO);
		os.setDataFinalizacao(OffsetDateTime.now());
		Ointerface.save(os);
	}
	
	@PutMapping("/ordemservico/{ordemservicoId}/cancelar")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void cancelar(@PathVariable Long ordemservicoId) {
		OrdemServico os = Ointerface.findById(ordemservicoId)
				.orElseThrow(() -> new NegocioException("Ordem de serviço não encontrada!"));
		if(!os.getStatus().equals(Estados.ABERTO)) {
			throw new NegocioException("A ordem está ou cancelada ou finaizada.");
		}
		os.setStatus(Estados.CANCELADO);
		os.setDataFinalizacao(OffsetDateTime.now());
		Ointerface.save(os);
	}

	public ComentariosInput toModel(Comentarios coment) {
		return modelMap.map(coment, ComentariosInput.class);
	}
	
	public List<ComentariosInput> toCollection(List<Comentarios> comentarios){
		return comentarios.stream() 
				.map(comentario -> toModel(comentario))
				.collect(Collectors.toList());
	}
}