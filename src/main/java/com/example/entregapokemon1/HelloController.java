package com.example.entregapokemon1;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    Pokemon pokemonSeleccionado; //pasar un pokemon de una pantalla a otra

    Pokemon p1 = new Pokemon("Charizard","Nv 63",255, 255,new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\charizard-megay.gif"));
    Pokemon p2 = new Pokemon("Garbodor","Nv 49",180,180,new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\garbodor.gif"));
    Pokemon p3 = new Pokemon("Landorus ","Nv 68",235,235,new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\landorus.gif"));
    Pokemon p4 = new Pokemon("Sceptile ","Nv 54",259,259,new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\pikachu-unovacap.gif"));
    Pokemon p5 = new Pokemon("Suicune ","Nv 45",220,220,new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\suicune.gif"));
    Pokemon p6 = new Pokemon("Zapdos","Nv 54",280,280,new File("src\\main\\java\\com\\example\\entregapokemon1\\Imagenes\\zapdos.gif"));

    @FXML
    ImageView pokemonUno;
    @FXML
    AnchorPane bordePokemon1;
    @FXML
    Label nombre1;
    @FXML
    Label nivel1;
    @FXML
    Label vida1;
    @FXML
    ProgressBar progress1;

    @FXML
    ImageView pokemonDos;
    @FXML
    AnchorPane bordePokemon2;
    @FXML
    Label nombre2;
    @FXML
    Label nivel2;
    @FXML
    Label vida2;
    @FXML
    ProgressBar progress2;

    @FXML
    ImageView pokemonTres;
    @FXML
    AnchorPane bordePokemon3;
    @FXML
    Label nombre3;
    @FXML
    Label nivel3;
    @FXML
    Label vida3;
    @FXML
    ProgressBar progress3;

    @FXML
    ImageView pokemonCuatro;
    @FXML
    AnchorPane bordePokemon4;
    @FXML
    Label nombre4;
    @FXML
    Label nivel4;
    @FXML
    Label vida4;
    @FXML
    ProgressBar progress4;

    @FXML
    ImageView pokemonCinco;
    @FXML
    AnchorPane bordePokemon5;
    @FXML
    Label nombre5;
    @FXML
    Label nivel5;
    @FXML
    Label vida5;
    @FXML
    ProgressBar progress5;

    @FXML
    ImageView pokemonSeis;
    @FXML
    AnchorPane bordePokemon6;
    @FXML
    Label nombre6;
    @FXML
    Label nivel6;
    @FXML
    Label vida6;
    @FXML
    ProgressBar progress6;

    @FXML
    Button bt1;
    @FXML
    Text txt1;

    @FXML
    public void initialize() {

        Image imagen1 = new Image(p1.foto.toURI().toString());
        pokemonUno.setImage(imagen1);
        nombre1.setText(p1.nombre);
        nivel1.setText(p1.nivel);
        vida1.setText(String.valueOf(p1.vida));
        progress1.setProgress(calcularVida(p1));

        Image imagen2 = new Image(p2.foto.toURI().toString());
        pokemonDos.setImage(imagen2);
        nombre2.setText(p2.nombre);
        nivel2.setText(p2.nivel);
        vida2.setText(String.valueOf(p2.vida));
        progress2.setProgress(calcularVida(p2));

        Image imagen3 = new Image(p3.foto.toURI().toString());
        pokemonTres.setImage(imagen3);
        nombre3.setText(p3.nombre);
        nivel3.setText(p3.nivel);
        vida3.setText(String.valueOf(p3.vida));
        progress3.setProgress(calcularVida(p3));

        Image imagen4 = new Image(p4.foto.toURI().toString());
        pokemonCuatro.setImage(imagen4);
        nombre4.setText(p4.nombre);
        nivel4.setText(p4.nivel);
        vida4.setText(String.valueOf(p4.vida));
        progress4.setProgress(calcularVida(p4));

        Image imagen5 = new Image(p5.foto.toURI().toString());
        pokemonCinco.setImage(imagen5);
        nombre5.setText(p5.nombre);
        nivel5.setText(p5.nivel);
        vida5.setText(String.valueOf(p5.vida));
        progress5.setProgress(calcularVida(p5));

        Image imagen6 = new Image(p6.foto.toURI().toString());
        pokemonSeis.setImage(imagen6);
        nombre6.setText(p6.nombre);
        nivel6.setText(p6.nivel);
        vida6.setText(String.valueOf(p6.vida));
        progress6.setProgress(calcularVida(p6));

    }

    @FXML
    //Configurar pokemon al hacer click en uno
    protected void selectPokemon1() {
        System.out.println("ImagenSeleccionada");
        bordePokemon1.setStyle("-fx-background-color:#c76fed");
        bordePokemon2.setStyle("-fx-background-color:#675073");
        bordePokemon3.setStyle("-fx-background-color:#675073");
        bordePokemon4.setStyle("-fx-background-color:#675073");
        bordePokemon5.setStyle("-fx-background-color:#675073");
        bordePokemon6.setStyle("-fx-background-color:#675073");
        bt1.setText("SIGUIENTE");
        txt1.setText("Pokemon seleccionado");
        pokemonSeleccionado =p1;
    }

    @FXML
    //Configurar pokemon al hacer click en uno
    protected void selectPokemon2() {
        System.out.println("ImagenSeleccionada");
        bordePokemon1.setStyle("-fx-background-color:#675073");
        bordePokemon2.setStyle("-fx-background-color:#c76fed");
        bordePokemon3.setStyle("-fx-background-color:#675073");
        bordePokemon4.setStyle("-fx-background-color:#675073");
        bordePokemon5.setStyle("-fx-background-color:#675073");
        bordePokemon6.setStyle("-fx-background-color:#675073");
        bt1.setText("SIGUIENTE");
        txt1.setText("Pokemon seleccionado");
        pokemonSeleccionado =p2;
    }

    @FXML
    //Configurar pokemon al hacer click en uno
    protected void selectPokemon3() {
        System.out.println("ImagenSeleccionada");
        bordePokemon1.setStyle("-fx-background-color:#675073");
        bordePokemon2.setStyle("-fx-background-color:#675073");
        bordePokemon3.setStyle("-fx-background-color:#c76fed");
        bordePokemon4.setStyle("-fx-background-color:#675073");
        bordePokemon5.setStyle("-fx-background-color:#675073");
        bordePokemon6.setStyle("-fx-background-color:#675073");
        bt1.setText("SIGUIENTE");
        txt1.setText("Pokemon seleccionado");
        pokemonSeleccionado =p3;
    }

    @FXML
    //Configurar pokemon al hacer click en uno
    protected void selectPokemon4() {
        System.out.println("ImagenSeleccionada");
        bordePokemon1.setStyle("-fx-background-color:#675073");
        bordePokemon2.setStyle("-fx-background-color:#675073");
        bordePokemon3.setStyle("-fx-background-color:#675073");
        bordePokemon4.setStyle("-fx-background-color:#c76fed");
        bordePokemon5.setStyle("-fx-background-color:#675073");
        bordePokemon6.setStyle("-fx-background-color:#675073");
        bt1.setText("SIGUIENTE");
        txt1.setText("Pokemon seleccionado");
        pokemonSeleccionado =p4;
    }

    @FXML
    //Configurar pokemon al hacer click en uno
    protected void selectPokemon5() {
        System.out.println("ImagenSeleccionada");
        bordePokemon1.setStyle("-fx-background-color:#675073");
        bordePokemon2.setStyle("-fx-background-color:#675073");
        bordePokemon3.setStyle("-fx-background-color:#675073");
        bordePokemon4.setStyle("-fx-background-color:#675073");
        bordePokemon5.setStyle("-fx-background-color:#c76fed");
        bordePokemon6.setStyle("-fx-background-color:#675073");
        bt1.setText("SIGUIENTE");
        txt1.setText("Pokemon seleccionado");
        pokemonSeleccionado =p5;
    }

    @FXML
    //Configurar pokemon al hacer click en uno
    protected void selectPokemon6() {
        System.out.println("ImagenSeleccionada");
        bordePokemon1.setStyle("-fx-background-color:#675073");
        bordePokemon2.setStyle("-fx-background-color:#675073");
        bordePokemon3.setStyle("-fx-background-color:#675073");
        bordePokemon4.setStyle("-fx-background-color:#675073");
        bordePokemon5.setStyle("-fx-background-color:#675073");
        bordePokemon6.setStyle("-fx-background-color:#c76fed");
        bt1.setText("SIGUIENTE");
        txt1.setText("Pokemon seleccionado");
        pokemonSeleccionado =p6;
    }

    Stage stage2;

    @FXML
    protected void siguientePagina() {

        System.out.println("Boton pulsado pasamos al siguiente escenario");

        try {

            stage2 = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("interfaz2.fxml"));

            AnchorPane root =  loader.load();
            Scene scene = new Scene(root, 960, 727);

            stage2.setScene(scene);
            stage2.show();

            Ventana2Controller v = loader.getController();
            v.Pkm(pokemonSeleccionado);
            v.enviarDatos(this); //PASAR INFORMACION DE UN LADO A OTRO


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Float calcularVida(Pokemon pokemon){
        return Float.parseFloat(String.valueOf(pokemon.vidaRestante / pokemon.vida));
    }

    public void actualizarInterfaz( ){
        // ACTUALIZAR VIDA DE LA PRIMERA PANTALLA
       progress1.setProgress(p1.vidaRestante/p1.vida);
       progress2.setProgress(p2.vidaRestante/p2.vida);
       progress3.setProgress(p3.vidaRestante/p3.vida);
       progress4.setProgress(p4.vidaRestante/p4.vida);
       progress5.setProgress(p5.vidaRestante/p5.vida);
       progress6.setProgress(p6.vidaRestante/p6.vida);
    }

}

class Pokemon{

    String nombre;
    String nivel;
    float vida;
    float vidaRestante;
    File foto;

    public Pokemon(String nombre, String nivel, float vida, float vidaRestante,File foto){

        this.nombre=nombre;
        this.nivel=nivel;
        this.vida=vida;
        this.foto=foto;
        this.vidaRestante=vidaRestante;

    }

}