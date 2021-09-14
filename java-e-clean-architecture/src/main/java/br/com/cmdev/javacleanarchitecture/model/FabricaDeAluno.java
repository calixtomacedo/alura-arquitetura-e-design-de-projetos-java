package br.com.cmdev.javacleanarchitecture.model;

public class FabricaDeAluno {

	private Aluno aluno;
	
	public FabricaDeAluno comNomeCPFEmail(String nome, String cpf, String email) {
		this.aluno = new Aluno(new CPF(cpf), nome, new Email(email));
		return this;
	}
	
	public FabricaDeAluno comTelefone(String ddd, String numero) {
		this.aluno.adicionarTelefone(ddd, numero);
		return this;
	}
	
	public Aluno criar() {
		return this.aluno;
	}
	
	
	public static void main(String[] args) {
		FabricaDeAluno fabrica = new FabricaDeAluno();
		Aluno aluno = fabrica.comNomeCPFEmail("Calixto Macedo", "000.000.000-00", "calixto.macedo@gmail.com")
		.comTelefone("11", "998509646").criar();
		
		System.out.println(aluno.getNome());
		System.out.println(aluno.getCpf().getNumero());
		System.out.println(aluno.getEmail().getEndereco());
		aluno.getTelefones().forEach(tel -> System.out.println(tel.getDdd()+"-"+tel.getNumero()));
	}
}
