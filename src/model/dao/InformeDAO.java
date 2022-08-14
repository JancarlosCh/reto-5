/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import database.Conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.ArrayList;

import model.vo.PrimerInformeVO;
import model.vo.SegundoInformeVO;
import model.vo.TercerInformeVO;

/**
 *
 * @author JancarlosCh
 */
public class InformeDAO {

    private Statement declaracion;
    private ResultSet consulta;

    public List<PrimerInformeVO> consultarLideres() {
        String sql = """
                     SELECT ID_Lider AS id, Nombre AS nombre, Primer_Apellido AS apellido, Ciudad_Residencia AS ciudad
                     FROM Lider
                     ORDER BY ciudad;
                     """;

        List<PrimerInformeVO> informes = new ArrayList<>();

        try ( Connection connection = Conexion.getConnection()) {

            declaracion = connection.createStatement();
            consulta = declaracion.executeQuery(sql);

            while (consulta.next()) {
                int id = consulta.getInt("id");
                String nombre = consulta.getString("nombre");
                String apellido = consulta.getString("apellido");
                String ciudad = consulta.getString("ciudad");

                PrimerInformeVO informeLider = new PrimerInformeVO(id, nombre, apellido, ciudad);
                informes.add(informeLider);
            }

            consulta.close();
            declaracion.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return informes;
    }

    public List<SegundoInformeVO> consultarProyectos() {
        String sql = """
                     SELECT ID_Proyecto AS id,  Constructora, Numero_Habitaciones AS habitantes, Ciudad  
                     FROM Proyecto p 
                     WHERE (Clasificacion = 'Casa Campestre') AND Ciudad IN ('Santa Marta' , 'Cartagena' , 'Barranquilla')
                     """;

        List<SegundoInformeVO> informes = new ArrayList<>();

        try ( Connection connection = Conexion.getConnection()) {

            declaracion = connection.createStatement();
            consulta = declaracion.executeQuery(sql);

            while (consulta.next()) {
                int id = consulta.getInt("id");
                String constructora = consulta.getString("Constructora");
                int numeroHabitantes = consulta.getInt("habitantes");
                String ciudad = consulta.getString("Ciudad");

                SegundoInformeVO informeProyecto = new SegundoInformeVO(id, constructora, numeroHabitantes, ciudad);
                informes.add(informeProyecto);
            }

            consulta.close();
            declaracion.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return informes;
    }

    public List<TercerInformeVO> consultarCompras() {
        String sql = """
                     SELECT c.ID_Compra AS id, Constructora, Banco_Vinculado AS banco FROM Proyecto p 
                     INNER JOIN Compra c ON p.ID_Proyecto = c.ID_Proyecto 
                     WHERE c.Proveedor = "Homecenter" AND p.Ciudad = "Salento"
                     """;
        List<TercerInformeVO> informeCompras = new ArrayList<>();

        try ( Connection connection = Conexion.getConnection()) {

            declaracion = connection.createStatement();
            consulta = declaracion.executeQuery(sql);

            while (consulta.next()) {
                int id = consulta.getInt("id");
                String constructora = consulta.getString("Constructora");
                String bancoVinculado = consulta.getString("banco");

                TercerInformeVO informeCompra = new TercerInformeVO(id, constructora, bancoVinculado);
                informeCompras.add(informeCompra);
            }

            consulta.close();
            declaracion.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        return informeCompras;
    }
}
