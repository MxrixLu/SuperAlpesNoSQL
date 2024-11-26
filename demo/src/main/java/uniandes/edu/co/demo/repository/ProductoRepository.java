package uniandes.edu.co.demo.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.demo.modelo.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

    public interface RespuestaListarProductosReorden {
        String getNombre_producto();
        int getProducto_id();
        String getNombre_bodega();
        String getNombre_sucursal();
        int getCantidad_existente();
        String getNit_proveedor();
        
    }

    public interface RespuestaDarProductosPorCaracteristica {
        String getNombre();
        String getCodigo_barras();
        Double getCosto_bodega();
        Double getPrecio_venta();
        String getPresentacion();
        Double getCantidad_presentacion();
        int getUnidad_medida();
        Double getVolumen_empaque();
        Double getPeso_empaque();
        String getFecha_expiracion();
        int getCategoria_id();
    
        
    }

    // Obtener todos los productos
    @Query(value = "SELECT * FROM productos", nativeQuery = true)
    Collection<Producto> darProductos();

    @Query(value = "SELECT * FROM productos WHERE codigo_barras = :codigo_barras", nativeQuery = true)
    List<Producto> darPorCodigoBarras(@Param("codigo_barras") String codigo_barras);

    @Query(value = "SELECT * FROM productos WHERE id = :producto_id", nativeQuery = true)
    Producto darProducto(@Param("producto_id") int producto_id);
    
    
    // Insertar un nuevo producto
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO productos VALUES (superandes_sequence.nextval, :codigo_barras, :nombre, :costo_bodega, :precio_venta, :presentacion, :cantidad_presentacion, :unidad_medida, :volumen_empaque, :peso_empaque, TO_DATE(:fecha_expiracion,  'YYYY-MM-DD'), :categoria_id)", nativeQuery = true)
    void insertarProducto(
                          @Param("codigo_barras") String codigo_barras,
                          @Param("nombre") String nombre,
                          @Param("costo_bodega") Double costo_bodega,
                          @Param("precio_venta") Double precio_venta,
                          @Param("presentacion") String presentacion,
                          @Param("cantidad_presentacion") Double cantidad_presentacion,
                          @Param("unidad_medida") int unidad_medida,
                          @Param("volumen_empaque") Double volumen_empaque,
                          @Param("peso_empaque") Double peso_empaque,
                          @Param("fecha_expiracion") String fecha_expiracion,
                          @Param("categoria_id") int categoria_id);

    // Actualizar un producto existente
    @Modifying
    @Transactional
    @Query(value = "UPDATE productos SET nombre = :nombre, costo_bodega = :costo_bodega, precio_venta = :precio_venta, presentacion = :presentacion, cantidad_presentacion = :cantidad_presentacion, unidad_medida = :unidad_medida, volumen_empaque = :volumen_empaque, peso_empaque = :peso_empaque, fecha_expiracion = :fecha_expiracion, categoria_id = :categoria_id WHERE id = :id AND codigo_barras = :codigo_barras", nativeQuery = true)
    void actualizarProducto(@Param("id") int id,
                            @Param("codigo_barras") String codigo_barras,
                            @Param("nombre") String nombre,
                            @Param("costo_bodega") Double costo_bodega,
                            @Param("precio_venta") Double precio_venta,
                            @Param("presentacion") String presentacion,
                            @Param("cantidad_presentacion") Double cantidad_presentacion,
                            @Param("unidad_medida") int unidad_medida,
                            @Param("volumen_empaque") Double volumen_empaque,
                            @Param("peso_empaque") Double peso_empaque,
                            @Param("fecha_expiracion") String fecha_expiracion,
                            @Param("categoria_id") int idCategoria);

    // Borrar un producto por su clave primaria compuesta
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM productos WHERE id = :id AND codigo_barras = :codigo_barras", nativeQuery = true)
    void borrarProducto(@Param("id") int id, @Param("codigo_barras") String codigo_barras);


    @Query(value = "SELECT * FROM productos WHERE precio_venta BETWEEN :precioMinimo AND :precioMaximo AND fecha_expiracion BETWEEN :fechaInicio AND :fechaFin AND categoria_id = :idCategoria", nativeQuery = true)
    Collection<RespuestaDarProductosPorCaracteristica> darProductosPorCaracteristicas(@Param("precioMinimo") Double precioMinimo, @Param("precioMaximo") Double precioMaximo, @Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin, @Param("idCategoria") int idCategoria);

    @Query(value = "SELECT " +
               "p.nombre AS nombre_producto, " +
               "p.id AS producto_id, " +
               "b.nombre AS nombre_bodega, " +
               "s.nombre AS nombre_sucursal, " +
               "pb.cantidad_existente, " +
               "pro.NIT AS nit_proveedor " +
               "FROM productos p " +
               "INNER JOIN niveles_reorden nro ON nro.producto_id = p.id " +
               "INNER JOIN producto_bodega pb ON pb.producto_id = p.id " +
               "INNER JOIN bodegas b ON pb.bodega_id = b.id " +
               "INNER JOIN sucursales s ON s.id = b.sucursal_id " +
               "LEFT JOIN info_recepcion ir ON ir.producto_id = p.id " +
               "LEFT JOIN recepciones r ON ir.recepcion_id = r.id " +
               "LEFT JOIN proveedores pro ON r.proveedor_id = pro.id " +
               "WHERE pb.cantidad_existente < nro.nivel_minimo " +
               "ORDER BY nombre_producto, nombre_bodega", nativeQuery = true)
    Collection<RespuestaListarProductosReorden> listarProductosReorden();

}
