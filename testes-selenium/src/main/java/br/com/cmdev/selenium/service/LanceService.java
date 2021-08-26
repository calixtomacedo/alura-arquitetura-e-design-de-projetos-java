package br.com.cmdev.selenium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cmdev.selenium.dto.NovoLanceDto;
import br.com.cmdev.selenium.model.Lance;
import br.com.cmdev.selenium.model.Leilao;
import br.com.cmdev.selenium.model.Usuario;
import br.com.cmdev.selenium.repositories.LanceRepository;
import br.com.cmdev.selenium.repositories.LeilaoRepository;
import br.com.cmdev.selenium.repositories.UsuarioRepository;

@Service
public class LanceService {

	@Autowired
	private LanceRepository lances;

	@Autowired
	private UsuarioRepository usuarios;

	@Autowired
	private LeilaoRepository leiloes;

	public boolean propoeLance(NovoLanceDto lanceDto, String nomeUsuario) {

		Usuario usuario = usuarios.getUserByUsername(nomeUsuario);
		Lance lance = lanceDto.toLance(usuario);

		Leilao leilao = this.getLeilao(lanceDto.getLeilaoId());

		if (leilao.propoe(lance)) {
			lances.save(lance);
			return true;
		}

		return false;
	}

	public Leilao getLeilao(Long leilaoId) {
		return leiloes.getOne(leilaoId);
	}

}