package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.InformeDAO;
import model.vo.PrimerInformeVO;
import model.vo.SegundoInformeVO;
import model.vo.TercerInformeVO;
import view.Interfaz;

/**
 *
 * @author JancarlosCh
 */
public class ControladorInformes implements ActionListener {

    private Interfaz vista = new Interfaz();
    private final InformeDAO informes = new InformeDAO();

    public ControladorInformes(Interfaz vista) {
        this.vista = vista;
        vista.setVisible(true);
        agregarEventos();
        mostrarInforme();
    }

    private void agregarEventos() {
        vista.getBtnGenerarInforme().addActionListener(this);
        vista.getComboBoxIformes().addActionListener(this);
    }

    private boolean validarComboBox() {
        return vista.getComboBoxIformes().getSelectedIndex() != 0;
    }

    private boolean mostrarInforme() {
        boolean itemSeleccionado = false;
        DefaultTableModel tblModel = new DefaultTableModel();

        if (validarComboBox()) {
            itemSeleccionado = true;
            int seleccion = vista.getComboBoxIformes().getSelectedIndex();

            switch (seleccion) {
                case 1 -> {
                    List<PrimerInformeVO> informeLideres = informes.consultarLideres();
                    llenarTablaLider(tblModel, informeLideres);
                    vista.getTblInformes().setModel(tblModel);
                }

                case 2 -> {
                    List<SegundoInformeVO> informePoyectos = informes.consultarProyectos();
                    llenarTablaProyectos(tblModel, informePoyectos);
                    vista.getTblInformes().setModel(tblModel);
                }

                case 3 -> {
                    List<TercerInformeVO> informeCompras = informes.consultarCompras();
                    llenarTablaCompras(tblModel, informeCompras);
                    vista.getTblInformes().setModel(tblModel);
                }
            }
        }

        return itemSeleccionado;
    }

    private void llenarTablaLider(DefaultTableModel modelo, List<PrimerInformeVO> datos) {
        modelo.setColumnIdentifiers(new Object[]{"id lider", "Nombre", "Apellido", "Ciudad"});
        for (PrimerInformeVO registro : datos) {
            modelo.addRow(new Object[]{
                registro.getIdLider(),
                registro.getNombre(),
                registro.getPrimerApellido(),
                registro.getCiudad()
            });
        }
    }

    private void llenarTablaProyectos(DefaultTableModel modelo, List<SegundoInformeVO> datos) {
        modelo.setColumnIdentifiers(new Object[]{"id proyecto", "Constructora", "Número de habitantes", "Ciudad"});
        for (SegundoInformeVO registro : datos) {
            modelo.addRow(new Object[]{
                registro.getIdProyecto(),
                registro.getConstructora(),
                registro.getNumeroHabitantes(),
                registro.getCiudad()
            });
        }
    }

    public void llenarTablaCompras(DefaultTableModel modelo, List<TercerInformeVO> datos) {
        modelo.setColumnIdentifiers(new Object[]{"id compra", "Constructora", "Banco vinculado"});
        for (TercerInformeVO registro : datos) {
            modelo.addRow(new Object[]{
                registro.getIdCompra(),
                registro.getConstructora(),
                registro.getBancoVinculado()
            });
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vista.getBtnGenerarInforme())) {

            boolean itemSeleccionado = mostrarInforme();

            if (!itemSeleccionado) {
                JOptionPane.showConfirmDialog(
                        null,
                        "No has seleccionado una de las consultas disponibles en la lista.", "Error...",
                        JOptionPane.CLOSED_OPTION,
                        0
                );
            }
        }
    }
}
