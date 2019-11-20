package vijnana.respuesta.wrapper.response;

public class AbstractWrapperError {
	
	private int codigo;
	private String mensaje;

	public AbstractWrapperError() {
	}
	
	public AbstractWrapperError(String mensaje) {
		super();
		this.mensaje = mensaje;
	}
	
	public AbstractWrapperError(int codigo, String mensaje) {
		super();
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
