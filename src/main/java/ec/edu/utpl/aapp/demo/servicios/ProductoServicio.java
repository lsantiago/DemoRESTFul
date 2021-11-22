/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.utpl.aapp.demo.servicios;

import ec.edu.utpl.aapp.demo.dao.ProductoDAO;
import ec.edu.utpl.aapp.demo.modelo.Producto;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Administrador
 */

@Path("productos")
public class ProductoServicio {
    
    private static List<Producto> lista = ProductoDAO.getProductos();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProductos()
    {
        return Response.ok(lista).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducto(@PathParam("id") int id)
    {
        System.out.println(id);
        Producto producto = new Producto();
        producto.setId(id);
        
        if (lista.contains(producto)){
            for(Producto obj: lista)
                if(obj.getId() == id){
                   return Response.ok(obj).build();
                }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteProducto(@PathParam("id") int id)
    {
        System.out.println(id);
        Producto producto = new Producto();
        producto.setId(id);
        
        if (lista.contains(producto)){
            lista.remove(producto);
            return Response.ok().build();
                
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addProducto(Producto producto)
    {
        lista.add(producto);
        return Response.status(Response.Status.CREATED).entity(producto).build();
        
    }
}
