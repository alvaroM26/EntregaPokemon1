package com.example.entregapokemon1;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;

public class Ventana3Controller {

    Pokemon pokemonseleccionado;
    private HelloController HelloController;

    Implementaciones2 imp1 = new Implementaciones2(new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\flecha.png"),new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\boton.png"),new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\favorito.png"));

    @FXML
    ImageView imagePoke;
    @FXML
    Label nomPoke;
    @FXML
    Text descPoke;
    @FXML
    ImageView evolucion1;
    @FXML
    ImageView evolucion2;
    @FXML
    ImageView flecha;
    @FXML
    ImageView salir;
    @FXML
    ImageView estrellita;
    @FXML
    Label fav1;

   public void PKDX(Pokemon pokemonseleccionado){

       Image img1 = new Image(pokemonseleccionado.foto.toURI().toString());
       imagePoke.setImage(img1);
       nomPoke.setText("Pokemon" +pokemonseleccionado.nombre);
       descPoke.setText(pokemonseleccionado.descripcion);
       Image img2 = new Image(pokemonseleccionado.evolucion.toURI().toString());
       evolucion1.setImage(img2);
       Image img3 = new Image(pokemonseleccionado.foto.toURI().toString());
       evolucion2.setImage(img3);

       Image img4 = new Image(imp1.fl1.toURI().toString());
       flecha.setImage(img4);

       Image img5 = new Image(imp1.cn1.toURI().toString());
       salir.setImage(img5);

       Image img6 = new Image(imp1.fv1.toURI().toString());
       estrellita.setImage(img6);

       estrellita.setVisible(false);

   }

    @FXML
    protected void cerrarVentana() {
        HelloController.stage3.close();
    }

    @FXML
    protected void marcarfav() {
        estrellita.setVisible(true);
        HelloController.actualizarEstrellita();
    }

    void enviarDatosEstre(HelloController HelloController){
        this.HelloController=HelloController;
    }

}

class Implementaciones2 {

    File fl1;
    File cn1;
    File fv1;

    public Implementaciones2(File fl1, File cn1, File fv1) {
        this.fl1 = fl1;
        this.cn1 = cn1;
        this.fv1 = fv1;
    }

}