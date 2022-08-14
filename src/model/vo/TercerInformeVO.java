package model.vo;

/**
 *
 * @author JancarlosCh
 */
public class TercerInformeVO {
//Compras realizadas por los proyectos con el proveedo “Homecenter” y para la ciudad “Salento”
    private int idCompra;
    private String constructora;
    private String bancoVinculado;

    public TercerInformeVO(int idCompra, String constructora, String bancoVinculado) {
        this.idCompra = idCompra;
        this.constructora = constructora;
        this.bancoVinculado = bancoVinculado;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public String getConstructora() {
        return constructora;
    }

    public void setConstructora(String constructora) {
        this.constructora = constructora;
    }

    public String getBancoVinculado() {
        return bancoVinculado;
    }

    public void setBancoVinculado(String bancoVinculado) {
        this.bancoVinculado = bancoVinculado;
    }
}
