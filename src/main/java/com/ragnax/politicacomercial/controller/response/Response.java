package com.ragnax.politicacomercial.controller.response;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="response")
public class Response implements Serializable{

	private static final long serialVersionUID = -6581071838120916016L;
	
	private int status;
	
	private PoliticaComercial data;
	
	protected String url;
	
	protected String tiempoRespuesta;
	
	protected AbstractWrapperError error;
	
	public Response() {
		super();
	}
	
	
	public Response(AbstractWrapperError error, int status, PoliticaComercial data, String tiempoRespuesta,  String url) {
		this.error = error;
		this.status = status;
		this.data = data;
		this.tiempoRespuesta = tiempoRespuesta;
		this.url = url;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public PoliticaComercial getData() {
		return data;
	}

	public void setData(PoliticaComercial data) {
		this.data = data;
	}


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
	
	
	
}
