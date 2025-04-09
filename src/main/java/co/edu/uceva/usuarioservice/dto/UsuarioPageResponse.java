package co.edu.uceva.usuarioservice.dto;

import java.util.List;

public class UsuarioPageResponse {
    private List<UsuarioResponse> contenido;
    private int totalPaginas;
    private long totalElementos;
    private int paginaActual;

    public UsuarioPageResponse(List<UsuarioResponse> contenido, int totalPaginas, long totalElementos, int paginaActual) {
        this.contenido = contenido;
        this.totalPaginas = totalPaginas;
        this.totalElementos = totalElementos;
        this.paginaActual = paginaActual;
    }

    public List<UsuarioResponse> getContenido() {
        return contenido;
    }

    public void setContenido(List<UsuarioResponse> contenido) {
        this.contenido = contenido;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getPaginaActual() {
        return paginaActual;
    }

    public void setPaginaActual(int paginaActual) {
        this.paginaActual = paginaActual;
    }
}