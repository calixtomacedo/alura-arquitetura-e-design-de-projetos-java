package br.com.cmdev.solidcomjava.model;

public enum Cargo {

	ASSISTENTE {
		@Override
		public Cargo proximoCargo() {
			return ANALISTA;
		}
	},
	ANALISTA {
		@Override
		public Cargo proximoCargo() {
			return ESPECIALISTA;
		}
	},
	ESPECIALISTA {
		@Override
		public Cargo proximoCargo() {
			return GERENTE;
		}
	},
	GERENTE {
		@Override
		public Cargo proximoCargo() {
			return GERENTE;
		}
	};

	public abstract Cargo proximoCargo();
}
