package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.repositorios.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ImagenServicio {

    private ImagenRepositorio imagenRepositorio;

    @Autowired
    public ImagenServicio(ImagenRepositorio imagenRepositorio) {
        this.imagenRepositorio = imagenRepositorio;
    }
    public Imagen guardar(MultipartFile archivo) {
        if(archivo != null){
            try{
                Imagen imagen = new Imagen();
                imagen.setNombre(archivo.getName());
                imagen.setMime(archivo.getContentType());
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }

    public Imagen actualizar(MultipartFile archivo, String id) {
        if(archivo != null){
            try{
                Imagen imagen = new Imagen();
                if(id != null){
                    Optional<Imagen> imagenSaved = imagenRepositorio.findById(id);

                    if(imagenSaved.isPresent()){
                        imagen = imagenSaved.get();
                    }
                }


                imagen.setNombre(archivo.getName());
                imagen.setMime(archivo.getContentType());
                imagen.setContenido(archivo.getBytes());
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.err.println(e.getMessage());
                e.printStackTrace();
            }
        }
        return null;
    }
}
