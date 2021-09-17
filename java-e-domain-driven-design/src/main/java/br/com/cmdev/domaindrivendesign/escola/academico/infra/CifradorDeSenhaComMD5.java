package br.com.cmdev.domaindrivendesign.escola.academico.infra;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import br.com.cmdev.domaindrivendesign.escola.academico.dominio.CifradorDeSenha;

public class CifradorDeSenhaComMD5 implements CifradorDeSenha {

	@Override
	public String cifrarSenha(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(senha.getBytes());
			byte[] digest = md.digest();
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < digest.length; i++) {
				builder.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
			}
			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("Erro ao gerar a senha criptograda "+e);
		}
	}

	@Override
	public boolean validarSenhaCifrada(String senhaCifrada, String senha) {
		return senhaCifrada.equals(cifrarSenha(senha));
	}

}
