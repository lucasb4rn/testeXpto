package br.com.xpto.entitys.dto;

public class EstadoQuantidadeCidade {

		private String estado;
		private long quantidadeDeCidades;

		public EstadoQuantidadeCidade(String estado, long quantidadeDeCidades){
			this.estado = estado;
			this.quantidadeDeCidades = quantidadeDeCidades;
		}

		public long getQuantidadeDeCidades() {
			return quantidadeDeCidades;
		}

		public void setQuantidadeDeCidades(long quantidadeDeCidades) {
			this.quantidadeDeCidades = quantidadeDeCidades;
		}

		public String getEstado() {
			return estado;
		}

		public void setEstado(String estado) {
			this.estado = estado;
		}
		

}
