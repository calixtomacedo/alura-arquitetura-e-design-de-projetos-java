package br.com.cmdev.solidcomjava.service;

import br.com.cmdev.solidcomjava.ValidacaoException;
import br.com.cmdev.solidcomjava.model.Cargo;
import br.com.cmdev.solidcomjava.model.Funcionario;

public class PromocaoService {

	public void promover(Funcionario funcionario, boolean metaBatida) {
		Cargo cargoAtual = funcionario.getCargo();
		if(Cargo.GERENTE == cargoAtual) {
			throw new ValidacaoException("Gerentes não podem ser promovidos!");
		}
		
		if(!metaBatida) {
			throw new ValidacaoException("Funcionario não bateu a meta!");
		}
		
		Cargo novoCargo = cargoAtual.proximoCargo();
		funcionario.promover(novoCargo);
	}
}
