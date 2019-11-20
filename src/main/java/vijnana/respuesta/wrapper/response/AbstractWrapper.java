package vijnana.respuesta.wrapper.response;

import org.codehaus.jackson.annotate.JsonProperty;

public abstract class AbstractWrapper {
	

	@JsonProperty("url")
	protected String url;
	
	@JsonProperty("tiempoRespuesta")
	protected String tiempoRespuesta;
	
	@JsonProperty("tiempoRespuesta")
	protected AbstractWrapperError error;
	
//	@JsonProperty("data")
//	protected boolean data;
	/************
	Servicio sin problemas OK
	error!=null
	Negocio sin problemas OK
	ok =true;	
	/**************/
	
	public AbstractWrapper() {
		super();
	}
	
	public AbstractWrapper(String tiempoRespuesta, String url) {
		super();
		this.tiempoRespuesta = tiempoRespuesta;
		this.url = url;
	}
	
	public AbstractWrapper(String tiempoRespuesta,String url, AbstractWrapperError error) {
		super();
		this.tiempoRespuesta = tiempoRespuesta;
		this.url = url;
		this.error = error;
	}
	
//	public AbstractWrapper(String tiempoRespuesta,String url, AbstractWrapperError error,
//			boolean data) {
//		super();
//		this.tiempoRespuesta = tiempoRespuesta;
//		this.url = url;
//		this.data = data;
//		this.error = error;
//	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}



	public String getTiempoRespuesta() {
		return tiempoRespuesta;
	}

	public void setTiempoRespuesta(String tiempoRespuesta) {
		this.tiempoRespuesta = tiempoRespuesta;
	}
	
	public AbstractWrapperError getError() {
		return error;
	}

	public void setError(AbstractWrapperError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "AbstractWrapper [tiempoRespuesta=" + tiempoRespuesta + ", url=" + url +"]";
	}

}
