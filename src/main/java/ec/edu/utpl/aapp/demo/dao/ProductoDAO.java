/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.utpl.aapp.demo.dao;

import ec.edu.utpl.aapp.demo.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrador
 */
public class ProductoDAO {
    public static List<Producto> getProductos()
    {
        List<Producto> lista = new ArrayList();
        Producto producto = new Producto(1, "HARINA", 500);
        Producto producto2 = new Producto(2, "PASTA", 1500);
        lista.add(producto);
        lista.add(producto2);
        
        return lista;
    }
}
